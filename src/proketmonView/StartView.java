package proketmonView;

import poketmon.model.db.PoketmonModelDB;

public class StartView {
	public static void main(String[] args) {
		PoketmonModelDB poket = PoketmonModelDB.getInstance();
		
		
				
		// ��� Ʈ���̳� ���� ���
		System.out.println("��� Ʈ���̳� ���� ���");
		System.out.println(poket.getTrainer());

		// ���ο� ���ϸ� 
		
		// ���ο� Ʈ���̳�
	}
}


