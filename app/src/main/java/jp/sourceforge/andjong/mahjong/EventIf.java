package jp.sourceforge.andjong.mahjong;

/**
 * �C�x���gIF���Ǘ�����N���X�ł��B
 *
 * @author Yuji Urushibara
 *
 */
public interface EventIf {
	/** �C�x���gID */
	enum EventId {
		/** �Q�[���̊J�n */
		START_GAME,
		/** �ǂ̊J�n */
		START_KYOKU,
		/** �c�� */
		TSUMO,
		/** �̔v�̑I�� */
		SELECT_SUTEHAI,
		/** �̔v */
		SUTEHAI,
		/** ���[�` */
		REACH,
		/** �|�� */
		PON,
		/** �`�[(��) */
		CHII_LEFT,
		/** �`�[(����) */
		CHII_CENTER,
		/** �`�[(�E) */
		CHII_RIGHT,
		/** �喾�� */
		DAIMINKAN,
		/** ���� */
		KAN,
		/** �Þ� */
		ANKAN,
		/** �c�������� */
		TSUMO_AGARI,
		/** ���������� */
		RON_AGARI,
		/** ���� */
		NAGASHI,
		/** ���� */
		RYUUKYOKU,
		/** �ǂ̏I�� */
		END_KYOKU,
		/** �Q�[���̏I�� */
		END_GAME,

		/** �����̃`�F�b�N */
		RON_CHECK,

		/** ���v�҂� */
		UI_WAIT_RIHAI,
		/** �i�s�҂� */
		UI_WAIT_PROGRESS,
		/** �v���C���[�A�N�V�����̓��� */
		UI_INPUT_PLAYER_ACTION
	}

	/** ��(��) */
	public final static int KAZE_TON = 0;
	/** ��(��) */
	public final static int KAZE_NAN = 1;
	/** ��(��) */
	public final static int KAZE_SHA = 2;
	/** ��(�k) */
	public final static int KAZE_PE = 3;
	/** ���̎�ނ̌� */
	public final static int KAZE_KIND_NUM = KAZE_PE + 1;
	/** ��(�Ȃ�) */
	public final static int KAZE_NONE = 4;

	/**
	 * �C�x���gIF�̖��O���擾����B
	 *
	 * @return �C�x���gIF�̖��O
	 */
	public String getName();

	/**
	 * �̔v�̃C���f�b�N�X���擾���܂��B
	 *
	 * @return �̔v�̃C���f�b�N�X
	 */
	int getISutehai();

	/**
	 * �C�x���g����������B
	 *
	 * @param a_eventId
	 *            �C�x���gID
	 * @param a_kazeFrom
	 *            �C�x���g�𔭍s������
	 * @param a_kazeTo
	 *            �C�x���g�̑ΏۂƂȂ�����
	 * @return �C�x���gID
	 */
	EventId event(EventId a_eventId, int a_kazeFrom, int a_kazeTo);
}
