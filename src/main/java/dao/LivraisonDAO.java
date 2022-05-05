package dao;

import modele.Client;
import modele.Commande;
import modele.LigneCommande;
import modele.Livraison;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class LivraisonDAO extends CommonDAO{

    private ArrayList<Livraison> registreLivraison = new ArrayList<>();
    private Livraison livraison = null;
    PreparedStatement preparedStatement = null;

    public LivraisonDAO(Connection connection) { super(connection); }

    @Override
    public void afficherResultat() {
        for(Livraison tmp : registreLivraison) {
            System.out.println(tmp);
        }
    }

    @Override
    public Object create(Object object) {
        Livraison livraison = (Livraison) object;
        try {

            preparedStatement = connection.prepareStatement(ISQLConstante.INSERT_INTO_LIVRAISON);
            preparedStatement.setLong(1, livraison.getNoLivraison());
            preparedStatement.setString(2, livraison.getDateLivraison().toString());

            preparedStatement.executeUpdate();
            System.out.println("\nLivraison " + livraison.getNoLivraison() + " créer avec succès..");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean delete(Object object) {
        return false;
    }

    @Override
    public boolean update(Object object) {
        return false;
    }

    @Override
    public Object findById(int id) {
        return null;
    }

    @Override
    public Object findByName(String name) {
        return null;
    }

    @Override
    public ArrayList findAll() {
        return null;
    }

    @Override
    public ArrayList findIntervale(double val1, double val2) {
        return null;
    }

    @Override
    public ArrayList findByDate(Date date) {
        return null;
    }

    @Override
    public ArrayList findOverAverage() {
        return null;
    }

    @Override
    public ArrayList findArticleStartWith(char c) {
        return null;
    }

    @Override
    public ArrayList showAllCommandeWithLivraison() {
        return null;
    }

    @Override
    public ArrayList showCommandesClientByNoCommandeOverX(int noclient, int nocommande) {
        return null;
    }
}
