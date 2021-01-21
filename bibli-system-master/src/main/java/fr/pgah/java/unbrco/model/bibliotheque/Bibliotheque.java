package fr.pgah.java.unbrco.model.bibliotheque;

import java.util.ArrayList;
import java.util.List;

import fr.pgah.java.unbrco.model.livre.GenreLivre;
import fr.pgah.java.unbrco.model.livre.Livre;

public class Bibliotheque {

  private Bibliothecaire gerant;
  private String nom;
  private List<Bibliotheque> bibliothequesPartenaire = new ArrayList<>();
  private List<Livre> livresReference = new ArrayList<>();
  private List<Livre> livresRomans = new ArrayList<>();
  private List<Livre> livresBiographie = new ArrayList<>();
  private List<Livre> livresManuels = new ArrayList<>();
  private List<Livre> livreCuisine = new ArrayList<>();

  public Bibliotheque(String nom, Bibliothecaire gerant) {
    this.nom = nom;
    this.gerant = gerant;
  }

  public String getNom() {
    return nom;
  }

  public Bibliothecaire getGerant() {
    return gerant;
  }

  // PREREQUIS : livre != null
  // MODIFIE : this
  // EFFETS : stocke livre dans la collection appropriée de cet objet
  public void enregistrerLivre(Livre livre) {
    if (livre != null) {
      switch (livre.getGenre()) {
        case REFERENCE:
          livresReference.add(livre);
          break;
        case ROMAN:
          livresRomans.add(livre);
          break;
        case BIBLIOGRAPHIE:
          livresBiographie.add(livre);
          break;
        case MANUEL:
          livresManuels.add(livre);
          break;
        case CUISINE:
          livreCuisine.add(livre);
          break;
        default:
          System.out.println("Aucune catégorie trouvé");
          break;
      }
    }
  }

  // PREREQUIS : livre != null
  // RENVOIE : vrai si livre est dans le catalogue de cette bibliothèque
  // (qu'il soit actuellement emprunté ou non)
  public boolean estDansCatalogue(Livre livre) {
    if (livre != null) {

      if (livre.getGenre() == GenreLivre.REFERENCE) {
        for (Livre catalogigueLivreReference : livresReference) {
          if (catalogigueLivreReference.equals(livre.getTitre())) {
            return true;
          }
        }
      }

      if (livre.getGenre() == GenreLivre.ROMAN) {
        for (Livre catalogigueLivreRoman : livresRomans) {
          if (catalogigueLivreRoman.equals(livre.getTitre())) {
            return true;
          }
        }
      }

      if (livre.getGenre() == GenreLivre.MANUEL) {
        for (Livre catalogigueLivreManuel : livresManuels) {
          if (catalogigueLivreManuel.equals(livre.getTitre())) {
            return true;
          }
        }
      }

      if (livre.getGenre() == GenreLivre.BIBLIOGRAPHIE) {
        for (Livre catalogigueLivreBibliographie : livresBiographie) {
          if (catalogigueLivreBibliographie.equals(livre.getTitre())) {
            return true;
          }
        }
      }

      if (livre.getGenre() == GenreLivre.CUISINE) {
        for (Livre catalogigueLivreCuisine : livreCuisine) {
          if (catalogigueLivreCuisine.equals(livre.getTitre())) {
            return true;
          }
        }
      }

    }
    return false;
  }

  // PREREQUIS: livre != null
  // RENVOIE : vrai si livre est disponible à l'emprunt
  public boolean peutEtreEmprunte(Livre livre) {
    if (livre != null && livre.estSorti() == false) {
      return true;
    }
    return true;
  }

  // PREREQUIS : livre != null
  // RENVOIE : vrai si livre est dans le catalogue de cette bibliotheque
  // ou dans celui de l'un de ses branches
  public boolean estDansCatalogueEtendu(Livre livre) {
    if (livre != null) {
      if (estDansCatalogue(livre)) {
        return true;
      }
      for (Bibliotheque estDansbibliothequePartenaire : bibliothequesPartenaire) {
        if (estDansbibliothequePartenaire.equals(livre) || estDansCatalogue(livre)) {
          return true;
        }
      }
    }
    return false;
  }

  // PREREQUIS : livre != null
  // MODIFIE : this
  // EFFETS : enregistre le fait que livre est maintenant emprunté (si possible)
  // RENVOIE : vrai si l'opération est un succès
  public boolean enregistrerSortie(Livre livre) {
    if (livre != null) {

    }
    return false;
  }

  // PREREQUIS : livre != null
  // MODIFIE : this
  // EFFETS : enregistre le fait que livre est revenu (si possible)
  // RENVOIE : vrai si l'opération est un succès
  public boolean enregistrerRetour(Livre livre) {
    if (livre != null) {

    }
    return false;
  }

  // PREREQUIS : gerant != null
  // MODIFIE : this
  // EFFETS : set le nouveau gérant
  // RENVOIE : vrai si l'opération est un succès
  public boolean engagerGerant(Bibliothecaire bibliothecaire, Bibliothecaire gerant) {
    if (gerant != null) {
      this.gerant = gerant;
      return true;
    }
    return false;
  }

  // EFFETS : affiche le catalogue de cette bibliothèque
  // (toutes les informations de chaque livre)
  public void afficherCatalogue() {

    for (Livre catalogigueLivreCuisine : livreCuisine) {
      System.out.println(catalogigueLivreCuisine);
    }

    for (Livre catalogigueLivreBiographie : livresBiographie) {
      System.out.println(catalogigueLivreBiographie);
    }

    for (Livre catalogigueLivreManuels : livresManuels) {
      System.out.println(catalogigueLivreManuels);
    }

    for (Livre catalogigueLivreReference : livresReference) {
      System.out.println(catalogigueLivreReference);
    }

    for (Livre catalogigueLivreRoman : livresRomans) {
      System.out.println(catalogigueLivreRoman);
    }

  }
}
