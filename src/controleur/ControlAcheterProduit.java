package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur, Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	// TODO a completer
	public boolean verifierAcheteur(String nomAcheteur) {
		return controlVerifierIdentite.verifierIdentite(nomAcheteur);
	}

	public String[] rechercherVendeurProduit(String produit) {
		Gaulois[] vendeurs = village.rechercherVendeursProduit(produit);
		if (vendeurs == null || vendeurs.length == 0) {
			return new String[0]; // Aucun vendeur trouvé
		}

		String[] nomsVendeurs = new String[vendeurs.length];
		for (int i = 0; i < vendeurs.length; i++) {
			nomsVendeurs[i] = vendeurs[i].getNom();
		}
		return nomsVendeurs;
	}

	public int acheterProduit(String nomVendeur, int quantiteVoulu) {
		Gaulois vendeur = village.trouverHabitant(nomVendeur);
		if (vendeur == null) {
			return -2; // Indique que le vendeur n'est pas un habitant du village
		}

		Etal etal = village.rechercherEtal(vendeur);
		if (etal == null) {
			return -1; // Pas d'étal pour ce vendeur
		}

		return etal.acheterProduit(quantiteVoulu);
	}
}
