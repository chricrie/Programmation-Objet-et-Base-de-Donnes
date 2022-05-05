package modele;

public class LigneCommande {
    private int noCommande;

    private int noArticle;
    private int quantite;

    public LigneCommande() {
    }

    public LigneCommande(int noCommande, int noArticle, int quantite) {
        this.noCommande = noCommande;
        this.noArticle = noArticle;
        this.quantite = quantite;
    }

    public int getNoArticle() {
        return noArticle;
    }

    public void setNoArticle(int noArticle) {
        this.noArticle = noArticle;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getNoCommande() {
        return noCommande;
    }

    public void setNoCommande(int noCommande) {
        this.noCommande = noCommande;
    }

    @Override
    public String toString() {
        return "LigneCommande{" +
                "noCommande=" + noCommande +
                ", noArticle=" + noArticle +
                ", quantite=" + quantite +
                '}';
    }
}
