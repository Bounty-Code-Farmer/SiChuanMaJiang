package jp.sourceforge.andjong.mahjong;

import java.util.Random;

/**
 * �T�C�R�����Ǘ�����B
 *
 * @author Yuji Urushibara
 *
 */
public class Sai {
	/** �V�[�h */
	private static long m_seed;

	/** �ԍ� */
	private int m_no = 1;

	/** �����W�F�l���[�^ */
	private Random m_random = new Random(m_seed++);

	static {
		m_seed = System.currentTimeMillis();
	}

	/**
	 * �ԍ����擾����B
	 *
	 * @return �ԍ�
	 */
	public int getNo() {
		return m_no;
	}

	/**
	 * �T�C�R����U���Ĕԍ����擾����B
	 *
	 * @return �ԍ�
	 */
	public int saifuri() {
		return m_no = m_random.nextInt(6) + 1;
	}
}
