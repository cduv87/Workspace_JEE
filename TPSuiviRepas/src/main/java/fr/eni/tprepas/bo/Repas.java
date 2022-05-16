package fr.eni.tprepas.bo;

import java.time.*;
import java.util.ArrayList;
import java.util.List;

public class Repas {
	int id;
	LocalDate date;
	LocalTime time;
	List<String> ingredients = new ArrayList<String>();
	

	public Repas() {

	}
	
	public Repas(LocalDate date, LocalTime time, List<String> ingredients2) {
		this.date = date;
		this.time = time;
		this.ingredients = ingredients2;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	public List<String> getIngredients() {
		return ingredients;
	}
	public void setIngredients(ArrayList<String> ingredients) {
		this.ingredients = ingredients;
	}


	@Override
	public String toString() {
		return "Repas [id=" + id + ", date=" + date + ", time=" + time + ", ingredients=" + ingredients + "]";
	}
	
	
	

}
