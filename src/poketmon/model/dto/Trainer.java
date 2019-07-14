package poketmon.model.dto;

public class Trainer {
	private String name;
	private String hometown;
	private Poketmon poketmon;
	private int badge;
	
	public Trainer(String name, String hometown, Poketmon poketmon, int badge) {
		super();
		this.name = name;
		this.hometown = hometown;
		this.badge = badge;
		this.poketmon = poketmon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public int getBadge() {
		return badge;
	}

	public void setBadge(int badge) {
		this.badge = badge;
	}

	public Poketmon getPoketmon() {
		return poketmon;
	}

	public void setPoketmon(Poketmon poketmon) {
		this.poketmon = poketmon;
	}

	@Override
	public String toString() {
		return "Trainer [name=" + name + ", hometown=" + hometown + ", poketmon=" + poketmon + ", badge=" + badge + "]\n";
	}

	
	
	
}
