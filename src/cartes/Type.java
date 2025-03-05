package cartes;

public enum Type {
	ESSENCE("Panne d'essence", "Bidon d'essence", "Citerne"), 
	CREVAISON("Crevaison", "Roue de secours", "Increvable"), 
	ACCIDENT("Accident", "Reparation", "As du volant"),
	FEU ("Feu Rouge","Feu Vert", "Vehicule Prioritaire"), ;
	
	private final String attaque;
	private final String parade;
	private final String botte;
	
	private Type(String attaque, String parade, String botte){
		this.attaque=attaque;
		this.botte=botte;
		this.parade=parade;
	}

	public String getAttaque() {
		return attaque;
	}

	public String getParade() {
		return parade;
	}

	public String getBotte() {
		return botte;
	}
	
};
