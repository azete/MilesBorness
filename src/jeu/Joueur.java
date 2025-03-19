package jeu;

import java.util.Objects;

import cartes.Carte;

public class Joueur {
    private final String nom;
    private ZoneDeJeu zoneDeJeu;
    private MainJoueur main;

    public Joueur(String nom, ZoneDeJeu zoneDeJeu) {
        this.nom = nom;
        this.zoneDeJeu = zoneDeJeu;
    }

    public String getNom() {
        return nom;
    }

    public ZoneDeJeu getZoneDeJeu() {
        return zoneDeJeu;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Joueur joueur = (Joueur) obj;
        return this.getClass() == joueur.getClass();
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }

    @Override
    public String toString() {
        return getNom();
    }
    
    public void donner(Carte carte) {
        main.prendre(carte);
    }
    
    public Carte prendreCarte(Sabot sabot) {
    	if(!sabot.estVide()) {
    		Carte carte = sabot.piocher();
    		donner(carte);
    		return carte;
    	} else {
    		return null;		
    	}
    }
    
    public boolean deposer(Carte c) {
    	return zoneDeJeu.deposer(c);
	}

    public boolean estDepotAutorise(Carte carte) {
        return zoneDeJeu.estDepotAutorise(carte);
    }
}