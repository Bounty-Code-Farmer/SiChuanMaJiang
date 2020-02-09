package jp.sourceforge.andjong.mahjong;

/**
 * �v���Ǘ�����B
 *
 * @author Yuji Urushibara
 *
 */
public class Hai {
	/*
	 * ID
	 */

	/** ���� */
	public final static int ID_WAN_1 = 0;
	/** ���� */
	public final static int ID_WAN_2 = 1;
	/** �O�� */
	public final static int ID_WAN_3 = 2;
	/** �l�� */
	public final static int ID_WAN_4 = 3;
	/** ���� */
	public final static int ID_WAN_5 = 4;
	/** �Z�� */
	public final static int ID_WAN_6 = 5;
	/** ���� */
	public final static int ID_WAN_7 = 6;
	/** ���� */
	public final static int ID_WAN_8 = 7;
	/** ���� */
	public final static int ID_WAN_9 = 8;

	/** �ꓛ */
	public final static int ID_PIN_1 = 9;
	/** �� */
	public final static int ID_PIN_2 = 10;
	/** �O�� */
	public final static int ID_PIN_3 = 11;
	/** �l�� */
	public final static int ID_PIN_4 = 12;
	/** �ܓ� */
	public final static int ID_PIN_5 = 13;
	/** �Z�� */
	public final static int ID_PIN_6 = 14;
	/** ���� */
	public final static int ID_PIN_7 = 15;
	/** ���� */
	public final static int ID_PIN_8 = 16;
	/** �㓛 */
	public final static int ID_PIN_9 = 17;

	/** ��� */
	public final static int ID_SOU_1 = 18;
	/** ��� */
	public final static int ID_SOU_2 = 19;
	/** �O�� */
	public final static int ID_SOU_3 = 20;
	/** �l�� */
	public final static int ID_SOU_4 = 21;
	/** �܍� */
	public final static int ID_SOU_5 = 22;
	/** �Z�� */
	public final static int ID_SOU_6 = 23;
	/** ���� */
	public final static int ID_SOU_7 = 24;
	/** ���� */
	public final static int ID_SOU_8 = 25;
	/** ��� */
	public final static int ID_SOU_9 = 26;

	/** �� */
	public final static int ID_TON = 27;
	/** �� */
	public final static int ID_NAN = 28;
	/** �� */
	public final static int ID_SHA = 29;
	/** �k */
	public final static int ID_PE = 30;

	/** �� */
	public final static int ID_HAKU = 31;
	/** � */
	public final static int ID_HATSU = 32;
	/** �� */
	public final static int ID_CHUN = 33;

	/** ID�̍ő�l */
	public final static int ID_MAX = ID_CHUN;

	/** ID�̌��̍ő�l */
	public final static int ID_ITEM_MAX = ID_MAX + 1;

	/*
	 * NO
	 */

	/** 1 */
	public final static int NO_1 = 1;
	/** 2 */
	public final static int NO_2 = 2;
	/** 3 */
	public final static int NO_3 = 3;
	/** 4 */
	public final static int NO_4 = 4;
	/** 5 */
	public final static int NO_5 = 5;
	/** 6 */
	public final static int NO_6 = 6;
	/** 7 */
	public final static int NO_7 = 7;
	/** 8 */
	public final static int NO_8 = 8;
	/** 9 */
	public final static int NO_9 = 9;

	/** ���� */
	public final static int NO_WAN_1 = 1;
	/** ���� */
	public final static int NO_WAN_2 = 2;
	/** �O�� */
	public final static int NO_WAN_3 = 3;
	/** �l�� */
	public final static int NO_WAN_4 = 4;
	/** ���� */
	public final static int NO_WAN_5 = 5;
	/** �Z�� */
	public final static int NO_WAN_6 = 6;
	/** ���� */
	public final static int NO_WAN_7 = 7;
	/** ���� */
	public final static int NO_WAN_8 = 8;
	/** ���� */
	public final static int NO_WAN_9 = 9;

	/** �ꓛ */
	public final static int NO_PIN_1 = 1;
	/** �� */
	public final static int NO_PIN_2 = 2;
	/** �O�� */
	public final static int NO_PIN_3 = 3;
	/** �l�� */
	public final static int NO_PIN_4 = 4;
	/** �ܓ� */
	public final static int NO_PIN_5 = 5;
	/** �Z�� */
	public final static int NO_PIN_6 = 6;
	/** ���� */
	public final static int NO_PIN_7 = 7;
	/** ���� */
	public final static int NO_PIN_8 = 8;
	/** �㓛 */
	public final static int NO_PIN_9 = 9;

