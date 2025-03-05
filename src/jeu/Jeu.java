package jeu;

import java.util.Arrays;
import java.util.List;

import cartes.Carte;
import cartes.JeuDeCartes;
import utils.GestionCartes;

public class Jeu {
	private Sabot sabot;
	
	public Jeu() {
		JeuDeCartes JeuDeCartes= new cartes.JeuDeCartes();
		Carte[] carte= JeuDeCartes.donnerCartes();
		
		List<Carte> listeCartes= Arrays.asList(carte);
		List<Carte> ListeMelange= GestionCartes.melanger(listeCartes);
		
		sabot= new Sabot(ListeMelange.toArray(carte));
	}
	public Sabot getSabot() {
		return sabot;
	}
	
}
