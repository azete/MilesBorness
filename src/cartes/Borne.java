package cartes;

public class Borne extends Carte {
	private int km;

	public Borne(int km) {
		this.km = km;
	}

	@Override
	public String toString() {
		return "Borne de " + km + " km.";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Borne) {
			return km == ((Borne)obj).getKm();
		}
		return false;
	}

	public int getKm() {
		return km;
	}
}
