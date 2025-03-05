package cartes;

public abstract class Carte {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Carte carte = (Carte) obj;
		return this.getClass() == carte.getClass();
	}
}
