package fr.eni.demo;

public class Voiture implements Deplacable {

	@Override
	public void rouler() {
		System.out.println("ma voiture roule !");
		
	}

	@Override
	public void freiner() {
		System.out.println("ma voiture freine, masi pas aussi bien que la voiture3 !");
		
	}

}
