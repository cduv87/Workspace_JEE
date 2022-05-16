package fr.eni.ecole.pokedex.bll.manager;

import java.util.List;

import fr.eni.ecole.pokedex.bll.bo.Pokemon;
import fr.eni.ecole.pokedex.bll.manager.PokedexManagerImpl;

public abstract class ManagerFactory {
	
	public static PokedexManager getPokedexManager() {
		return PokedexManagerImpl.getInstance();
			
	
	}

}
