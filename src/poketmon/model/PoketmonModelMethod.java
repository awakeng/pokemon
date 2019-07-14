package poketmon.model;

import java.util.ArrayList;

import poketmon.model.db.PoketmonModelDB;
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
	public Trainer getTrainer(String tainerName) {
		Trainer trainer = null;
		for(int i = 0; i<getAllTrainer().size();i++) {
			trainer = getAllTrainer().get(i);
			if(trainer != null && trainer.getName().equals(tainerName)) {
				return trainer;
			}
		}
		throw new 
		
	}

	
	
	//Trainer 추가
	public void trainerInsert(Trainer trainer) {
		poketmonmodeldata.insertTrainer(trainer);
		
	}
	
	
	//Trainer 수정 
	
	
	
	// Trainer 삭제
	
}
