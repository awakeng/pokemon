package poketmon.model;

import poketmon.exception.NotExistException;
import poketmon.model.dto.Poketmon;
import poketmon.model.dto.Trainer;

public class PoketmonModelMethod {

	
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
		}
		
	}
}
