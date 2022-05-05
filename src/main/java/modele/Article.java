package modele;

public class Article {
   private int noArticle;
   private String description;
   private Double prixUnitaire;
   private int quantiteEnStock;

    public Article() {
    }

    public Article(int noArticle, String description, Double prixUnitaire, int quantiteEnStock) {
        this.noArticle = noArticle;
        this.description = description;
        this.prixUnitaire = prixUnitaire;
        this.quantiteEnStock = quantiteEnStock;
    }

    public Article(int noArticle, String description, Double prixUnitaire) {
        this.noArticle = noArticle;
        this.description = description;
        this.prixUnitaire = prixUnitaire;
    }

    public int getNoArticle() {
        return noArticle;
    }

    public void setNoArticle(int noArticle) {
        this.noArticle = noArticle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(Double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public int getQuantiteEnStock() {
        return quantiteEnStock;
    }

    public void setQuantiteEnStock(int quantiteEnStock) {
        this.quantiteEnStock = quantiteEnStock;
    }

    @Override
    public String toString() {
        return "noArticle: " + noArticle +
                " | description: " + description +
                "\t | prixUnitaire: " + prixUnitaire +
                "$ | quantiteEnStock: " + quantiteEnStock;
    }
}
