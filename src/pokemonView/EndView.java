package pokemonView;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import pokemon.exception.Log4j;
import pokemon.model.dto.Trainer;

public class EndView {
	private static Log4j log4j = Log4j.getInstance();
	
	// 출력속도 조절
	public static void slowPrint() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	// 특정 프로젝트 출력
	public static void viewTrainer(Trainer trainer) {
		System.out.println(trainer);
	}
	  
	// 모든 프로젝트 출력
	public static void viewList(ArrayList<Trainer> allData) {
		for(Trainer v : allData) {
			System.out.println(v);
		}
	}
	
	// 예외가 아닌 단순 메세지 출력
	public static void viewMessage(String message) {
		System.out.println(message);
	}
	
	// 포켓몬 배틀 승자 출력
	public static void viewWinner(Trainer t1, Trainer t2, Trainer winner) {
		slowPrint();
		System.out.println("\n" + t1.getName() + "의 '" + t1.getPokemon().getName() + "'  vs. " 
				+ t2.getName() + "의 '" + t2.getPokemon().getName() + "' 배틀!");
		slowPrint();
		System.out.println("...");
		slowPrint();
		System.out.println("...");
		slowPrint();
		System.out.println("승자는  " + winner.getName() + "의 '" + winner.getPokemon().getName() + "'!  정말 대단한 걸!");
		log4j.logTest("승자는  " + winner.getName() + "의 '" + winner.getPokemon().getName() + "'!  정말 대단한 걸!");
		log4j.logTest("");
	}
	

	// disply 출력 메소드
	public static void display(BufferedImage image, int width, int height) {
		for(int y = 0; y<height; y++) {
			StringBuilder builder = new StringBuilder();
			for(int x = 0; x<width; x++) {
				builder.append(image.getRGB(x, y) == -16777216 ? " " : "@");
//				builder.append(image.getRGB(x, y) == -16777216 ? "*" : " ");
			}
			System.out.println(builder);
	        for (int i = 0; i < builder.length(); i++){
	            System.out.print(builder.charAt(i));
	            try{
	                Thread.sleep(1);
	            }
	            catch (InterruptedException e){
	                e.printStackTrace();
	            }
	        } 
		}
	}
}
