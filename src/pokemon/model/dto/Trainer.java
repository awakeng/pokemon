package pokemon.model.dto;

import lombok.Data;

@Data
public class Trainer {
	private String name;
	private String hometown;
	private Pokemon pokemon;
	private int badge;
	
	public Trainer(String name, String hometown, Pokemon pokemon, int badge) {
		super();
		this.name = name;
		this.hometown = hometown;
		this.badge = badge;
		this.pokemon = pokemon;
	}
	
}
