package proketmonView;

import poketmon.model.db.PoketmonModelDB;

public class StartView {
	public static void main(String[] args) {
		PoketmonModelDB poket = PoketmonModelDB.getInstance();
		
		
				
		System.out.println(poket.getTrainer());
//		System.out.println(poket.a);
	}
}


