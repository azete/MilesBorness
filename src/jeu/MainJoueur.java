package jeu;

import java.util.LinkedList;
import java.util.List;

import cartes.*;

public abstract class MainJoueur{
	private List<Carte> cartes= new LinkedList<>();;

    protected MainJoueur() {
    }

    public void prendre(Carte carte) {
        cartes.add(carte);
    }

    public void jouer(Carte carte) {
        assert cartes.contains(carte) : "La carte à jouer n'est pas présente dans la main.";
        cartes.remove(carte);
    }
    
    @Override
    public String toString() {
        return cartes.toString();
    }
}
