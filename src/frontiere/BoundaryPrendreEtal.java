package frontiere;

import controleur.ControlPrendreEtal;
import personnages.Gaulois;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		// TODO a completer
		boolean nomVendeurConnue = controlPrendreEtal.verifierIdentite(nomVendeur);
		if (!nomVendeurConnue) {
			System.out.println(
					"Je suis désolé " + nomVendeur + " mais il faut être un habitant du village pour commercer ici.");
			return;
		} else {
			System.out.println("Bonjour " + nomVendeur + ", je vais regarder si je peux vous trouver un étal.");
			if (!controlPrendreEtal.resteEtals()) {
				System.out.println("Désolé " + nomVendeur + ", je n'ai plus d'étal disponible.");
				return;
			} else {
				installerVendeur(nomVendeur);

			}
		}

	}

	private void installerVendeur(String nomVendeur) {
		// TODO a completer
		int nbproduit  = 0;
		System.out.println("C'est parfait, il me reste un étal pour vous !");
		System.out.println("Il me faudrait quelques renseignements :");
		System.out.print("Quel produit souhaitez-vous vendre ? ");
		String produit = Clavier.entrerChaine("");
		System.out.print("Combien souhaitez-vous en vendre ? ");
		nbproduit = Clavier.entrerEntier("");
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbproduit);
		if(numeroEtal!=-1) {
            System.out.println("Le vendeur " + nomVendeur + " s'est installé à l'étal n°" + numeroEtal);
		}

	}
}
