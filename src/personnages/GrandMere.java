package personnages;

import java.util.Random;

public class GrandMere extends Humain {

	public GrandMere(String nom, int argent) {
		super(nom, "tisane", argent);
	}
	
	private enum TypeHumain {
		COMMERCANT("un Commerçant"),
		GRANDMERE("une Grand-mère"),
		RONIN("un Ronin"),
		SAMOURAI("un Samouraï"),
		YUKUZA("un Yakuza");
		
		private String nom;
		
		TypeHumain(String nom) {
			this.nom = nom;
		}
		
		@Override
		public String toString() {
			return nom;
		}
	}
	
	@Override
	protected void memoriser(Humain humain) {
		if (nbConnaissance >= 5) {
			parler("Oh ma tête ! Je ne peux plus retenir le nom d'une personne supplémentaire !");
		} else {
			super.memoriser(humain);			
		}
	}
	
	private String humainHasard() {
		TypeHumain[] types = TypeHumain.values();
		Random random = new Random();
		int randomType = random.nextInt(types.length);
		String type = types[randomType].toString();
		return type;
	}
	
	public void ragoter() {
		for (int i=0 ; i<nbConnaissance ; i++) {
			Humain connaissance = memoire[i];
			String nomConnaissance = connaissance.getNom();
			if (connaissance instanceof Traitre) {
				parler("Je sais que " + nomConnaissance + " est un traitre. Petit chenapan !");
			} else {
				String type = humainHasard();
				parler("Je crois que " + nomConnaissance + " est " + type + ".");
			}
			
		}
	}
}
