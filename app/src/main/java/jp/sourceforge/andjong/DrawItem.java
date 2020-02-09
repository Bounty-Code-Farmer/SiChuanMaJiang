package jp.sourceforge.andjong;

import android.content.res.Resources;
import jp.sourceforge.andjong.mahjong.Hai;
import jp.sourceforge.andjong.mahjong.Hou;
import jp.sourceforge.andjong.mahjong.Mahjong;
import jp.sourceforge.andjong.mahjong.Tehai;
import jp.sourceforge.andjong.mahjong.EventIf.EventId;

/**
 * �`��A�C�e�����Ǘ�����B
 *
 * @author Yuji Urushibara
 *
 */
public class DrawItem {
	/** �������҂� */
	public static final int STATE_INIT_WAIT = 0;
	/** ��ԂȂ� */
	public static final int STATE_NONE = 1;
	/** �ǂ̊J�n */
	public static final int STATE_KYOKU_START = 2;
	/** �v���C */
	public static final int STATE_PLAY = 3;
	/** ���v�҂� */
	public static final int STATE_RIHAI_WAIT = 4;
	/** ���[�` */
	public static final int STATE_REACH = 5;
	/** �c�� */
	public static final int STATE_TSUMO = 6;
	/** ���� */
	public static final int STATE_RON = 7;
	/** ���� */
	public static final int STATE_RYUUKYOKU = 8;
	/** ���� */
	public static final int STATE_RESULT = 9;
	/** �I�� */
	public static final int STATE_END = 10;

	/** ��� */
	int m_state = STATE_INIT_WAIT;

	/** �ǂ̕����� */
	private String m_kyokuString = null;

	/** ���[�`�_�̐� */
	private int m_reachbou = 0;

	/** �{�� */
	private int m_honba = 0;

	/** �N�� */
	private int m_chiicha = 0;

	/** ��v����̂Ă��v�̃C���f�b�N�X */
	private int m_iSkip = 0;

	/**
	 * �ǂ̕������ݒ肷��B
	 *
	 * @param a_kyoku
	 *            ��
	 */
	public synchronized void setKyokuString(Resources a_resources, int a_kyoku) {
		if (a_kyoku > Mahjong.KYOKU_NAN_4) {
			m_kyokuString = null;
			return;
		}

		String[] kyokuStrings = a_resources.getStringArray(R.array.kyoku);
		m_kyokuString = kyokuStrings[a_kyoku];
	}

	/**
	 * �ǂ̕�������擾����B
	 *
	 * @return �ǂ̕�����
	 */
	public synchronized String getKyokuString() {
		return m_kyokuString;
	}

	/**
	 * ���[�`�_�̐���ݒ肷��B
	 *
	 * @param a_reachbou
	 *            ���[�`�_�̐�
	 */
	public synchronized void setReachbou(int a_reachbou) {
		this.m_reachbou = a_reachbou;
	}

	/**
	 * ���[�`�_�̐����擾����B
	 *
	 * @return ���[�`�_�̐�
	 */
	public synchronized int getReachbou() {
		return m_reachbou;
	}

	/**
	 * �{���ݒ肷��B
	 *
	 * @param a_honba
	 *            �{��
	 */
	public synchronized void setHonba(int a_honba) {
		this.m_honba = a_honba;
	}

	/**
	 * �{����擾����B
	 *
	 * @return �{��
	 */
	public synchronized int getHonba() {
		return m_honba;
	}

	/**
	 * �N�Ƃ�ݒ肷��B
	 *
	 * @param a_chiicha
	 *            �N��
	 */
	public synchronized void setChiicha(int a_chiicha) {
		this.m_chiicha = a_chiicha;
	}

	/**
	 * �N�Ƃ��擾����B
	 *
	 * @return �N��
	 */
	public synchronized int getChiicha() {
		return m_chiicha;
	}

	/**
	 * ��v����̂Ă��v�̃C���f�b�N�X��ݒ肷��B
	 *
	 * @param a_iSkip
	 *            ��v����̂Ă��v�̃C���f�b�N�X
	 */
	public synchronized void setSkipIdx(int a_iSkip) {
		this.m_iSkip = a_iSkip;
	}

	/**
	 * ��v����̂Ă��v�̃C���f�b�N�X���擾����B
	 *
	 * @return ��v����̂Ă��v�̃C���f�b�N�X
	 */
	public synchronized int getISkip() {
		return m_iSkip;
	}

	/**
	 * ��Ԃ�ݒ肷��B
	 *
	 * @param m_state
	 *            ���
	 */
	synchronized void setState(int m_state) {
		this.m_state = m_state;
	}

	/**
	 * ��Ԃ��擾����B
	 *
	 * @return ���
	 */
	synchronized int getState() {
		return m_state;
	}

	public class PlayerInfo {
		/** ��v */
		Tehai m_tehai = new Tehai();
		/** �� */
		Hou m_kawa = new Hou();
		/** �c���v */
		Hai m_tsumoHai;
		/** �_�_ */
		int m_tenbo;
		boolean m_tenpai;
	}

	/** �v���C���[��� */
	PlayerInfo m_playerInfos[] = new PlayerInfo[4];

	/** �f�o�b�O�t���O */
	boolean m_isDebug = false;

	/** �C�x���gID */
	EventId m_eventId;

	int m_kazeFrom;
	int m_kazeTo;

	Hai m_suteHai = new Hai();

	boolean m_isManReach = false;

	{
		for (int i = 0; i < 4; i++) {
			m_playerInfos[i] = new PlayerInfo();
		}
	}

	int m_tsumoRemain = 0;
}
