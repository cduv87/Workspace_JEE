package fr.eni.demo;

public class Main {

	public static void main(String[] args) {
	Voiture voiture1 = new Voiture();
	Deplacable voiture2 = new Voiture();
	
	voiture1.rouler();
	voiture2.rouler();
	
	Deplacable voiture3 = new Deplacable() {
		
		@Override
		public void rouler() {
			System.out.println("Ma voiture 3 roule de ouf");
			
		}

		@Override
		public void freiner() {
			System.out.println("Ma voiture 3 freine de ouf");
			
		}
	};
	
	voiture3.rouler();
	voiture3.freiner();
	
	//ifreinable iroulable
	
	iRoulable velo1 = new iRoulable() {
		
		@Override
		public void rouler() {
			// TODO Auto-generated method stub
			
		}
	};
	
	iFreinable velo2 = new iFreinable() {
		
		@Override
		public void freiner() {
			// TODO Auto-generated method stub
			
		}
	};
	

	}

}
