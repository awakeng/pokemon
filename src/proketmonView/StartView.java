package proketmonView;

import poketmon.model.db.PoketmonModelDB;

public class StartView {
	public static void main(String[] args) {
		PoketmonModelDB poket = PoketmonModelDB.getInstance();
		
		//trainer 등록
		//trainer 삭제
		
				
		System.out.println(poket.getTrainer());
//		System.out.println(poket.a);
	}
}


