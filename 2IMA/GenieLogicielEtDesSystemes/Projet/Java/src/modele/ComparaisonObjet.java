package modele;

public class ComparaisonObjet extends Comparaison {

	private Objet objet;
	private Comparateur comparateur;
	
	public ComparaisonObjet(Objet o,Comparateur c){
		this.comparateur=c;
		this.objet=o;
	}

	public Objet getObjet() {
		return objet;
	}

	public Comparateur getComparateur() {
		return comparateur;
	}
	
}
