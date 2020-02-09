package jp.sourceforge.andjong.mahjong;

import static jp.sourceforge.andjong.mahjong.EventIf.*;

public class AgariSetting {
	/** ����n��*/
	public enum YakuflgName{
		/** ���� */
		REACH,
		/** �ꔭ */
		IPPATU,
		/** �c�� */
		TUMO  ,
		/** �C�� */
		HAITEI,
		/** �͒� */
		HOUTEI,
		/** ���J�� */
		RINSYAN,
		/** ���� */
		CHANKAN,
		/** �_�u������ */
		DOUBLEREACH,
		/** �V�a */
		TENHOU,
		/** �n�a */
		TIHOU,
		/** �l�a	*/
		RENHOU,
		/** �\�O�s�� */
		TIISANPUTOU,
		/** �������� */
		NAGASHIMANGAN,
		/** ���A�� */
		PARENCHAN,
		/** �򂢃^�� */
		KUITAN,
		/** ���̐� */
		YAKUFLGNUM
	}

	/** �𐬗��t���O�̔z�� */
	boolean yakuflg[] = new boolean [YakuflgName.YAKUFLGNUM.ordinal()];
	/** ���� */
	private int jikaze = KAZE_NONE;
	/** �ꕗ�̐ݒ� */
	private int bakaze = KAZE_TON;
	/** �\�h���\���v */
	Hai doraHais[] = new Hai[4];
	/** ���h�� */
	Hai uraDoraHais[] = new Hai[4];

	AgariSetting(){
		for(int i = 0 ; i < yakuflg.length ; i++){
			yakuflg[i] = false;
		}
	}

	/** �R���X�g���N�^ */
	AgariSetting(Mahjong game){
		for(int i = 0 ; i < yakuflg.length ; i++){
			yakuflg[i] = false;
		}
		this.doraHais = game.getDoras();
		this.uraDoraHais = game.getUraDoras();
		this.jikaze = game.getJikaze();
		this.bakaze = game.getBakaze();
	}

	/** ����𐬗��̐ݒ� */
	void setYakuflg(int yakuNum ,boolean yakuflg){
		this.yakuflg[yakuNum] = yakuflg;
	}
	/** ����𐬗��̎擾 */
	boolean getYakuflg(int yakuNum){
		return this.yakuflg[yakuNum];
	}

	/** �����̐ݒ� */
	void setJikaze(int jikaze){
		this.jikaze = jikaze;
	}
	/** �����̎擾 */
	int getJikaze(){
		return this.jikaze;
	}

	/** �ꕗ�̐ݒ� */
	void setBakaze(int bakaze){
		this.bakaze = bakaze;
	}
	/** �ꕗ�̎擾 */
	int getBakaze(){
		return this.bakaze;
	}


	/** �h���\���v�̐ݒ� */
	void setDoraHais(Hai[] doraHais){
		this.doraHais = doraHais;
	}
	/** �h���\���v�̎擾 */
	Hai[] getDoraHais(){
		return this.doraHais;
	}

	/** ���h���\���v�̐ݒ� */
	void setUraDoraHais(Hai[] uraDoraHais){
		this.doraHais = uraDoraHais;
	}
	/** ���h���\���v�̎擾 */
	Hai[] getUraDoraHais(){
		return this.uraDoraHais;
	}
}
