package modele;

import java.util.Date;

public class Livraison {

    private int noLivraison;
    private Date dateLivraison;

    public Livraison() {
    }

    public Livraison(int noLivraison, Date dateLivraison) {
        this.noLivraison = noLivraison;
        this.dateLivraison = dateLivraison;
    }

    public int getNoLivraison() {
        return noLivraison;
    }

    public void setNoLivraison(int noLivraison) {
        this.noLivraison = noLivraison;
    }

    public Date getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(Date dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    @Override
    public String toString() {
        return "Livraison{" +
                "noLivraison=" + noLivraison +
                ", dateLivraison=" + dateLivraison +
                '}';
    }
}
