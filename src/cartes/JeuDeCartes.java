package cartes;

public class JeuDeCartes {

	private Configuration[] typesDeCartes = { new Configuration(new Borne(25), 10),
			new Configuration(new Borne(50), 10), new Configuration(new Borne(75), 10),
			new Configuration(new Borne(100), 12), new Configuration(new Borne(200), 4),
			new Configuration(new Botte(Type.FEU), 1), new Configuration(new Botte(Type.ACCIDENT), 1),
			new Configuration(new Botte(Type.ESSENCE), 1), new Configuration(new Botte(Type.CREVAISON), 1),
			new Configuration(new Attaque(Type.FEU), 5), new Configuration(new Attaque(Type.ACCIDENT), 3),
			new Configuration(new Attaque(Type.CREVAISON), 3), new Configuration(new Attaque(Type.ESSENCE), 3),
			new Configuration(new Parade(Type.FEU), 14), new Configuration(new Parade(Type.ESSENCE), 6),
			new Configuration(new Parade(Type.ACCIDENT), 6), new Configuration(new Parade(Type.CREVAISON), 6),
			new Configuration(new DebutLimite(), 4), new Configuration(new FinLimite(), 6), };

	private static class Configuration {

		private int nbExemplaires;
		private Carte carte;

		private Configuration(Carte carte, int nbExemplaire) {
			this.nbExemplaires = nbExemplaire;
			this.carte = carte;
		}

		public Carte getCarte() {
			return carte;
		}

	}

	public String affichageJeuCartes() {
		StringBuilder affichage = new StringBuilder();
		for (int i = 0; i < typesDeCartes.length; i++) {
			affichage.append(typesDeCartes[i].nbExemplaires + " " + typesDeCartes[i].getCarte() + "\n");
		}
		return affichage.toString();
	}

	public Carte[] donnerCartes() {
		int compte = 0;
		for (int i = 0; i < typesDeCartes.length; i++) {
			compte += typesDeCartes[i].nbExemplaires;
		}
		Carte[] carte = new Carte[compte];

		for (int i = 0, j = 0; i < typesDeCartes.length; i++) {
			for (int k = 0; k < typesDeCartes[i].nbExemplaires; k++) {
				carte[j] = typesDeCartes[i].carte;
				j++;
			}
		}
		return carte;
	}

	private int count(Carte[] tab_carte, Carte cartes) {
		int nb = 0;
		for (Carte i : tab_carte) {
			if (i.equals(cartes))
				nb++;
		}
		return nb;
	}

	public boolean checkCount() {
		Carte[] Carte = donnerCartes();
		int compteur=0;
		for (int i = 0; i < Carte.length; i = i + count(Carte, Carte[i])) {
			if (count(Carte, Carte[i]) != typesDeCartes[compteur].nbExemplaires)
				return false;
			compteur++;
		}
		return true;
	}
}
