package proketmonView;

import poketmon.controller.PoketmonController;
import poketmon.exception.NotExistException;
import poketmon.model.db.PoketmonModelDB;
import poketmon.model.dto.Poketmon;
import poketmon.model.dto.Trainer;

public class StartView {
	public static void main(String[] args) throws NotExistException {
		PoketmonController controller = PoketmonController.getInstance();		
		
		
		// 모든 트레이너 정보 출력
		System.out.println("모든 트레이너 정보 출력");
		controller.TrainerListView();
		System.out.println();
		
		// 새로운 포켓몬
		Poketmon poketmon4 = new Poketmon("야도란", 99, 99, 9, "물");
		// 새로운 트레이너
		Trainer trainer4 = new Trainer("동성", "서울", poketmon4, 2);
		// 새로운 트레이너 저장
		System.out.println("새로운 트레이너 저장");
		controller.insertTrainer(trainer4);
		
		// 특정 트레이너 검색
		System.out.println("새로 저장한 트레이너 '동성' 검색");
		controller.viewTrainer("동성");
		System.out.println();
		
		// 존재하는 트레이너 update
		System.out.println("트레이너 정보 수정");
		controller.updateData("동성", "encore");
		controller.updateData("동성", new Poketmon("또가스", 100, 100, 10, "독"));
		controller.updateData("동성", 3);
		controller.viewTrainer("동성");
		System.out.println();
		
		// 트레이너 삭제 후 모든 트레이너 검색
		System.out.println("트레이너 삭제");
		controller.deleteTrainer("동성");

		// 존재하지 않는 트레이너 검색 및 update 시도
		System.out.println("존재하지 않는 트레이너 정보 수정 및 검색 시도 - 예외처리 확인");
		controller.updateData("동성", 4);
		controller.viewTrainer("동성");
		
		
		
	}
}


