package poketmon.model.db;

import java.util.ArrayList;

import poketmon.model.dto.Poketmon;
import poketmon.model.dto.Trainer;


//ProbonoModelVirtualDB과 같은 역할
public class PoketmonModelDB {
	private static PoketmonModelDB instance = new PoketmonModelDB();
	private ArrayList<Trainer> trainerList = new ArrayList<Trainer>();
	
	
	  public static ArrayList<Trainer> shuffle(ArrayList<Trainer> al) {
	      for(int i = 0; i < al.size()*2; i++) {
	         int x = (int)(Math.random()*al.size());
	         int y = (int)(Math.random()*al.size());
	         
	         Trainer tmp = al.get(x);
	         al.set(x, al.get(y));
	         al.set(y, tmp);
	      }
	      return al;
	   }
	  
	private PoketmonModelDB() {
	
		trainerList.add(new Trainer("지우","태초마을",new Poketmon("피카츄", 25, 100, 10, "전기"),2) );
		trainerList.add(new Trainer("이슬","오렌지마을",new Poketmon("꼬부기", 105, 55, 8, "물"),2) );
		trainerList.add(new Trainer("바람","그린마을",new Poketmon("파이리", 45, 99, 9, "불"),2) );
		shuffle(trainerList);
	
	}
	
	//Singleton
	public static PoketmonModelDB getInstance() {
		return instance;
	}
	
	
	// 등록
	public void insertTrainer(Trainer newTrainer) {
		trainerList.add(newTrainer);
	}
	
	//검색
	public ArrayList<Trainer> getTrainerList(){
		return trainerList;
	}
	
	
	//수정
	
	//삭제
	
	
	
}
