package fr.pgah.java.unbrco.model.livre;

import fr.pgah.java.unbrco.model.bibliotheque.Bibliotheque;

public class Livre {

  private String titre;
  private String auteur;
  private GenreLivre genre;
  private int annee;
  private int edition;
  private Bibliotheque bibliothequeMere;
  private boolean estSorti;

  public Livre(String titre, String auteur, GenreLivre genre, int annee, int edition, Bibliotheque bibliothequeMere,
      boolean estSorti) {
    this.titre = titre;
    this.auteur = auteur;
    this.genre = genre;
    this.annee = annee;
    this.edition = edition;
    this.bibliothequeMere = bibliothequeMere;
    this.estSorti = estSorti;
  }

  public String getTitre() {
    return titre;
  }

  public String getAuteur() {
    return auteur;
  }

  public GenreLivre getGenre() {
    return genre;
  }

  public int getAnnee() {
    return annee;
  }

  public int getEdition() {
    return edition;
  }
  
  public boolean getEstSorti() {
    return estSorti;
  }

  public Bibliotheque getBibliothequeMere() {
    return bibliothequeMere;
  }

  public void setBibliothequeMere(Bibliotheque bibliothequeMere) {
    this.bibliothequeMere = bibliothequeMere;
  }

  // MODIFIE : this
  // EFFETS : enregistre le fait que le livre est revenu
  public void enregistrerRetour() {
    this.estSorti = false;
  }

  // RENVOIE : vrai si le livre est sorti
  public boolean estSorti() {
    if (estSorti) {
      return true;
    }
    return false;
  }

  // MODIFIE : this
  // EFFETS : enregistre le fait que le livre est sorti
  public void enregistrerSortie() {
    this.estSorti = true;
  }
}
