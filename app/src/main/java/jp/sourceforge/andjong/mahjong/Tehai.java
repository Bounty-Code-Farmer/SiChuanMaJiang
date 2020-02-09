package jp.sourceforge.andjong.mahjong;

/**
 * ��v���Ǘ�����B
 *
 * @author Yuji Urushibara
 *
 */
public class Tehai {
	/** ����v�̒����̍ő�l */
	public final static int JYUN_TEHAI_LENGTH_MAX = 14;

	/** ���I�̍ő�l */
	public final static int FUURO_MAX = 4;

	/** �ʎq�̒���(3) */
	public final static int MENTSU_LENGTH_3 = 3;

	/** �ʎq�̒���(4) */
	public final static int MENTSU_LENGTH_4 = 4;

	/** ����v */
	private Hai[] m_jyunTehai = new Hai[JYUN_TEHAI_LENGTH_MAX];

	/** ����v�̒��� */
	private int m_jyunTehaiLength;

	/** ���I�̔z�� */
	private Fuuro[] m_fuuros = new Fuuro[FUURO_MAX];

	/** ���I�̌� */
	private int m_fuuroNums;

	{
		for (int i = 0; i < JYUN_TEHAI_LENGTH_MAX; i++) {
			m_jyunTehai[i] = new Hai();
		}

		for (int i = 0; i < FUURO_MAX; i++) {
			m_fuuros[i] = new Fuuro();
		}
	}

	/**
	 * ��v���쐬����B
	 */
	public Tehai() {
		initialize();
	}

	/**
	 * ��v������������B
	 */
	public void initialize() {
		m_jyunTehaiLength = 0;
		m_fuuroNums = 0;
	}

	/**
	 * ��v���R�s�[����B
	 *
	 * @param a_dest
	 *            �R�s�[��̎�v
	 * @param a_src
	 *            �R�s�[���̎�v
	 * @param jyunTehaiCopy
	 *            ����v�̃R�s�[����
	 */
	public static void copy(Tehai a_dest, Tehai a_src, boolean jyunTehaiCopy) {
		if (jyunTehaiCopy == true) {
			a_dest.m_jyunTehaiLength = a_src.m_jyunTehaiLength;
			Tehai.copyJyunTehai(a_dest.m_jyunTehai, a_src.m_jyunTehai, a_dest.m_jyunTehaiLength);
		}

		a_dest.m_fuuroNums = a_src.m_fuuroNums;
		copyFuuros(a_dest.m_fuuros, a_src.m_fuuros, a_dest.m_fuuroNums);
	}

	/**
	 * ����v���擾����B
	 *
	 * @return ����v
	 */
	public Hai[] getJyunTehai() {
		return m_jyunTehai;
	}

	/**
	 * ����v�̒������擾����B
	 *
	 * @return ����v�̒���
	 */
	public int getJyunTehaiLength() {
		return m_jyunTehaiLength;
	}

	/**
	 * ����v�ɔv��ǉ�����B
	 *
	 * @param a_hai
	 *            �ǉ�����v
	 * @return ����
	 */
	public boolean addJyunTehai(Hai a_hai) {
		if (m_jyunTehaiLength >= JYUN_TEHAI_LENGTH_MAX) {
			return false;
		}

		int i;
		for (i = m_jyunTehaiLength; i > 0; i--) {
			if (m_jyunTehai[i - 1].getId() <= a_hai.getId()) {
				break;
			}

			Hai.copy(m_jyunTehai[i], m_jyunTehai[i - 1]);
		}

		Hai.copy(m_jyunTehai[i], a_hai);
		m_jyunTehaiLength++;

		return true;
	}

	/**
	 * ����v����w��ʒu�̔v���폜����B
	 *
	 * @param a_index
	 *            �w��ʒu
	 * @return ����
	 */
	public boolean rmJyunTehai(int a_index) {
		if (a_index >= JYUN_TEHAI_LENGTH_MAX) {
			return false;
		}

		for (int i = a_index; i < m_jyunTehaiLength - 1; i++) {
			Hai.copy(m_jyunTehai[i], m_jyunTehai[i + 1]);
		}

		m_jyunTehaiLength--;

		return true;
	}

