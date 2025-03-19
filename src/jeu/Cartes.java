package jeu;

import cartes.Attaque;
import cartes.Botte;
import cartes.Carte;
import cartes.Parade;
import cartes.Type;

public interface Cartes {
	
	    Carte PRIORITAIRE = new Botte(Type.FEU);
	    Carte FEU_ROUGE = new Attaque(Type.FEU);
	    Carte FEU_VERT = new Parade(Type.FEU);

}
