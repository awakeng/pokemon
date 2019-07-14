package poketmon.model;

import java.util.ArrayList;

import poketmon.exception.NotExistException;
import poketmon.model.db.PoketmonModelDB;
import poketmon.model.dto.Poketmon;
import poketmon.model.dto.Trainer;

// ProbonoProjectService와 같은 역할
public class PoketmonModelMethod {
	private static PoketmonModelMethod instance = new PoketmonModelMethod();
	private PoketmonModelDB poketmonmodeldata = PoketmonModelDB.getInstance();
	
	public static PoketmonModelMethod getInstance() {
		return instance;
	}
	
	
	//모든 Trainer 반환
	public ArrayList<Trainer> getAllTrainers(){
		return poketmonmodeldata.getTrainerList();
	}
	
	
	//특정 Trainer 반환
	public Trainer getTrainer(String trainerName) throws NotExistException {
		Trainer trainer = null;
		for(int i = 0; i<getAllTrainers().size();i++) {
			trainer = getAllTrainers().get(i);
			if(trainer != null && trainer.getName().equals(trainerName)) {
				return trainer;
			}
		}
		throw new NotExistException("등록되지 않은 트레이너 입니다.");
		
	}
	
	
	//Trainer 추가
	public void trainerInsert(Trainer trainer) {
		poketmonmodeldata.insertTrainer(trainer);
		
	}
	
	
	//Trainer 수정 
	public void dataUpdate(String trainerName, Object obj) throws NotExistException{
		Trainer trainer = getTrainer(trainerName);
		if(trainer == null) {
			throw new NotExistException("xxxxxxx 수정하고자 하는 Trainer가 미 존재합니다. xxxxxxx\n");
		}
		if(obj instanceof String) {
			trainer.setName((String)obj);
		} else if(obj instanceof Poketmon) {
			trainer.setPoketmon((Poketmon)obj);
		} else {
			trainer.setBadge((Integer.parseInt((String)obj)));			// 입력받은 값을 정수 타입으로 변환
			trainer.setBadge((Integer.parseInt((String)obj)));			// �Է¹��� ���� ���� Ÿ������ ��ȯ
		}
	} 
	
	// Trainer 삭제
	public void trainerDelete(String trainerName) throws NotExistException {
		Trainer trainer = getTrainer(trainerName);
		if(trainer == null) {
			throw new NotExistException("해당 트레이너가 없습니다.");
		}else {
			poketmonmodeldata.getTrainerList().remove(trainer);
		}
	}
	
	
}