	/** ��� */
	public final static int NO_SOU_1 = 1;
	/** ��� */
	public final static int NO_SOU_2 = 2;
	/** �O�� */
	public final static int NO_SOU_3 = 3;
	/** �l�� */
	public final static int NO_SOU_4 = 4;
	/** �܍� */
	public final static int NO_SOU_5 = 5;
	/** �Z�� */
	public final static int NO_SOU_6 = 6;
	/** ���� */
	public final static int NO_SOU_7 = 7;
	/** ���� */
	public final static int NO_SOU_8 = 8;
	/** ��� */
	public final static int NO_SOU_9 = 9;

	/** �� */
	public final static int NO_TON = 1;
	/** �� */
	public final static int NO_NAN = 2;
	/** �� */
	public final static int NO_SHA = 3;
	/** �k */
	public final static int NO_PE = 4;

	/** �� */
	public final static int NO_HAKU = 1;
	/** � */
	public final static int NO_HATSU = 2;
	/** �� */
	public final static int NO_CHUN = 3;

	/*
	 * ���
	 */

	/** �ݎq */
	public final static int KIND_WAN = 0x00000010;
	/** ���q */
	public final static int KIND_PIN = 0x00000020;
	/** ���q */
	public final static int KIND_SOU = 0x00000040;
	/** ���v */
	public final static int KIND_SHUU = KIND_WAN | KIND_PIN | KIND_SOU;
	/** ���v */
	public final static int KIND_FON = 0x00000100;
	/** �O���v */
	public final static int KIND_SANGEN = 0x00000200;
	/** ���v */
	public final static int KIND_TSUU = KIND_FON | KIND_SANGEN;

	/** �ԍ��̔z�� */
	private final static int[] NOS = {
	// �ݎq
	NO_WAN_1, NO_WAN_2, NO_WAN_3, NO_WAN_4, NO_WAN_5, NO_WAN_6, NO_WAN_7, NO_WAN_8, NO_WAN_9,
	// ���q
	NO_PIN_1, NO_PIN_2, NO_PIN_3, NO_PIN_4, NO_PIN_5, NO_PIN_6, NO_PIN_7, NO_PIN_8, NO_PIN_9,
	// ���q
	NO_SOU_1, NO_SOU_2, NO_SOU_3, NO_SOU_4, NO_SOU_5, NO_SOU_6, NO_SOU_7, NO_SOU_8, NO_SOU_9,
	// ���v
	NO_TON, NO_NAN, NO_SHA, NO_PE,
	// �O���v
	NO_HAKU, NO_HATSU, NO_CHUN };

	/** ��ނ̔z�� */
	private final static int[] KINDS = {
	// �ݎq
	KIND_WAN, KIND_WAN, KIND_WAN, KIND_WAN, KIND_WAN, KIND_WAN, KIND_WAN, KIND_WAN, KIND_WAN,
	// ���q
	KIND_PIN, KIND_PIN, KIND_PIN, KIND_PIN, KIND_PIN, KIND_PIN, KIND_PIN, KIND_PIN, KIND_PIN,
	// ���q
	KIND_SOU, KIND_SOU, KIND_SOU, KIND_SOU, KIND_SOU, KIND_SOU, KIND_SOU, KIND_SOU, KIND_SOU,
	// ���v
	KIND_FON, KIND_FON, KIND_FON, KIND_FON,
	// �O���v
	KIND_SANGEN, KIND_SANGEN, KIND_SANGEN };

	/** ���v�t���O�̔z�� */
	private final static boolean[] IS_ICHIKYUUS = {
	// �ݎq
	true, false, false, false, false, false, false, false, true,
	// ���q
	true, false, false, false, false, false, false, false, true,
	// ���q
	true, false, false, false, false, false, false, false, true,
	// ���v
	false, false, false, false,
	// �O���v
	false, false, false };

	/** ���v�t���O�̔z�� */
	private final static boolean[] IS_TSUUS = {
	// �ݎq
	false, false, false, false, false, false, false, false, false,
	// ���q
	false, false, false, false, false, false, false, false, false,
	// ���q
	false, false, false, false, false, false, false, false, false,
	// ���v
	true, true, true, true,
	// �O���v
	true, true, true };

	/** �l�N�X�g�v��ID�̔z�� */
	private final static int[] NEXT_HAI_IDS = {
	// �ݎq
	ID_WAN_2, ID_WAN_3, ID_WAN_4, ID_WAN_5, ID_WAN_6, ID_WAN_7, ID_WAN_8, ID_WAN_9, ID_WAN_1,
	// ���q
	ID_PIN_2, ID_PIN_3, ID_PIN_4, ID_PIN_5, ID_PIN_6, ID_PIN_7, ID_PIN_8, ID_PIN_9, ID_PIN_1,
	// ���q
	ID_SOU_2, ID_SOU_3, ID_SOU_4, ID_SOU_5, ID_SOU_6, ID_SOU_7, ID_SOU_8, ID_SOU_9, ID_SOU_1,
	// ���v
	ID_NAN, ID_SHA, ID_PE, ID_TON,
	// �O���v
	ID_HATSU, ID_CHUN, ID_HAKU };

