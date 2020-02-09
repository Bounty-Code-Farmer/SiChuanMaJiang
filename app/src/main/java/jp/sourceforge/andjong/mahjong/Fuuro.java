package jp.sourceforge.andjong.mahjong;

/**
 * ���I���Ǘ�����B
 *
 * @author Yuji Urushibara
 *
 */
public class Fuuro {
	/*
	 * ���
	 */

	/** ��� ���� */
	public static final int TYPE_MINSHUN = 0;
	/** ��� ���� */
	public static final int TYPE_MINKOU = 1;
	/** ��� �喾�� */
	public static final int TYPE_DAIMINKAN = 2;
	/** ��� ���� */
	public static final int TYPE_KAKAN = 3;
	/** ��� �Þ� */
	public static final int TYPE_ANKAN = 4;

	/** ��� */
	private int m_type;

	/** ���ƂƂ̊֌W */
	private int m_relation;

	/** �\���v */
	private Hai m_hais[] = new Hai[Mahjong.MENTSU_HAI_MEMBERS_4];

	{
		for (int i = 0; i < m_hais.length; i++) {
			m_hais[i] = new Hai();
		}
	}

	/**
	 * ��ʂ�ݒ肷��B
	 *
	 * @param a_type
	 *            ���
	 */
	public void setType(int a_type) {
		this.m_type = a_type;
	}

	/**
	 * ��ʂ��擾����B
	 *
	 * @return ���
	 */
	public int getType() {
		return m_type;
	}

	/**
	 * ���ƂƂ̊֌W��ݒ肷��B
	 *
	 * @param a_relation
	 *            ���ƂƂ̊֌W
	 */
	public void setRelation(int a_relation) {
		this.m_relation = a_relation;
	}

	/**
	 * ���ƂƂ̊֌W���擾����B
	 *
	 * @return ���ƂƂ̊֌W
	 */
	public int getRelation() {
		return m_relation;
	}

	/**
	 * �\���v��ݒ肷��B
	 *
	 * @param m_hais
	 *            �\���v
	 */
	public void setHais(Hai m_hais[]) {
		this.m_hais = m_hais;
	}

	/**
	 * �\���v���擾����B
	 *
	 * @return �\���v
	 */
	public Hai[] getHais() {
		return m_hais;
	}

	/**
	 * ���I���R�s�[����B
	 *
	 * @param a_dest
	 *            �R�s�[��̕��I
	 * @param a_src
	 *            �R�s�[���̕��I
	 */
	public static void copy(Fuuro a_dest, Fuuro a_src) {
		a_dest.m_type = a_src.m_type;
		a_dest.m_relation = a_src.m_relation;

		for (int i = 0; i < Mahjong.MENTSU_HAI_MEMBERS_4; i++) {
			Hai.copy(a_dest.m_hais[i], a_src.m_hais[i]);
		}
	}
}
