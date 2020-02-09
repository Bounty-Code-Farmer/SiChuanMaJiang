package jp.sourceforge.andjong.mahjong;

import java.util.Random;

/**
 * �R���Ǘ�����B
 *
 * @author Yuji Urushibara
 *
 */
public class Yama {
	/** �R�v�̔z��̍ő吔 */
	private final static int YAMA_HAIS_MAX = 136;

	/** �c���v�̔z��̍ő吔 */
	private final static int TSUMO_HAIS_MAX = 122;

	/** �����V�����v�̔z��̍ő吔 */
	private final static int RINSHAN_HAIS_MAX = 4;

	/** �e�h���v�̔z��̍ő吔 */
	public final static int DORA_HAIS_MAX = RINSHAN_HAIS_MAX + 1;

	/** �R�v�̔z�� */
	private Hai[] m_yamaHais = new Hai[YAMA_HAIS_MAX];

	/** �c���v�̔z�� */
	private Hai[] m_tsumoHais = new Hai[TSUMO_HAIS_MAX];

	/** �����V�����v�̔z�� */
	private Hai[] m_rinshanHais = new Hai[RINSHAN_HAIS_MAX];

	/** �����V�����v�̈ʒu */
	private int m_iRinshanHais;

	/** �c���v�̃C���f�b�N�X */
	private int m_iTsumoHais;

	/** �\�h���v�̔z�� */
	private Hai[] m_omoteDoraHais = new Hai[DORA_HAIS_MAX];

	/** ���h���v�̔z�� */
	private Hai[] m_uraDoraHais = new Hai[DORA_HAIS_MAX];

	{
		for (int i = Hai.ID_WAN_1; i < Hai.ID_ITEM_MAX; i++) {
			for (int j = 0; j < 4; j++) {
				m_yamaHais[(i * 4) + j] = new Hai(i);
			}
		}
	}

	/**
	 * �R���쐬����B
	 */
	Yama() {
		setTsumoHaisStartIndex(0);
	}

	/**
	 * ���v����B
	 */
	void xipai() {
		Random random = new Random();
		Hai temp;

		for (int i = 0, j; i < YAMA_HAIS_MAX; i++) {
			j = random.nextInt(YAMA_HAIS_MAX);
			temp = m_yamaHais[i];
			m_yamaHais[i] = m_yamaHais[j];
			m_yamaHais[j] = temp;
		}
	}

	/**
	 * �c���v���擾����B
	 *
	 * @return �c���v
	 */
	Hai tsumo() {
		if (m_iTsumoHais >= (TSUMO_HAIS_MAX - m_iRinshanHais)) {
			return null;
		}

		Hai tsumoHai = new Hai(m_tsumoHais[m_iTsumoHais]);
		m_iTsumoHais++;

		return tsumoHai;
	}

	/**
	 * �����V�����v���擾����B
	 *
	 * @return �����V�����v
	 */
	Hai rinshanTsumo() {
		if (m_iRinshanHais >= RINSHAN_HAIS_MAX) {
			return null;
		}

		Hai rinshanHai = new Hai(m_rinshanHais[m_iRinshanHais]);
		m_iRinshanHais++;

		return rinshanHai;
	}

	/**
	 * �\�h���̔z����擾����B
	 *
	 * @return �\�h���̔z��
	 */
	Hai[] getOmoteDoraHais() {
		int omoteDoraHaisLength = m_iRinshanHais + 1;
		Hai[] omoteDoraHais = new Hai[omoteDoraHaisLength];

		for (int i = 0; i < omoteDoraHaisLength; i++) {
			omoteDoraHais[i] = new Hai(this.m_omoteDoraHais[i]);
		}

		return omoteDoraHais;
	}

	/**
	 * ���h���̔z����擾����B
	 *
	 * @return ���h���̔z��
	 */
	Hai[] getUraDoraHais() {
		int uraDoraHaisLength = m_iRinshanHais + 1;
		Hai[] uraDoraHais = new Hai[uraDoraHaisLength];

		for (int i = 0; i < uraDoraHaisLength; i++) {
			uraDoraHais[i] = new Hai(this.m_uraDoraHais[i]);
		}

		return uraDoraHais;
	}

	Hai[] getAllDoraHais() {
		int omoteDoraHaisLength = m_iRinshanHais + 1;
		int uraDoraHaisLength = m_iRinshanHais + 1;
		int allDoraHaisLength = omoteDoraHaisLength + uraDoraHaisLength;
		Hai[] allDoraHais = new Hai[allDoraHaisLength];

		for (int i = 0; i < omoteDoraHaisLength; i++) {
			allDoraHais[i] = new Hai(this.m_omoteDoraHais[i]);
		}

		for (int i = 0; i < uraDoraHaisLength; i++) {
			allDoraHais[omoteDoraHaisLength + i] = new Hai(this.m_uraDoraHais[i]);
		}

		return allDoraHais;
	}

	/**
	 * �c���v�̊J�n�ʒu��ݒ肷��B
	 *
	 * @param a_tsumoHaiStartIndex
	 *            �c���v�̊J�n�ʒu
	 */
	boolean setTsumoHaisStartIndex(int a_tsumoHaiStartIndex) {
		if (a_tsumoHaiStartIndex >= YAMA_HAIS_MAX) {
			return false;
		}

		int yamaHaisIdx = a_tsumoHaiStartIndex;

		for (int i = 0; i < TSUMO_HAIS_MAX; i++) {
			m_tsumoHais[i] = m_yamaHais[yamaHaisIdx];

			yamaHaisIdx++;
			if (yamaHaisIdx >= YAMA_HAIS_MAX) {
				yamaHaisIdx = 0;
			}
		}

		m_iTsumoHais = 0;

		for (int i = 0; i < RINSHAN_HAIS_MAX; i++) {
			m_rinshanHais[i] = m_yamaHais[yamaHaisIdx];

			yamaHaisIdx++;
			if (yamaHaisIdx >= YAMA_HAIS_MAX) {
				yamaHaisIdx = 0;
			}
		}

		m_iRinshanHais = 0;

		for (int i = 0; i < DORA_HAIS_MAX; i++) {
			m_omoteDoraHais[i] = m_yamaHais[yamaHaisIdx];

			yamaHaisIdx++;
			if (yamaHaisIdx >= YAMA_HAIS_MAX) {
				yamaHaisIdx = 0;
			}

			m_uraDoraHais[i] = m_yamaHais[yamaHaisIdx];

			yamaHaisIdx++;
			if (yamaHaisIdx >= YAMA_HAIS_MAX) {
				yamaHaisIdx = 0;
			}
		}

		return true;
	}

	/**
	 * �c���v�̎c�萔���擾����B
	 *
	 * @return �c���v�̎c�萔
	 */
	int getTsumoNokori() {
		return TSUMO_HAIS_MAX - m_iTsumoHais - m_iRinshanHais;
	}

	/**
	 * �ԃh����ݒ肷��B
	 *
	 * @param a_id
	 *            ID
	 * @param a_num
	 *            ��
	 */
	void setRedDora(int a_id, int a_num) {
		if (a_num <= 0) {
			return;
		}

		for (int i = 0; i < m_yamaHais.length; i++) {
			if (m_yamaHais[i].getId() == a_id) {
				m_yamaHais[i].setRed(true);
				a_num--;
				if (a_num <= 0) {
					break;
				}
			}
		}
	}
}
