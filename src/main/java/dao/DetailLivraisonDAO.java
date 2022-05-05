package dao;

import modele.Article;
import modele.Commande;
import modele.DetailLivraison;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class DetailLivraisonDAO extends CommonDAO {

    private DetailLivraison detailLivraison = null;
    private ArrayList<DetailLivraison> detailLivraisonArrayList = new ArrayList<>();
    PreparedStatement preparedStatement = null;

    public DetailLivraisonDAO(Connection connection) {
        super(connection);
    }

    @Override
    public void afficherResultat() {
        for(DetailLivraison tmp : detailLivraisonArrayList) {
            System.out.println(tmp);
        }
    }

    @Override
    public Object create(Object object) {

        DetailLivraison detailLivraison = (DetailLivraison) object;

        try {
            preparedStatement = connection.prepareStatement(ISQLConstante.INSERT_INTO_DETAIL_LIVRAISON);
            preparedStatement.setInt(1, detailLivraison.getNoLivraison());
            preparedStatement.setInt(2, detailLivraison.getNoCommande());
            preparedStatement.setInt(3, detailLivraison.getNoArticle());
            preparedStatement.setInt(4, detailLivraison.getQuantiteLivree());

            preparedStatement.executeUpdate();
            System.out.println("\nDetail de livraison créer avec succès..");

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
