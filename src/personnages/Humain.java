package personnages;

public class Humain {
	private String nom;
	private String boissonFavorite;
	private int argent;
	final int MEMOIRE_MAX = 30;
	protected Humain[] memoire = new Humain[MEMOIRE_MAX]; 
	protected int nbConnaissance = 0;
	
	public Humain(String nom, String boissonFavorite, int argent) {
		this.nom = nom;
		this.boissonFavorite = boissonFavorite;
		this.argent = argent;
	}

	public String getNom() {
		return nom;
	}

	public int getArgent() {
		return argent;
	}
	
	protected void parler(String texte) {
		System.out.println("(" + nom + ") - " + texte);
	}
	
	public void direBonjour() {
		parler("Bonjour ! Je m'appelle " + nom + " et j'aime boire du " + boissonFavorite + ".");
	}
	
	public void boire() {
		parler("Mmmm, un bon verre de " + boissonFavorite + " ! GLOUPS !");
	}
	
	protected void gagnerArgent(int sommeGagnee) {
		argent += sommeGagnee;
	}
	
	protected void perdreArgent(int sommePerdue) {
		argent -= sommePerdue;
	}
	
	public void acheter(String bien, int prix) {
		String argentEnPoche = argent + " sous en poche. ";
		String moffrir = "m'offrir un(e) " + bien + " à " + prix + " sous.";
		if (prix < argent) {
			parler("J'ai " + argentEnPoche + "Je vais pouvoir " + moffrir);
			perdreArgent(prix);
		} else {
			parler("Je n'ai plus que " + argentEnPoche + "Je ne peux même pas " + moffrir);
		}
	}
	
	public void faireConnaissance(Humain humain) {
		//	System.out.println("Le '' " + getNom() + " rencontre le ''");
		direBonjour();
		humain.repondre(this);
		memoriser(humain);
	}
	
	protected void memoriser(Humain humain) {
		if (nbConnaissance >= MEMOIRE_MAX) {
			nbConnaissance--;
			memoire = shiftPush(memoire, humain);
		}
		memoire[nbConnaissance] = humain;
		nbConnaissance++;
	}
	
	private Humain[] shiftPush(Humain[] array, Humain toAdd) {
		// Efface le premier humain et ajoute l'humain "toAdd" au dernier index
		int n = array.length;
		for (int i=1 ; i<n ; i++) {
			array[i -1] = array[i];
		}
		array[n -1] = toAdd;
		return array;
	}
	
	private void repondre(Humain humain) {
		direBonjour();
		memoriser(humain);
	}
	
	public void listerConnaissance() {
		String texte = "Je connais beaucoup de monde dont: ";
		texte += memoire[0].getNom();
		for (int i=1 ; i<nbConnaissance ; i++) {
			texte += ", " + memoire[i].getNom();
		}
		parler(texte);
	}
}