	/**
	 * ����v����w��̔v���폜����B
	 *
	 * @param a_hai
	 *            �w��̔v
	 * @return ����
	 */
	public boolean rmJyunTehai(Hai a_hai) {
		int id = a_hai.getId();

		for (int i = 0; i < m_jyunTehaiLength; i++) {
			if (id == m_jyunTehai[i].getId()) {
				return rmJyunTehai(i);
			}
		}

		return false;
	}

	/**
	 * ����v���R�s�[����B
	 *
	 * @param a_dest
	 *            �R�s�[��̏���v
	 * @param a_src
	 *            �R�s�[���̏���v
	 * @param a_length
	 *            �R�s�[���钷��
	 * @return ����
	 */
	public static boolean copyJyunTehai(Hai[] a_dest, Hai[] a_src, int a_length) {
		if (a_length > JYUN_TEHAI_LENGTH_MAX) {
			return false;
		}

		for (int i = 0; i < a_length; i++) {
			Hai.copy(a_dest[i], a_src[i]);
		}

		return true;
	}

	/**
	 * ����v�̎w��ʒu�̔v���R�s�[����B
	 *
	 * @param a_hai
	 *            �v
	 * @param a_index
	 *            �w��ʒu
	 */
	public boolean copyJyunTehaiIndex(Hai a_hai, int a_index) {
		if (a_index >= m_jyunTehaiLength) {
			return false;
		}

		Hai.copy(a_hai, m_jyunTehai[a_index]);

		return true;
	}

	/**
	 * �`�[(��)�̉ۂ��`�F�b�N����B
	 *
	 * @param a_suteHai
	 *            �̔v
	 * @return �`�[(��)�̉�
	 */
	public boolean validChiiLeft(Hai a_suteHai, Hai[] a_sarashiHais) {
		if (a_suteHai.isTsuu()) {
			return false;
		}

		if (a_suteHai.getNo() == Hai.NO_8) {
			return false;
		}

		if (a_suteHai.getNo() == Hai.NO_9) {
			return false;
		}

		if (m_fuuroNums >= FUURO_MAX) {
			return false;
		}

		int noKindLeft = a_suteHai.getNoKind();
		int noKindCenter = noKindLeft + 1;
		int noKindRight = noKindLeft + 2;
		for (int i = 0; i < m_jyunTehaiLength; i++) {
			if (m_jyunTehai[i].getNoKind() == noKindCenter) {
				for (int j = i + 1; j < m_jyunTehaiLength; j++) {
					if (m_jyunTehai[j].getNoKind() == noKindRight) {
						a_sarashiHais[0] = new Hai(m_jyunTehai[i]);
						a_sarashiHais[1] = new Hai(m_jyunTehai[j]);
						return true;
					}
				}
			}
		}

		return false;
	}

	/**
	 * �`�[(��)��ݒ肷��B
	 *
	 * @param a_suteHai
	 *            �̔v
	 * @param a_relation
	 *            �֌W
	 * @return ����
	 */
	public boolean setChiiLeft(Hai a_suteHai, int a_relation) {
		Hai sarashiHais[] = new Hai[2];
		if (!validChiiLeft(a_suteHai, sarashiHais)) {
			return false;
		}

		Hai hais[] = new Hai[Mahjong.MENTSU_HAI_MEMBERS_4];

		hais[0] = new Hai(a_suteHai);

		int noKindLeft = a_suteHai.getNoKind();
		int noKindCenter = noKindLeft + 1;
		int noKindRight = noKindLeft + 2;
		for (int i = 0; i < m_jyunTehaiLength; i++) {
			if (m_jyunTehai[i].getNoKind() == noKindCenter) {
				hais[1] = new Hai(m_jyunTehai[i]);

				rmJyunTehai(i);

				for (int j = i; j < m_jyunTehaiLength; j++) {
					if (m_jyunTehai[j].getNoKind() == noKindRight) {
						hais[2] = new Hai(m_jyunTehai[j]);

						rmJyunTehai(j);

						hais[3] = new Hai();

						m_fuuros[m_fuuroNums].setType(Fuuro.TYPE_MINSHUN);
						m_fuuros[m_fuuroNums].setRelation(a_relation);
						m_fuuros[m_fuuroNums].setHais(hais);
						m_fuuroNums++;
						return true;
					}
				}
			}
		}

		return false;
	}

