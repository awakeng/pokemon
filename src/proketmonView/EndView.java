package proketmonView;

import java.util.ArrayList;

import poketmon.model.dto.Trainer;

public class EndView {

	// 특정 프로젝트 출력
	public static void viewAll(Trainer trainer) {
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
}
