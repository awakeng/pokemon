package poketmon.controller;

import java.util.ArrayList;
import poketmon.exception.NotExistException;
import poketmon.model.PoketmonModelMethod;
import poketmon.model.dto.Trainer;
import proketmonView.EndView;
import proketmonView.FailView;

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
	public void viewTrainer(String trainerName) throws NotExistException {
		Trainer trainer = method.getTrainer(trainerName);
		if(trainer != null) {
			EndView.viewTrainer(trainer);
		} else {
			EndView.viewMessage("존재하지 않는 트레이너 입니다.");
		}
	}
	
	// 새로운 프로젝트 저장
	public void insertTrainer(Trainer newTrainer) {
		method.trainerInsert(newTrainer);
	}

	// 존재하는 프로젝트 수정
	public void updateProject(String trainerName, Object obj) {
		try {
			method.dataUpdate(trainerName, obj);
		} catch (NotExistException e) {
			FailView.failMessageView(e.getMessage());
		}
	}
	
	// 모든 프로젝트 삭제
	public void deleteTrainer(String trainerName) {
		try {
			method.trainerDelete(trainerName);
		} catch (NotExistException e) {
			FailView.failMessageView(e.getMessage());
			//e.printStackTrace();
		}
	}
}


