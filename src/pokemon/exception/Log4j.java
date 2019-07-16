package pokemon.exception;

import org.apache.log4j.Logger;

import pokemon.model.PokemonModelMethod;

public class Log4j {
	private static Log4j instance = new Log4j();
	
	public static Log4j getInstance() {
		return instance;
	}
	
	private final Logger logger = Logger.getLogger(PokemonModelMethod.class);

	public void logTest(String msg) {
		
		try {
			logger.info(msg);
		}catch(Exception e) {
			logger.error("got error",e);
		}
	}
}
