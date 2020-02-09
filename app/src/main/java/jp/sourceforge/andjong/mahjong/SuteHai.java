package jp.sourceforge.andjong.mahjong;

/**
 * �̔v���Ǘ�����B
 *
 * @author Yuji Urushibara
 *
 */
public class SuteHai extends Hai {
	/** ���t���O */
	private boolean m_naki = false;

	/** ���[�`�t���O */
	private boolean m_reach = false;

	/** ��o���t���O */
	private boolean m_tedashi = false;

	/**
	 * �̔v���쐬����B
	 */
	public SuteHai() {
		super();
	}

	/**
	 * ID����̔v���쐬����B
	 *
	 * @param a_id
	 *            ID
	 */
	public SuteHai(int a_id) {
		super(a_id);
	}

	/**
	 * �v����̔v���쐬����B
	 *
	 * @param a_hai
	 *            �v
	 */
	public SuteHai(Hai a_hai) {
		super(a_hai);
	}

	/**
	 * �̔v���R�s�[����B
	 *
	 * @param a_dest
	 *            �R�s�[��̎̔v
	 * @param a_src
	 *            �R�s�[���̎̔v
	 */
	public static void copy(SuteHai a_dest, SuteHai a_src) {
		Hai.copy(a_dest, a_src);
		a_dest.m_naki = a_src.m_naki;
		a_dest.m_reach = a_src.m_reach;
		a_dest.m_tedashi = a_src.m_tedashi;
	}

	/**
	 * �̔v���R�s�[����B
	 *
	 * @param a_dest
	 *            �R�s�[��̎̔v
	 * @param a_src
	 *            �R�s�[���̎̔v
	 */
	public static void copy(SuteHai a_dest, Hai a_src) {
		Hai.copy(a_dest, a_src);
		a_dest.m_naki = false;
		a_dest.m_reach = false;
		a_dest.m_tedashi = false;
	}

	/**
	 * ���t���O��ݒ肷��B
	 *
	 * @param a_naki
	 *            ���t���O
	 */
	public void setNaki(boolean a_naki) {
		this.m_naki = a_naki;
	}

	/**
	 * ���t���O���擾����B
	 *
	 * @return ���t���O
	 */
	public boolean isNaki() {
		return m_naki;
	}

	/**
	 * ���[�`�t���O��ݒ肷��B
	 *
	 * @param a_reach
	 *            ���[�`�t���O
	 */
	public void setReach(boolean a_reach) {
		this.m_reach = a_reach;
	}

	/**
	 * ���[�`�t���O���擾����B
	 *
	 * @return ���[�`�t���O
	 */
	public boolean isReach() {
		return m_reach;
	}

	/**
	 * ��o���t���O��ݒ肷��B
	 *
	 * @param a_tedashi
	 *            ��o���t���O
	 */
	public void setTedashi(boolean a_tedashi) {
		this.m_tedashi = a_tedashi;
	}

	/**
	 * ��o���t���O���擾����B
	 *
	 * @return ��o���t���O
	 */
	public boolean isTedashi() {
		return m_tedashi;
	}
}
