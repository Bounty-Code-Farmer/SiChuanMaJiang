package jp.sourceforge.andjong.mahjong;

import jp.sourceforge.andjong.mahjong.AgariScore.AgariInfo;

public class InfoUi extends Info {
	private PlayerAction mPlayerAction;

	public InfoUi(Mahjong game, PlayerAction playerAction) {
		super(game);
		this.setPlayerAction(playerAction);
	}

	public Hai[] getUraDoraHais() {
		return game.getYama().getUraDoraHais();
	}

	public int getManKaze() {
		return game.getManKaze();
	}

	/**
	 * ��v���R�s�[���܂��B
	 *
	 * @param tehai
	 *            ��v
	 * @param kaze
	 *            ��
	 */
	public void copyTehai(Tehai tehai, int kaze) {
		game.copyTehaiUi(tehai, kaze);
	}

	public void setPlayerAction(PlayerAction playerAction) {
		this.mPlayerAction = playerAction;
	}

	public PlayerAction getPlayerAction() {
		return mPlayerAction;
	}

	/**
	 * �N�Ƃ̃v���C���[�C���f�b�N�X���擾����B
	 *
	 * @return �N�Ƃ̃v���C���[�C���f�b�N�X
	 */
	public int getChiichaIdx() {
		return game.getChiichaIdx();
	}

	public AgariInfo getAgariInfo() {
		return game.getAgariInfo();
	}

	public boolean[] getTenpai() {
		return game.getTenpai();
	}
}
