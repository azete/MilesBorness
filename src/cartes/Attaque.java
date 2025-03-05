package cartes;

public class Attaque extends Bataille {

	public Attaque(Type type) {
		super(type);
	}

	@Override
	public String toString() {
		Type type = getType();
		return type.getAttaque();
	}

}
