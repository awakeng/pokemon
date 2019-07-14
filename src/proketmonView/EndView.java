package proketmonView;

import java.util.ArrayList;

import poketmon.model.dto.Trainer;

public class EndView {

	// Ư�� ������Ʈ ���
	public static void viewAll(Trainer trainer) {
		System.out.println(trainer);
	}
	
	// ��� ������Ʈ ���
	public static void viewList(ArrayList<Trainer> allData) {
		for(Trainer v : allData) {
			System.out.println(v);
		}
	}
	
	// ���ܰ� �ƴ� �ܼ� �޼��� ���
	public static void viewMessage(String message) {
		System.out.println(message);
	}
}
