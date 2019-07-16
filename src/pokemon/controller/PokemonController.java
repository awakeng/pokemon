package pokemon.controller;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

import pokemon.exception.NotExistException;
import pokemon.model.PokemonModelMethod;
import pokemon.model.dto.Trainer;
import pokemonView.EndView;
import pokemonView.FailView;

public class PokemonController {
	private static PokemonController instance = new PokemonController();
	private PokemonModelMethod method = PokemonModelMethod.getInstance(); 
	
	private PokemonController() {}
	public static PokemonController getInstance() {
		return instance;
	}
	
	// 모든 트레이너 검색
	public void TrainerListView() {
		ArrayList<Trainer> trainerList = method.getAllTrainers();
		if(trainerList.size() != 0) {
			EndView.viewList(trainerList);
		}else {
			EndView.viewMessage("dd");
			
		}
	}
	
	// 특정 트레이너 검색
	public void viewTrainer(String trainerName) throws NotExistException {
		Trainer trainer = method.getTrainer(trainerName);
		if(trainer != null) {
			EndView.viewTrainer(trainer);
		} else {
			EndView.viewMessage("존재하지 않는 트레이너 입니다.");
		}
	}
	
	// 새로운 트레이너 저장
	public void insertTrainer(Trainer newTrainer) {
		method.trainerInsert(newTrainer);
	}

	// 존재하는 트레이너 수정
	public void updateData(String trainerName, Object obj) {
		try {
			method.dataUpdate(trainerName, obj);
		} catch (NotExistException e) {
			FailView.failMessageView(e.getMessage());
		}
	}
	
	// 트레이너 삭제
	public void deleteTrainer(String trainerName) {
		try {
			method.trainerDelete(trainerName);
		} catch (NotExistException e) {
			FailView.failMessageView(e.getMessage());
			//e.printStackTrace();
		}
	}
	
	// 포켓몬 배틀
	public void battlePokemon(Trainer t1, Trainer t2) {
		Trainer winner = method.pokemonBattle(t1, t2);
		EndView.viewWinner(t1, t2, winner);
	}
	
	// 포켓몬 리그
	public String leaguePokemon(ArrayList<Trainer> tl) {
		ArrayList<Trainer> tmp = method.pokemonLeague(tl);
		Trainer t1 = tmp.get(0);
		Trainer t2 = tmp.get(1);
		Trainer winner = method.pokemonBattle(t1, t2);
		EndView.viewWinner(t1, t2, winner);
		//	포켓몬 배틀 1회 실행, 엔드뷰에서 받기
		return winner.getName();
	}
	
	
	// display 메인 메소드
	public static void printDisplay(String letter, int width, int height, int margin) {
		//POKEMON
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		g.setFont(new Font("SansSerif", Font.BOLD, 14));
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2.drawString(letter, margin, 15);
		//POKEMON
		EndView.display(image, width, height);
	}
}


