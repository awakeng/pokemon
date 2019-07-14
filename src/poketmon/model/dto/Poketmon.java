package poketmon.model.dto;


public class Poketmon {
	private String name;
	private int privateNo;
	private int hp;
	private int dp;
	String poketmonType;	// 추후 반영
	
	public Poketmon(String name, int privateNo, int hp, int dp, String poketmonType) {
		super();
		this.name = name;
		this.privateNo = privateNo;
		this.hp = hp;
		this.dp = dp;
		this.poketmonType = poketmonType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrivateNo() {
		return privateNo;
	}

	public void setPrivateNo(int privateNo) {
		this.privateNo = privateNo;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getDp() {
		return dp;
	}

	public void setDp(int dp) {
		this.dp = dp;
	}

	public String getPoketmonType() {
		return poketmonType;
	}

	public void setPoketmonType(String poketmonType) {
		this.poketmonType = poketmonType;
	}

	@Override
	public String toString() {
		return "Poketmon [name=" + name + ", privateNo=" + privateNo + ", hp=" + hp + ", dp=" + dp + ", poketmonType="
				+ poketmonType + "]";
	}
	
	
	
	
}
