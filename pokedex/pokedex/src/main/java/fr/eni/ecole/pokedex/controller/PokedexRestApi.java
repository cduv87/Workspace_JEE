package fr.eni.ecole.pokedex.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.eni.ecole.pokedex.bll.bo.Pokemon;
import fr.eni.ecole.pokedex.bll.manager.ManagerFactory;
import fr.eni.ecole.pokedex.bll.manager.PokedexManager;

@CrossOrigin(origins = "*")
@RestController
public class PokedexRestApi {
	
	private PokedexManager pokedexManager = ManagerFactory.getPokedexManager();
	
	@GetMapping("/pokemons")
	public List<Pokemon> getPokemons() {
		return pokedexManager.findAll();
		
	}
}
