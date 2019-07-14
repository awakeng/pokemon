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
	public ArrayList<Trainer> getAllTrainer(){
		return poketmonmodeldata.getTrainer();
	}
	
	
	//특정 Trainer 반환
	public Trainer getTrainer(String tainerName) throws NotExistException {
		Trainer trainer = null;
		for(int i = 0; i<getAllTrainer().size();i++) {
			trainer = getAllTrainer().get(i);
			if(trainer != null && trainer.getName().equals(tainerName)) {
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
			throw new NotExistException("xxxxxxx �����ϰ��� �ϴ� Trainer�� �� �����մϴ�. xxxxxxx\n");
		}
		if(obj instanceof String) {
			trainer.setName((String)obj);
		} else if(obj instanceof Poketmon) {
			trainer.setPoketmon((Poketmon)obj);
		} else {
			trainer.setBadge((Integer.parseInt((String)obj)));			// �Է¹��� ���� ���� Ÿ������ ��ȯ
		}
	} 
	
	// Trainer 삭제
}
