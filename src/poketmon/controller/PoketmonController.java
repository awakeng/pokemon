package poketmon.controller;

import javax.security.auth.login.FailedLoginException;

import poketmon.exception.NotExistException;
import poketmon.model.PoketmonModelMethod;
import poketmon.model.dto.Trainer;
import proketmonView.FailView;

public class PoketmonController {
	private static PoketmonController instance = new PoketmonController();
	private PoketmonModelMethod method = PoketmonModelMethod.getInstance(); 
	
	private PoketmonController() {}
	public static PoketmonController getInstance() {
		return instance;
	}
	
	// 모든 프로젝트 검색
	
	// 특정 프로젝트 검색
	
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


