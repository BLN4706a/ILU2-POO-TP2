package controleur;

import villagegaulois.Etal;

public class ControlLibererEtal {
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;

	public ControlLibererEtal(
			ControlTrouverEtalVendeur controlTrouverEtalVendeur) {
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	//TODO a completer
	public boolean isVendeur(String nomVendeur) {
        Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
        return etal != null && etal.isEtalOccupe();
    }
	/**
	 * 
	 * @param nomVendeur
	 * @return donneesEtal est un tableau de chaine contenant
	 * 		[0] : un boolean indiquant si l'étal est occupé
	 * 		[1] : nom du vendeur
	 * 		[2] : produit vendu
	 * 		[3] : quantité de produit à vendre au début du marché
	 * 		[4] : quantité de produit vendu
	 */
	public String[] libererEtal(String nomVendeur) {
		//TODO a completer
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);

	    if (etal == null || !etal.isEtalOccupe()) {
	        return new String[]{ "false" }; // Le vendeur n’a pas d’étal ou il est déjà libre
	    }

	    // Récupérer les informations de l’étal avant de le libérer
	    String[] donneesEtal = etal.etatEtal();

	    // Libérer l’étal
	    etal.libererEtal();

	    return donneesEtal;
		
	}

}
