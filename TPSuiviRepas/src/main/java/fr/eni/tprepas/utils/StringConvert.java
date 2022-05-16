package fr.eni.tprepas.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringConvert {
	
	public List<String> StringToList(String ingredients) {
	
	List<String> ingredientsList = new ArrayList<String>(); 
	ingredientsList = Arrays.asList(ingredients.split(","));
//	int index = 0;
//	for (String e : ingredientsList) {
//		e.trim();
//		ingredientsList.set(index, e);
//		index++;
//	}
	return ingredientsList;
	}
}
