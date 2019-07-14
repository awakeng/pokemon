package proketmonView;

import poketmon.model.db.PoketmonModelDB;

public class StartView {
	public static void main(String[] args) {
		PoketmonModelDB poket = PoketmonModelDB.getInstance();
		
		// 모든 트레이너 정보 출력
		System.out.println("모든 트레이너 정보 출력");
		System.out.println(poket.getTrainer());

		// 새로운 포켓몬 
		
		// 새로운 트레이너
	}
}


