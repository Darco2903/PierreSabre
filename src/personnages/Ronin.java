package personnages;

public class Ronin extends Humain {
	private int honneur = 1;

	public Ronin(String nom, String boissonFavorite, int argent) {
		super(nom, boissonFavorite, argent);
	}
	
	public void donner(Commercant beneficiaire) {
		int don = getArgent()/10;
		parler(beneficiaire.getNom() + " prend ces " + don + " sous.");
		beneficiaire.recevoir(don);
	}
	
	public void provoquer(Yakuza adversaire) {
		parler("Je t'ai retrouvé vermine, tu vas payer pour ce que tu as fait à ce pauvre marchand !");
		int force = honneur *2;
		if (force >= adversaire.getReputation()) {
			parler("Je t'ai eu petit yakuza !");
			gagnerArgent(adversaire.perdre());
			honneur ++;
		} else {
			parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse en ont pris un coup.");
			int perte = getArgent();
			perdreArgent(perte);
			adversaire.gagner(perte);
			honneur --;
		}
	}

}
