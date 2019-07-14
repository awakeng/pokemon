package proketmonView;

import poketmon.model.db.PoketmonModelDB;
import poketmon.model.dto.Poketmon;
import poketmon.model.dto.Trainer;

public class StartView {
	public static void main(String[] args) {
		PoketmonModelDB poket = PoketmonModelDB.getInstance();
		
		
		
		// 모든 트레이너 정보 출력
		System.out.println("모든 트레이너 정보 출력");
		System.out.println(poket.getTrainerList());

		// 새로운 포켓몬
		Poketmon poketmon4 = new Poketmon("야도란", 99, 99, 9, "물");
		// 새로운 트레이너
		Trainer trainer4 = new Trainer("동성", "서울", poketmon4, 2);
		// 새로운 트레이너 저장
		System.out.println("새로운 트레이너 저장");
		
		// 특정 트레이너 검색
		
		// 존재하는 트레이너 update
		
		// 존재하지 않는 트레이너 update 시도
		
		// 트레이너 삭제 후 모든 트레이너 검색
		
		
		
	}
}


