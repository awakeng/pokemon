package pokemon.model.dto;

import lombok.Data;

@Data
public class Pokemon {
	private String name;
	private int privateNo;
	private int hp;
	private double dp;
	String pokemonType;	// 추후 반영
	
	public Pokemon(String name, int privateNo, int hp, double dp, String pokemonType) {
		super();
		this.name = name;
		this.privateNo = privateNo;
		this.hp = hp;
		this.dp = dp;
		this.pokemonType = pokemonType;
	}


	
	
	
	
}
