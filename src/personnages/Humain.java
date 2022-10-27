package personnages;

public class Humain {
	protected String nom;
	protected String boissonFavorite;
	protected int argent;
	
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
	
	public void direBonjour() {
		parler("Bonjour ! Je m'appelle " + nom + " et j'aime boire du " + boissonFavorite + ".");
	}
	
	public void boire() {
		parler("Mmmm, un bon verre de " + boissonFavorite + " ! GLOUPS !");
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
	
	public void gagnerArgent(int gain) {
		argent += gain;

	}
	
	public void perdreArgent(int perte) {
		argent -= perte;

	}
	
	protected void parler(String texte) {
		System.out.println("(" + nom + ") - " + texte);
	}
	
}
