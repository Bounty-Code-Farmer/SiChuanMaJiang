package jp.sourceforge.andjong.mahjong;

/**
 * �͂��Ǘ�����B
 *
 * @author Yuji Urushibara
 *
 */
public class Hou {
	/** �̔v�̔z��̒����̍ő�l */
	public final static int SUTE_HAIS_LENGTH_MAX = 24;

	/** �̔v�̔z�� */
	private SuteHai[] m_suteHais = new SuteHai[SUTE_HAIS_LENGTH_MAX];

	/** �̔v�̔z��̒��� */
	private int m_suteHaisLength = 0;

	{
		for (int i = 0; i < SUTE_HAIS_LENGTH_MAX; i++) {
			m_suteHais[i] = new SuteHai();
		}
	}

	/**
	 * �͂��쐬����B
	 */
	public Hou() {
		initialize();
	}

	/**
	 * �͂�����������B
	 */
	public void initialize() {
		m_suteHaisLength = 0;
	}

	/**
	 * �͂��R�s�[����B
	 *
	 * @param a_dest
	 *            �R�s�[��̉�
	 * @param a_src
	 *            �R�s�[���̉�
	 */
	public static void copy(Hou a_dest, Hou a_src) {
		a_dest.m_suteHaisLength = a_src.m_suteHaisLength;
		for (int i = 0; i < a_dest.m_suteHaisLength; i++) {
			SuteHai.copy(a_dest.m_suteHais[i], a_src.m_suteHais[i]);
		}
	}

	/**
	 * �̔v�̔z����擾����B
	 *
	 * @return �̔v�̔z��
	 */
	public SuteHai[] getSuteHais() {
		return m_suteHais;
	}

	/**
	 * �̔v�̔z��̒������擾����B
	 *
	 * @return �̔v�̔z��̒���
	 */
	public int getSuteHaisLength() {
		return m_suteHaisLength;
	}

	/**
	 * �̔v�̔z��ɔv��ǉ�����B
	 *
	 * @param a_hai
	 *            �ǉ�����v
	 */
	public boolean add(Hai a_hai) {
		if (m_suteHaisLength >= SUTE_HAIS_LENGTH_MAX) {
			return false;
		}

		SuteHai.copy(m_suteHais[m_suteHaisLength], a_hai);
		m_suteHaisLength++;

		return true;
	}

	/**
	 * �̔v�̔z��̍Ō�̔v�ɁA���t���O��ݒ肷��B
	 *
	 * @param a_naki
	 *            ���t���O
	 */
	public boolean setNaki(boolean a_naki) {
		if (m_suteHaisLength <= 0) {
			return false;
		}

		m_suteHais[m_suteHaisLength - 1].setNaki(a_naki);

		return true;
	}

	/**
	 * �̔v�̔z��̍Ō�̔v�ɁA���[�`�t���O��ݒ肷��B
	 *
	 * @param a_reach
	 *            ���[�`�t���O
	 */
	public boolean setReach(boolean a_reach) {
		if (m_suteHaisLength <= 0) {
			return false;
		}

		m_suteHais[m_suteHaisLength - 1].setReach(a_reach);

		return true;
	}

	/**
	 * �̔v�̔z��̍Ō�̔v�ɁA��o���t���O��ݒ肷��B
	 *
	 * @param a_tedashi
	 *            ��o���t���O
	 */
	public boolean setTedashi(boolean a_tedashi) {
		if (m_suteHaisLength <= 0) {
			return false;
		}

		m_suteHais[m_suteHaisLength - 1].setTedashi(a_tedashi);

		return true;
	}
}