	/**
	 * �`�[(����)�̉ۂ��`�F�b�N����B
	 *
	 * @param a_suteHai
	 *            �̔v
	 * @return �`�[(����)�̉�
	 */
	public boolean validChiiCenter(Hai a_suteHai, Hai[] a_sarashiHais) {
		if (a_suteHai.isTsuu()) {
			return false;
		}

		if (a_suteHai.getNo() == Hai.NO_1) {
			return false;
		}

		if (a_suteHai.getNo() == Hai.NO_9) {
			return false;
		}

		if (m_fuuroNums >= FUURO_MAX) {
			return false;
		}

		int noKindCenter = a_suteHai.getNoKind();
		int noKindLeft = noKindCenter - 1;
		int noKindRight = noKindCenter + 1;
		for (int i = 0; i < m_jyunTehaiLength; i++) {
			if (m_jyunTehai[i].getNoKind() == noKindLeft) {
				for (int j = i + 1; j < m_jyunTehaiLength; j++) {
					if (m_jyunTehai[j].getNoKind() == noKindRight) {
						a_sarashiHais[0] = new Hai(m_jyunTehai[i]);
						a_sarashiHais[1] = new Hai(m_jyunTehai[j]);
						return true;
					}
				}
			}
		}

		return false;
	}

	/**
	 * �`�[(����)��ݒ肷��B
	 *
	 * @param a_suteHai
	 *            �̔v
	 * @param a_relation
	 *            �֌W
	 * @return ����
	 */
	public boolean setChiiCenter(Hai a_suteHai, int a_relation) {
		Hai sarashiHais[] = new Hai[2];
		if (!validChiiCenter(a_suteHai, sarashiHais)) {
			return false;
		}

		Hai hais[] = new Hai[Mahjong.MENTSU_HAI_MEMBERS_4];

		hais[1] = new Hai(a_suteHai);

		int noKindCenter = a_suteHai.getNoKind();
		int noKindLeft = noKindCenter - 1;
		int noKindRight = noKindCenter + 1;
		for (int i = 0; i < m_jyunTehaiLength; i++) {
			if (m_jyunTehai[i].getNoKind() == noKindLeft) {
				hais[0] = new Hai(m_jyunTehai[i]);

				rmJyunTehai(i);

				for (int j = i; j < m_jyunTehaiLength; j++) {
					if (m_jyunTehai[j].getNoKind() == noKindRight) {
						hais[2] = new Hai(m_jyunTehai[j]);

						rmJyunTehai(j);

						hais[3] = new Hai();

						m_fuuros[m_fuuroNums].setType(Fuuro.TYPE_MINSHUN);
						m_fuuros[m_fuuroNums].setRelation(a_relation);
						m_fuuros[m_fuuroNums].setHais(hais);
						m_fuuroNums++;
						return true;
					}
				}
			}
		}

		return false;
	}

