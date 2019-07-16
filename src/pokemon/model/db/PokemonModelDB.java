package pokemon.model.db;

import java.util.ArrayList;

import pokemon.model.dto.Pokemon;
import pokemon.model.dto.Trainer;


//ProbonoModelVirtualDB과 같은 역할
public class PokemonModelDB {
	private static PokemonModelDB instance = new PokemonModelDB();
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
	  
	private PokemonModelDB() {
	
		trainerList.add(new Trainer("지우","태초마을",new Pokemon("피카츄", 25, 					145, 3, "전기"), 2) );		// 435
		trainerList.add(new Trainer("이슬이","오렌지시티",new Pokemon("별가사리", 105, 				180, 2, "물"), 2) );			// 360
		trainerList.add(new Trainer("웅이","회색시티",new Pokemon("롱스톤", 45, 					180, 2, "돌"), 2) );			// 360
		trainerList.add(new Trainer("오바람","태초마을",new Pokemon("이브이", 100, 				180, 2, "노말"), 2) );		// 360
		trainerList.add(new Trainer("로이","로켓단",new Pokemon("또가스", 25, 					170, 2, "독"), 2) );			// 340
		trainerList.add(new Trainer("로사","로켓단",new Pokemon("아보", 105, 					170, 2, "독"), 2) );			// 340
		trainerList.add(new Trainer("로켓단(보스)","로켓단",new Pokemon("페르시온", 45, 			150, 2, "노말"), 2) );		// 300
		trainerList.add(new Trainer("로켓단(간부)","로켓단",new Pokemon("레트라", 45, 				100, 3, "노말"), 2) );		// 300
		trainerList.add(new Trainer("로켓단(조무레기)","로켓단",new Pokemon("꼬렛", 100, 			140, 2, "노말"), 2) );		// 280
		trainerList.add(new Trainer("사천왕_목호","사천왕",new Pokemon("망나뇽", 100, 				100, 3, "드래곤"), 2) );		// 300
		shuffle(trainerList);
	
	}
	
	//Singleton
	public static PokemonModelDB getInstance() {
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
	
	//삭제
	public void deleteProject(Trainer newTrainer) {
		trainerList.remove(newTrainer);
	}
	
	
}
