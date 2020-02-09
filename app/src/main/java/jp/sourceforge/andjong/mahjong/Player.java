package jp.sourceforge.andjong.mahjong;

/**
 * �v���C���[���Ǘ�����N���X�ł��B
 *
 * @author Yuji Urushibara
 *
 */
class Player {
	/** EventIF */
	private EventIf eventIf;

	/**
	 * EventIF���擾���܂��B�B
	 *
	 * @return EventIF
	 */
	EventIf getEventIf() {
		return eventIf;
	}

	/** ��v */
	private Tehai m_tehai = new Tehai();

	/**
	 * ��v���擾���܂��B
	 *
	 * @return ��v
	 */
	Tehai getTehai() {
		return m_tehai;
	}

	/** �� */
	private Hou kawa = new Hou();

	/**
	 * �͂��擾���܂��B
	 *
	 * @return ��
	 */
	Hou getKawa() {
		return kawa;
	}

	/** ���� */
	private int jikaze;

	/**
	 * �������擾���܂��B
	 *
	 * @return ����
	 */
	int getJikaze() {
		return jikaze;
	}

	/**
	 * ������ݒ肵�܂��B
	 *
	 * @param jikaze
	 *            ����
	 */
	void setJikaze(int jikaze) {
		this.jikaze = jikaze;
	}

	/** �_�_ */
	private int tenbou;

	/**
	 * �_�_���擾���܂��B
	 *
	 * @return
	 */
	int getTenbou() {
		return tenbou;
	}

	/**
	 * �_�_��ݒ肵�܂��B
	 *
	 * @param tenbou
	 *            �_�_
	 */
	void setTenbou(int tenbou) {
		this.tenbou = tenbou;
	}

	/**
	 * �_�_�𑝂₵�܂��B
	 *
	 * @param ten
	 *            �_
	 */
	void increaseTenbou(int ten) {
		tenbou += ten;
	}

	/**
	 * �_�_�����炵�܂��B
	 *
	 * @param ten
	 *            �_
	 */
	void reduceTenbou(int ten) {
		tenbou -= ten;
	}

	/** ���[�` */
	private boolean reach;

	/**
	 * ���[�`���擾���܂��B
	 *
	 * @return ���[�`
	 */
	boolean isReach() {
		return reach;
	}

	/**
	 * ���[�`��ݒ肵�܂��B
	 *
	 * @param reach
	 *            ���[�`
	 */
	void setReach(boolean reach) {
		this.reach = reach;
	}

	/** �_�u�����[�` */
	private boolean m_doubleReach;

	/**
	 * �_�u�����[�`���擾���܂��B
	 *
	 * @return �_�u�����[�`
	 */
	boolean isDoubleReach() {
		return m_doubleReach;
	}

	/**
	 * �_�u�����[�`��ݒ肵�܂��B
	 *
	 * @param reach
	 *            �_�u�����[�`
	 */
	void setDoubleReach(boolean a_doubleReach) {
		this.m_doubleReach = a_doubleReach;
	}

	private int m_suteHaisCount;
	void setSuteHaisCount(int a_suteHaisCount) {
		this.m_suteHaisCount = a_suteHaisCount;
	}
	int getSuteHaisCount() {
		return m_suteHaisCount;
	}

	private CountFormat m_countFormat = new CountFormat();

	boolean isTenpai() {
		if (reach) {
			return true;
		}

		Hai addHai;
		for (int id = 0; id < Hai.ID_ITEM_MAX; id++) {
			addHai = new Hai(id);
			m_countFormat.setCountFormat(m_tehai, addHai);
			if (m_countFormat.getCombis(null) > 0) {
				return true;
			}
		}

		return false;
	}

	/**
	 * �v���C���[������������B
	 *
	 * @param eventIf
	 *            EventIF
	 */
	Player(EventIf eventIf) {
		this.eventIf = eventIf;
	}

	/**
	 * �v���C���[�����������܂��B
	 */
	void init() {
		// ��v�����������܂��B
		m_tehai.initialize();

		// �͂����������܂��B
		kawa.initialize();

		// ���[�`�����������܂��B
		reach = false;

		m_ippatsu = false;
		m_doubleReach = false;
	}

	public void setIppatsu(boolean a_ippatsu) {
		this.m_ippatsu = a_ippatsu;
	}

	public boolean isIppatsu() {
		return m_ippatsu;
	}

	private boolean m_ippatsu;
}