	/**
	 * �`�[(�E)�̉ۂ��`�F�b�N����B
	 *
	 * @param a_suteHai
	 *            �̔v
	 * @return �`�[(�E)�̉�
	 */
	public boolean validChiiRight(Hai a_suteHai, Hai[] a_sarashiHais) {
		if (a_suteHai.isTsuu()) {
			return false;
		}

		if (a_suteHai.getNo() == Hai.NO_1) {
			return false;
		}

		if (a_suteHai.getNo() == Hai.NO_2) {
			return false;
		}

		if (m_fuuroNums >= FUURO_MAX) {
			return false;
		}

		int noKindRight = a_suteHai.getNoKind();
		int noKindLeft = noKindRight - 2;
		int noKindCenter = noKindRight - 1;
		for (int i = 0; i < m_jyunTehaiLength; i++) {
			if (m_jyunTehai[i].getNoKind() == noKindLeft) {
				for (int j = i + 1; j < m_jyunTehaiLength; j++) {
					if (m_jyunTehai[j].getNoKind() == noKindCenter) {
						a_sarashiHais[0] = new Hai(m_jyunTehai[i]);
						a_sarashiHais[1] = new Hai(m_jyunTehai[j]);
						return true;
					}
				}
			}
		}

		return false;
	}

	/**
	 * �`�[(�E)��ݒ肷��B
	 *
	 * @param a_suteHai
	 *            �̔v
	 * @param a_relation
	 *            �֌W
	 * @return ����
	 */
	public boolean setChiiRight(Hai a_suteHai, int a_relation) {
		Hai sarashiHais[] = new Hai[2];
		if (!validChiiRight(a_suteHai, sarashiHais)) {
			return false;
		}

		Hai hais[] = new Hai[Mahjong.MENTSU_HAI_MEMBERS_4];

		hais[2] = new Hai(a_suteHai);

		int noKindRight = a_suteHai.getNoKind();
		int noKindLeft = noKindRight - 2;
		int noKindCenter = noKindRight - 1;
		for (int i = 0; i < m_jyunTehaiLength; i++) {
			if (m_jyunTehai[i].getNoKind() == noKindLeft) {
				hais[0] = new Hai(m_jyunTehai[i]);

				rmJyunTehai(i);

				for (int j = i; j < m_jyunTehaiLength; j++) {
					if (m_jyunTehai[j].getNoKind() == noKindCenter) {
						hais[1] = new Hai(m_jyunTehai[j]);

						rmJyunTehai(j);

						hais[3] = new Hai();

						m_fuuros[m_fuuroNums].setType(Fuuro.TYPE_MINSHUN);
						m_fuuros[m_fuuroNums].setRelation(a_relation);
						m_fuuros[m_fuuroNums].setHais(hais);
						m_fuuroNums++;
						return true;
					}
				}
			}
		}

		return false;
	}