	/** ID */
	private int m_id;

	/**
	 * ��̔v���쐬����B
	 */
	public Hai() {
	}

	/**
	 * ID����v���쐬����B
	 *
	 * @param a_id
	 *            ID
	 */
	public Hai(int a_id) {
		this.m_id = a_id;
		this.m_red = false;
	}

	/**
	 * ID�Ɛԃh������v���쐬����B
	 *
	 * @param a_id
	 *            ID
	 * @param a_red
	 *            �ԃh��
	 */
	public Hai(int a_id, boolean a_red) {
		this.m_id = a_id;
		this.m_red = a_red;
	}

	/**
	 * �v����v���쐬����B
	 *
	 * @param a_hai
	 *            �v
	 */
	public Hai(Hai a_hai) {
		copy(this, a_hai);
	}

	/**
	 * �v���R�s�[����B
	 *
	 * @param a_dest
	 *            �R�s�[��̔v
	 * @param a_src
	 *            �R�s�[���̔v
	 */
	public static void copy(Hai a_dest, Hai a_src) {
		a_dest.m_id = a_src.m_id;
		a_dest.m_red = a_src.m_red;
	}

	/**
	 * ID���擾����B
	 *
	 * @return ID
	 */
	public int getId() {
		return m_id;
	}

	/**
	 * �ԍ����擾����B
	 *
	 * @return �ԍ�
	 */
	public int getNo() {
		return NOS[m_id];
	}

	/**
	 * ��ނ��擾����B
	 *
	 * @return ���
	 */
	public int getKind() {
		return KINDS[m_id];
	}

	/**
	 * NK(�ԍ��Ǝ�ނ�OR)���擾����B
	 *
	 * @return NK(�ԍ��Ǝ�ނ�OR)
	 */
	public int getNoKind() {
		return NOS[m_id] | KINDS[m_id];
	}

	/**
	 * ���v�t���O���擾����B
	 *
	 * @return ���v�t���O
	 */
	public boolean isIchikyuu() {
		return IS_ICHIKYUUS[m_id];
	}

	/**
	 * ���v�t���O���擾����B
	 *
	 * @return ���v�t���O
	 */
	public boolean isTsuu() {
		return IS_TSUUS[m_id];
	}

	/**
	 * ���v�t���O���擾����B
	 *
	 * @param a_noKind
	 *            NK(�ԍ��Ǝ�ނ�OR)
	 * @return ���v�t���O
	 */
	public static boolean isTsuu(int a_noKind) {
		return (a_noKind & KIND_TSUU) != 0;
	}

	/**
	 * ��㎚�v�t���O���擾����B
	 *
	 * @return ��㎚�v�t���O
	 */
	public boolean isYaochuu() {
		return IS_ICHIKYUUS[m_id] | IS_TSUUS[m_id];
	}

	/**
	 * �l�N�X�g�v��ID���擾����B
	 *
	 * @return �l�N�X�g�v��ID
	 */
	public int getNextHaiId() {
		return NEXT_HAI_IDS[m_id];
	}

	/**
	 * NK(�ԍ��Ǝ�ނ�OR)��ID�ɕϊ�����B
	 *
	 * @param a_noKind
	 *            NK(�ԍ��Ǝ�ނ�OR)
	 * @return ID
	 */
	public static int noKindToId(int a_noKind) {
		int id;
		if (a_noKind >= KIND_SANGEN) {
			id = a_noKind - KIND_SANGEN + ID_HAKU - 1;
		} else if (a_noKind >= KIND_FON) {
			id = a_noKind - KIND_FON + ID_TON - 1;
		} else if (a_noKind >= KIND_SOU) {
			id = a_noKind - KIND_SOU + ID_SOU_1 - 1;
		} else if (a_noKind >= KIND_PIN) {
			id = a_noKind - KIND_PIN + ID_PIN_1 - 1;
		} else {
			id = a_noKind - KIND_WAN + ID_WAN_1 - 1;
		}
		return id;
	}

	/** �ԃh�� */
	private boolean m_red;

	/**
	 * �ԃh����ݒ肷��B
	 *
	 * @param a_red
	 *            �ԃh��
	 */
	public void setRed(boolean a_red) {
		this.m_red = a_red;
	}

	/**
	 * �ԃh�����擾����B
	 *
	 * @return �ԃh��
	 */
	public boolean isRed() {
		return m_red;
	}
}
