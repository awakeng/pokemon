package proketmon.model.dto;


public class Poketmon {
	private String name;
	private int privateNo;
	private int hp;
	private int dp;
//	String poketmonType;	// 추후 반영
	public Poketmon(String name, int privateNo, int hp, int dp) {
		super();
		this.name = name;
		this.privateNo = privateNo;
		this.hp = hp;
		this.dp = dp;
	}
	
	
	
}
