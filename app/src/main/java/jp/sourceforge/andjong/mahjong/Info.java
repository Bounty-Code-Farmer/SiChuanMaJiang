package jp.sourceforge.andjong.mahjong;

import jp.sourceforge.andjong.mahjong.CountFormat.Combi;
import jp.sourceforge.andjong.mahjong.EventIf.EventId;

/**
 * �v���C���[�ɒ񋟂�������Ǘ�����N���X�ł��B
 *
 * @author Yuji Urushibara
 *
 */
public class Info {
	/** Game */
	protected Mahjong game;

	/**
	 * �C���X�^���X������������B
	 *
	 * @param game
	 *            Game
	 */
	public Info(Mahjong game) {
		this.game = game;
	}

	/**
	 * �T�C�R���̔z����擾����B
	 *
	 * @return �T�C�R���̔z��
	 */
	public Sai[] getSais() {
		return game.getSais();
	}

	/**
	 * �\�h���A�ȃh���̔z����擾����B
	 *
	 * @return �\�h���A�ȃh���̔z��
	 */
	public Hai[] getDoraHais() {
		return game.getDoras();
	}

	/**
	 * �������擾����B
	 *
	 * @return ����
	 */
	public int getJikaze() {
		return game.getJikaze();
	}

	public void copyTehai(Tehai tehai) {
		game.copyTehai(tehai, game.getJikaze());
	}

	/**
	 * ��v���R�s�[����B
	 *
	 * @param tehai
	 *            ��v
	 * @param kaze
	 *            ��
	 */
	public void copyTehai(Tehai tehai, int kaze) {
		game.copyTehai(tehai, kaze);
	}

	/**
	 * �͂��R�s�[����B
	 *
	 * @param kawa
	 *            ��
	 * @param kaze
	 *            ��
	 */
	public void copyKawa(Hou kawa, int kaze) {
		game.copyKawa(kawa, kaze);
	}

	/**
	 * �c���v���擾����B
	 *
	 * @return �c���v
	 */
	public Hai getTsumoHai() {
		Hai tsumoHai = game.getTsumoHai();
		if (tsumoHai != null) {
			return new Hai(game.getTsumoHai());
		}
		return null;
	}

	/**
	 * �̔v���擾����B
	 *
	 * @return �̔v
	 */
	public Hai getSuteHai() {
		return new Hai(game.getSuteHai());
	}

	public int getAgariScore() {
		return 0;
	}

	/**
	 * ������_���擾����B
	 *
	 * @param tehai
	 *            ��v
	 * @param addHai
	 *            ��v�ɒǉ�����v
	 * @return
	 */
	public int getAgariScore(Tehai tehai, Hai addHai) {
		return game.getAgariScore(tehai, addHai);
	}

	public boolean isReach() {
		return game.isReach(game.getJikaze());
	}

	/**
	 * ���[�`���擾����B
	 *
	 * @param kaze
	 *            ��
	 * @return ���[�`
	 */
	public boolean isReach(int kaze) {
		return game.isReach(kaze);
	}

	/**
	 * �c���̎c�萔���擾����B
	 *
	 * @return �c���̎c�萔
	 */
	public int getTsumoRemain() {
		return game.getTsumoRemain();
	}

	/**
	 * �ǂ��擾����B
	 *
	 * @return ��
	 */
	public int getkyoku() {
		return game.getkyoku();
	}

	/**
	 * ���O���擾����B
	 *
	 * @param kaze
	 *            ��
	 * @return ���O
	 */
	public String getName(int kaze) {
		return game.getName(kaze);
	}

	/**
	 * �{����擾����B
	 *
	 * @return �{��
	 */
	public int getHonba() {
		return game.getHonba();
	}

	/**
	 * ���[�`�_�̐����擾����B
	 *
	 * @return ���[�`�_�̐�
	 */
	public int getReachbou() {
		return game.getReachbou();
	}

	/**
	 * �_�_���擾����B
	 *
	 * @param kaze
	 *            ��
	 * @return �_�_
	 */
	public int getTenbou(int kaze) {
		return game.getTenbou(kaze);
	}

//	public String[] getYakuName(Tehai tehai, Hai addHai){
//		return game.getYakuName(tehai, addHai);
//	}

	public void setSutehaiIdx(
			int mSutehaiIdx) {
		this.mSutehaiIdx = mSutehaiIdx;
	}

	public int getSutehaiIdx() {
		return mSutehaiIdx;
	}

	private int mSutehaiIdx;

	{
		setSutehaiIdx(Integer.MAX_VALUE);
	}

	private Combi[] combis = new Combi[10];
	{
		for (int i = 0; i < combis.length; i++)
			combis[i] = new Combi();
	}

	public int getReachIndexs(Tehai a_tehai, Hai a_tsumoHai, int[] a_indexs) {
		// ���Ă���ꍇ�́A���[�`�ł��Ȃ��B
		if (a_tehai.isNaki()) {
			return 0;
		}

		Tehai tehai = new Tehai();
		Tehai.copy(tehai, a_tehai, true);

		int index = 0;
		Hai[] jyunTehai = tehai.getJyunTehai();
		int jyunTehaiLength = tehai.getJyunTehaiLength();
		Hai haiTemp = new Hai();
		Hai addHai;
		CountFormat countFormat = new CountFormat();

		for (int i = 0; i < jyunTehaiLength; i++) {
			Hai.copy(haiTemp, jyunTehai[i]);
			tehai.rmJyunTehai(jyunTehai[i]);
			for (int id = 0; id < Hai.ID_ITEM_MAX; id++) {
				addHai = new Hai(id);
				tehai.addJyunTehai(addHai);
				countFormat.setCountFormat(tehai, a_tsumoHai);
				if (countFormat.getCombis(combis) > 0) {
					a_indexs[index] = i;
					index++;
					tehai.rmJyunTehai(addHai);
					break;
				}
				tehai.rmJyunTehai(addHai);
			}
			tehai.addJyunTehai(haiTemp);
		}

		for (int id = 0; id < Hai.ID_ITEM_MAX; id++) {
			addHai = new Hai(id);
			tehai.addJyunTehai(addHai);
			countFormat.setCountFormat(tehai, null);
			if (countFormat.getCombis(combis) > 0) {
				a_indexs[index] = 13;
				index++;
				tehai.rmJyunTehai(addHai);
				break;
			}
			tehai.rmJyunTehai(addHai);
		}

		return index;
	}

	public int getMachiIndexs(Tehai a_tehai, Hai[] a_hais) {
		Tehai tehai = new Tehai();
		Tehai.copy(tehai, a_tehai, true);

		int index = 0;
		Hai addHai;
		CountFormat countFormat = new CountFormat();

		for (int id = 0; id < Hai.ID_ITEM_MAX; id++) {
			addHai = new Hai(id);
			tehai.addJyunTehai(addHai);
			countFormat.setCountFormat(tehai, null);
			if (countFormat.getCombis(combis) > 0) {
				a_hais[index] = new Hai(id);
				index++;
				tehai.rmJyunTehai(addHai);
			} else {
				tehai.rmJyunTehai(addHai);
			}
		}

		return index;
	}

	public void postUiEvent(EventId a_eventId, int a_kazeFrom, int a_kazeTo) {
		game.postUiEvent(a_eventId, a_kazeFrom, a_kazeTo);
	}

	public int getSuteHaisCount() {
		return game.getSuteHaisCount();
	}

	public SuteHai[] getSuteHais() {
		return game.getSuteHais();
	}

	public int getPlayerSuteHaisCount() {
		return game.getPlayerSuteHaisCount(game.getJikaze());
	}
}
