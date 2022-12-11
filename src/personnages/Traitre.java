package personnages;

import java.util.Random;

public class Traitre extends Samourai{
	private int nivTraitre = 0;
	
	public Traitre(String seigneur, String nom, String boissonFavorite, int argent) {
		super(seigneur, nom, boissonFavorite, argent);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void direBonjour() {
		super.direBonjour();
		parler("Mais je suis un traître et mon niveau de traîtrise est : " + nivTraitre + ". Chut !");
	}
	
	public void ranconner(Commercant commercant) {
		if (nivTraitre < 3) {
			int rancon = commercant.getArgent()/5;
			commercant.perdreArgent(rancon);
			gagnerArgent(rancon);
			parler("Si tu veux ma protection contre les Yakuzas, il va falloir payer ! Donne-moi " + rancon + " sous ou gare à toi !");
			commercant.parler("Tout de suite grand " + getNom() + ".");
			nivTraitre++;
		} else {
			parler("Mince je ne peux plus rançonner personne sinon un samouraï risque de me démasquer !");
		}
	}
	
	public void faireLeGentil() {
		if (nbConnaissance < 1) {
			parler("Je ne peux faire ami ami avec personne car je ne connais personne ! Snif.");
		} else {
			int don = getArgent()/20;
			Random random = new Random();
			int randomConnaissance = random.nextInt(nbConnaissance);
			Humain ami = memoire[randomConnaissance];
			String nomAmi = ami.getNom();
			parler("Il faut absolument remonter ma cote de confiance. Je vais faire ami ami avec " + nomAmi + ".");
			parler("Bonjour l'ami ! Je vousdrais vous aider en vous donnant " + don + " sous.");
			ami.gagnerArgent(don);
			perdreArgent(don);
			ami.parler("Merci " + getNom() + ". Vous êtes quelqu'un de bien.");
			if (nivTraitre > 0)
				nivTraitre--;
		}
	}

}
