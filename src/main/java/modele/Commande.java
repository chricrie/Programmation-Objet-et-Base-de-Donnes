package modele;

import java.util.Date;

public class Commande {

    private int noCommande;
    private Date dateCommande;
    private int noClient;

    private Client client;

    public Commande(int noCommande, Date dateCommande, int noClient) {
        this.noCommande = noCommande;
        this.dateCommande = dateCommande;
        this.noClient = noClient;
    }

    public Commande() {
    }

    public Client getClient() { return client; }

    public void setClient(Client client) { this.client = client; }

    public int getNoCommande() {
        return noCommande;
    }

    public void setNoCommande(int noCommande) {
        this.noCommande = noCommande;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public int getNoClient() {
        return noClient;
    }

    public void setNoClient(int noClient) {
        this.noClient = noClient;
    }

    @Override
    public String toString() {
        return "noCommande: " + noCommande +
                " | dateCommande: " + dateCommande +
                " | noClient: " + noClient +
                " | noTelephone: " + client.getNoTelephone();
    }
}
