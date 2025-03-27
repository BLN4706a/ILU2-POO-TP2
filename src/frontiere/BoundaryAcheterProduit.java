package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		// TODO à completer
		if (!controlAcheterProduit.verifierAcheteur(nomAcheteur)) {
			System.out.println("Je suis désolé " + nomAcheteur + ", il faut être un habitant du village pour acheter.");
			return;
		}
		System.out.println("Quel produit voulez-vous acheter ?");
		String produit = Clavier.entrerChaine("");

		String[] vendeurs = controlAcheterProduit.rechercherVendeurProduit(produit);
		if (vendeurs.length == 0) {
			System.out.println("Désolé, personne ne vend ce produit au marché.");
			return;
		}

		System.out.println("Chez quel commerçant voulez-vous acheter des " + produit + " ?");
		for (int i = 0; i < vendeurs.length; i++) {
			System.out.println((i + 1) + " - " + vendeurs[i]);
		}
		int choixVendeur = Clavier.entrerEntier("");
		String nomVendeur = vendeurs[choixVendeur - 1];

		System.out.println("Bonjour " + nomAcheteur + ", combien de " + produit + " voulez-vous acheter ?");
		int quantiteVoulu = Clavier.entrerEntier("");

		int quantiteAchetee = controlAcheterProduit.acheterProduit(nomVendeur, quantiteVoulu);
		if (quantiteAchetee == -2) {
			System.out.println("Je suis désolé " + nomVendeur
					+ ", mais il faut être un habitant de notre village pour commercer ici.");

		} else if (quantiteAchetee == -1) {
			System.out.println(nomAcheteur + " veut acheter " + quantiteVoulu + " " + produit + ", mais " + nomVendeur
					+ " n'en a plus !");
		} else if (quantiteAchetee < quantiteVoulu) {
			System.out.println(nomAcheteur + " voulait acheter " + quantiteVoulu + " " + produit + ", mais "
					+ nomVendeur + " n'en avait que " + quantiteAchetee + ". Achete tout le stocke de" + nomVendeur);
		} else {
			System.out.println(nomAcheteur + " achète " + quantiteVoulu + " " + produit + " à " + nomVendeur + ".");
		}

	}
}
