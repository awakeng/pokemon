package pokemon.model;

import java.util.ArrayList;
import java.util.HashMap;

import pokemon.exception.Log4j;
import pokemon.exception.NotExistException;
import pokemon.model.db.PokemonModelDB;
import pokemon.model.dto.Pokemon;
import pokemon.model.dto.Trainer;
import pokemonView.EndView;

// ProbonoProjectService와 같은 역할
public class PokemonModelMethod {
	private static PokemonModelMethod instance = new PokemonModelMethod();
	private PokemonModelDB pokemonmodeldata = PokemonModelDB.getInstance();
	
	private static Log4j log4j = Log4j.getInstance();
	
	public static PokemonModelMethod getInstance() {
		return instance;
	}
	
	
	//모든 Trainer 반환
	public ArrayList<Trainer> getAllTrainers(){
		return pokemonmodeldata.getTrainerList();
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
		pokemonmodeldata.insertTrainer(trainer);
	}
	
	
	//Trainer 수정 
	public void dataUpdate(String trainerName, Object obj) throws NotExistException{
		Trainer trainer = getTrainer(trainerName);
		if(trainer == null) {
			throw new NotExistException("xxxxxxx 수정하고자 하는 Trainer가 미 존재합니다. xxxxxxx\n");
		}
		if(obj instanceof String) {
			trainer.setHometown((String)obj);
		} else if(obj instanceof Pokemon) {
			trainer.setPokemon((Pokemon)obj);
		} else if(obj instanceof Integer){
			trainer.setBadge((int)obj);			// 입력받은 값을 정수 타입으로 변환
		}
	} 
	
	// Trainer 삭제
	public void trainerDelete(String trainerName) throws NotExistException {
		Trainer trainer = getTrainer(trainerName);
		if(trainer == null) {
			throw new NotExistException("해당 트레이너가 없습니다.");
		}
		pokemonmodeldata.deleteProject(trainer);
	}
	
	//// 추가 기능  ///////////////////////////////
	
	// 포켓몬 배틀
	public Trainer pokemonBattle(Trainer t1, Trainer t2) {
	      int hp1 = t1.getPokemon().getHp();
	      int hp2 = t2.getPokemon().getHp();
	      log4j.logTest(t1.getName() + "의 '" + t1.getPokemon().getName() + "'  vs. " 
	            + t2.getName() + "의 '" + t2.getPokemon().getName() + "' 배틀!");
	      while(true) {
	         log4j.logTest(t1.getPokemon().getName() + "\t공격");							// log4j 출력용
	         double dp1 = battleCoefficients(t1.getPokemon().getDp());
	         log4j.logTest(t2.getPokemon().getName() + "\t공격");
	         double dp2 = battleCoefficients(t2.getPokemon().getDp());
	         hp2 -= dp1;
	         hp1 -= dp2;      
	         if(hp2 <= 0 ) {
	            return t1;
	         }
	         if (hp1 <= 0) {
	            return t2;
	         }
	      }
	   }

	// 포켓몬 배틀 보조 메소드 (dp 계수, 크리티컬)
	//dp 계수, 크리티컬
	   public double battleCoefficients(double dp) {
	      double random1 = Math.round((Math.random()*10 + 5));
	      double random2 = Math.round(Math.random()*10);
	      if(random2 <= 2) {
	         log4j.logTest("..." + dp*random1*2 + "\t효과는 매우 강력했다!!");
	         return dp*random1*2;
	      } else if(random2 >= 9) {
	         log4j.logTest("..." + dp*random1/2 + "\t효과는 미미했다...");
	         return dp*random1/2;
	      } else {
	         log4j.logTest("..." + dp*random1);
	         return dp*random1;
	      }
	   }
	
	// 포켓몬 리그
	public  ArrayList<Trainer> pokemonLeague(ArrayList<Trainer> tl) {
		ArrayList<Trainer> tmp = new ArrayList<Trainer>();
		HashMap<String, ArrayList<Trainer>> hmt = new HashMap<>();
		
		tl.remove(9);
		tl.remove(8);

		hmt.put("8강", tl);
		leagueProcess(tl, tmp);
		
		hmt.put("준결승", tl);
		leagueProcess(tl, tmp);
		
		hmt.put("결승", tl);	
		EndView.slowPrint();
		System.out.print("결승 진출자 명단: ");
		System.out.print(tl.get(0).getName() + "  vs. " + tl.get(1).getName() +"\t");
		
		return hmt.get("결승");
	}
	
	// 포켓몬 리그 보조 메소드
	public void leagueProcess(ArrayList<Trainer> tl, ArrayList<Trainer> tmp) {
		EndView.slowPrint();
		System.out.print(tl.size() + "강 진출자 명단: ");
		for(int i = 0; i <tl.size()-1; i+=2) {
			EndView.slowPrint();
			System.out.print(tl.get(i).getName() + "  vs. " + tl.get(i+1).getName() +"\t");
			tmp.add(pokemonBattle(tl.get(i), tl.get(i+1)));
		}	System.out.println();
		tl.removeAll(tl);
		tl.addAll(tmp);		
		tmp.removeAll(tmp);
	}
	

}
