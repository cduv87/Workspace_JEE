package fr.eni.jee.bo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Repas {
	
	/*
	 * Attributs
	 */
	private int id; // va me servir pour retrouver les repas en base de donnée dans la vue d'affichage
	private LocalDate date;
	private LocalTime heure;
	private List<String> aliments = new ArrayList<String>();
	
	
	/*
	 * Constructeurs
	 */
	public Repas(LocalDate date, LocalTime heure) {
		super();
		this.date = date;
		this.heure = heure;
	}
	
	public Repas(int id, LocalDate date, LocalTime heure) {
		super();
		this.id = id;
		this.date = date;
		this.heure = heure;
	}



	/*
	 * GETTER / SETTERS
	 */
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


	public LocalTime getHeure() {
		return heure;
	}


	public void setHeure(LocalTime heure) {
		this.heure = heure;
	}


	public List<String> getAliments() {
		return aliments;
	}


	public void setAliments(List<String> aliments) {
		this.aliments = aliments;
	}
	
	
	/*
	 * Autres méthodes
	 */
	public void addAliment(String aliment) {
		// on utilise trim() pour enlever les espaces blancs indésirables de nos aliments 
		this.aliments.add(aliment.trim());
	}

	@Override
	public String toString() {
		return "Repas [id=" + id + ", date=" + date + ", heure=" + heure + ", aliments=" + aliments + "]";
	}
}
