package controleur;

import villagegaulois.Village;

public class ControlAfficherMarche {
	private Village village;

	public ControlAfficherMarche(Village village) {
		this.village = village;
	}

	// TODO a completer
	public String[] donnerInfosMarche() {
		return village.donnerEtatMarche(); // Supposons que cette méthode existe dans la classe Village
	}
}
