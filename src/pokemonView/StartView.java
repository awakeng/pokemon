package pokemonView;

import java.io.File;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import pokemon.controller.PokemonController;
import pokemon.exception.NotExistException;
import pokemon.model.PokemonModelMethod;
import pokemon.model.dto.Trainer;


public class StartView {
	
	public static void main(String[] args) throws NotExistException {
		PokemonController controller = PokemonController.getInstance();	
		PokemonModelMethod method = PokemonModelMethod.getInstance();
		ArrayList<Trainer> trainerList = method.getAllTrainers();
		
		// 1 vs. 1 배틀 3개
		System.out.println("1 vs. 1 Pokemon Battle!");
		for(int i = 0; i<trainerList.size()-5; i+=2) {
			controller.battlePokemon(trainerList.get(i), trainerList.get(i+1));			
		}
		EndView.slowPrint();
		System.out.println("\n포켓몬 리그: 포켓몬 마스터는 누구?!");
	
		
		// 너비
		int width = 250;
		int height = 20;
		String pokemonMaster = controller.leaguePokemon(method.getAllTrainers());
		controller.printDisplay("POKEMON MASTER", width, height, 10);
		controller.printDisplay(pokemonMaster, width, height, 50);

//		playSound();
	}
//	public static void playSound() {
//	    try {
//	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:/0.encore/pokemonEnding.wav").getAbsoluteFile());
//	        Clip clip = AudioSystem.getClip();
//	        clip.open(audioInputStream);
//	        System.out.println("aa");
//	        clip.start();
//	        System.out.println("bb");
//	    } catch(Exception ex) {
//	        System.out.println("Error with playing sound.");
//	        ex.printStackTrace();
//	    }
//	}
	
}


