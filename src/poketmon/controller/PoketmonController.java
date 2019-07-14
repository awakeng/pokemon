package poketmon.controller;

import java.util.ArrayList;

import poketmon.model.PoketmonModelMethod;
import poketmon.model.dto.Trainer;
import proketmonView.EndView;

public class PoketmonController {
	private static PoketmonController instance = new PoketmonController();
	private PoketmonModelMethod method = PoketmonModelMethod.getInstance(); 
	
	private PoketmonController() {}
	public static PoketmonController getInstance() {
		return instance;
	}
	
	// 모든 프로젝트 검색
	public void TrainerListView() {
		ArrayList<Trainer> trainerList = method.getAllTrainers();
		if(trainerList.size() != 0) {
			EndView.viewList(trainerList);
		}else {
			EndView.viewMessage("dd");
			
		}
	}
	
	// 특정 프로젝트 검색
	public void TrainerView(String trainerName) {
		Trainer view = null;
		Trainer trainer = method.getTrainer(trainerName);
		for(int i = 0; i<trainer.size();i++) {
			if(trainer.get(i) != null ) {
				EndView.viewAll(trainer);
			}else {
				
			}
		}
	}
	
	
	// 새로운 프로젝트 저장
	
	// 존재하는 프로젝트 수정
	
	// 모든 프로젝트 삭제
	
	
	
}