	/**
	 * �|���̉ۂ��`�F�b�N����B
	 *
	 * @param a_suteHai
	 *            �̔v
	 * @return �|���̉�
	 */
	public boolean validPon(Hai a_suteHai) {
		if (m_fuuroNums >= FUURO_MAX) {
			return false;
		}

		int id = a_suteHai.getId();
		for (int i = 0, count = 1; i < m_jyunTehaiLength; i++) {
			if (id == m_jyunTehai[i].getId()) {
				count++;
				if (count >= MENTSU_LENGTH_3) {
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * �|����ݒ肷��B
	 *
	 * @param a_suteHai
	 *            �̔v
	 * @param a_relation
	 *            �֌W
	 * @return ����
	 */
	public boolean setPon(Hai a_suteHai, int a_relation) {
		if (!validPon(a_suteHai)) {
			return false;
		}

		Hai hais[] = new Hai[Mahjong.MENTSU_HAI_MEMBERS_4];

		int iHais = 0;
		hais[iHais] = new Hai(a_suteHai);
		iHais++;

		int id = a_suteHai.getId();
		for (int i = 0; i < m_jyunTehaiLength; i++) {
			if (id == m_jyunTehai[i].getId()) {
				hais[iHais] = new Hai(m_jyunTehai[i]);
				iHais++;

				rmJyunTehai(i);
				i--;

				if (iHais >= MENTSU_LENGTH_3) {
					break;
				}
			}
		}

		hais[iHais] = new Hai();

		m_fuuros[m_fuuroNums].setType(Fuuro.TYPE_MINKOU);
		m_fuuros[m_fuuroNums].setRelation(a_relation);
		m_fuuros[m_fuuroNums].setHais(hais);
		m_fuuroNums++;

		return true;
	}

	/**
	 * �Ȃ̉ۂ��`�F�b�N����B
	 *
	 * @param a_addHai
	 *            �ǉ�����v
	 * @return �ÞȂ̉�
	 */
	public int validKan(Hai a_addHai, Hai[] a_kanHais) {
		if (m_fuuroNums >= FUURO_MAX) {
			return 0;
		}

		int kanCount = 0;
		int id;

		addJyunTehai(a_addHai);

		// ���J���̃`�F�b�N
		for (int i = 0; i < m_fuuroNums; i++) {
			if (m_fuuros[i].getType() == Fuuro.TYPE_MINKOU) {
				for (int j = 0; j < m_jyunTehaiLength; j++) {
					if (m_fuuros[i].getHais()[0].getId() == m_jyunTehai[j].getId()) {
						a_kanHais[kanCount] = new Hai(m_jyunTehai[j]);
						kanCount++;
					}
				}
			}
		}

		id = m_jyunTehai[0].getId();
		for (int i = 1, count = 1; i < m_jyunTehaiLength; i++) {
			if (id == m_jyunTehai[i].getId()) {
				count++;
				if (count >= MENTSU_LENGTH_4) {
					a_kanHais[kanCount] = new Hai(m_jyunTehai[i]);
					kanCount++;
				}
			} else {
				id = m_jyunTehai[i].getId();
				count = 1;
			}
		}
		rmJyunTehai(a_addHai);

		return kanCount;
	}

	public boolean validDaiMinKan(Hai a_suteHai) {
		if (m_fuuroNums >= FUURO_MAX) {
			return false;
		}

		int id = a_suteHai.getId();
		for (int i = 0, count = 1; i < m_jyunTehaiLength; i++) {
			if (id == m_jyunTehai[i].getId()) {
				count++;
				if (count >= MENTSU_LENGTH_4) {
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * �喾�Ȃ�ݒ肷��B
	 *
	 * @param a_suteHai
	 *            �̔v
	 * @param a_relation
	 *            �֌W
	 * @return ����
	 */
	public boolean setDaiMinKan(Hai a_suteHai, int a_relation) {
		Hai hais[] = new Hai[Mahjong.MENTSU_HAI_MEMBERS_4];

		int iHais = 0;
		hais[iHais] = new Hai(a_suteHai);
		iHais++;

		int suteHaiId = a_suteHai.getId();
		for (int i = 0; i < m_jyunTehaiLength; i++) {
			if (suteHaiId == m_jyunTehai[i].getId()) {
				hais[iHais] = new Hai(m_jyunTehai[i]);
				iHais++;

				rmJyunTehai(i);
				i--;

				if (iHais >= MENTSU_LENGTH_4) {
					break;
				}
			}
		}

		m_fuuros[m_fuuroNums].setType(Fuuro.TYPE_DAIMINKAN);
		m_fuuros[m_fuuroNums].setRelation(a_relation);
		m_fuuros[m_fuuroNums].setHais(hais);
		m_fuuroNums++;

		return true;
	}

	/**
	 * ���Ȃ̉ۂ��`�F�b�N����B
	 *
	 * @param a_tsumoHai
	 *            �c���v
	 * @return ���Ȃ̉�
	 */
	public boolean validKaKan(Hai a_tsumoHai) {
		if (m_fuuroNums >= FUURO_MAX) {
			return false;
		}

		int id = a_tsumoHai.getId();
		for (int i = 0; i < m_fuuroNums; i++) {
			if (m_fuuros[i].getType() == Fuuro.TYPE_MINKOU) {
				if (id == (m_fuuros[i].getHais())[0].getId()) {
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * ���Ȃ�ݒ肷��B
	 *
	 * @param a_tsumoHai
	 *            �c���v
	 * @return ����
	 */
	public boolean setKaKan(Hai a_tsumoHai) {
		if (!validKaKan(a_tsumoHai)) {
			return false;
		}

		Hai hais[];

		int id = a_tsumoHai.getId();
		for (int i = 0; i < m_fuuroNums; i++) {
			if (m_fuuros[i].getType() == Fuuro.TYPE_MINKOU) {
				hais = m_fuuros[i].getHais();
				if (id == hais[0].getId()) {
					Hai.copy(hais[3], a_tsumoHai);
					m_fuuros[i].setType(Fuuro.TYPE_KAKAN);
					m_fuuros[i].setHais(hais);
				}
			}
		}

		return true;
	}

	/**
	 * �ÞȂ�ݒ肷��B
	 *
	 * @param a_tsumoHai
	 *            �c���v
	 * @param a_relation
	 *            �֌W
	 * @return ����
	 */
	public boolean setAnKan(Hai a_tsumoHai, int a_relation) {
		Hai fuuroHais[] = new Hai[Mahjong.MENTSU_HAI_MEMBERS_4];

		int id = a_tsumoHai.getId();
		for (int i = 0; i < m_fuuroNums; i++) {
			if (m_fuuros[i].getType() == Fuuro.TYPE_MINKOU) {
				fuuroHais = m_fuuros[i].getHais();
				if (id == fuuroHais[0].getId()) {
					Hai.copy(fuuroHais[3], a_tsumoHai);
					rmJyunTehai(a_tsumoHai);
					m_fuuros[i].setType(Fuuro.TYPE_KAKAN);
					m_fuuros[i].setHais(fuuroHais);
					//m_fuuroNums++;

					return true;
				}
			}
		}

		int iHais = 0;
		Hai hais[] = new Hai[Mahjong.MENTSU_HAI_MEMBERS_4];

		//id = a_tsumoHai.getId();
		for (int i = 0; i < m_jyunTehaiLength; i++) {
			if (id == m_jyunTehai[i].getId()) {
				hais[iHais] = new Hai(m_jyunTehai[i]);
				iHais++;

				rmJyunTehai(i);
				i--;

				if (iHais >= MENTSU_LENGTH_4) {
					break;
				}
			}
		}

		m_fuuros[m_fuuroNums].setType(Fuuro.TYPE_ANKAN);
		m_fuuros[m_fuuroNums].setRelation(a_relation);
		m_fuuros[m_fuuroNums].setHais(hais);
		m_fuuroNums++;

		return true;
	}

	/**
	 * ���I�̔z����擾����B
	 *
	 * @return ���I�̔z��
	 */
	public Fuuro[] getFuuros() {
		return m_fuuros;
	}

	/**
	 * ���I�̌����擾����B
	 *
	 * @return ���I�̌�
	 */
	public int getFuuroNum() {
		return m_fuuroNums;
	}

	public boolean isNaki() {
		for (int i = 0; i < m_fuuroNums; i++) {
			if (m_fuuros[i].getType() != Fuuro.TYPE_ANKAN) {
				return true;
			}
		}

		return false;
	}

	/**
	 * ���I�̔z����R�s�[����B
	 *
	 * @param a_dest
	 *            �R�s�[��̕��I�̔z��
	 * @param a_src
	 *            �R�s�[���̕��I�̔z��
	 * @param a_length
	 *            �R�s�[���钷��
	 * @return ����
	 */
	public static boolean copyFuuros(Fuuro[] a_dest, Fuuro[] a_src, int a_length) {
		if (a_length > FUURO_MAX) {
			return false;
		}

		for (int i = 0; i < a_length; i++) {
			Fuuro.copy(a_dest[i], a_src[i]);
		}

		return true;
	}
}
