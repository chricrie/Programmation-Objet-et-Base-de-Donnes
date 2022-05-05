package dao;

import modele.DetailLivraison;
import modele.LigneCommande;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class LigneCommandeDAO extends CommonDAO {

    private ArrayList<LigneCommande> registreLignes = new ArrayList<>();
    private LigneCommande ligneCommande = null;
    PreparedStatement preparedStatement = null;

    public LigneCommandeDAO(Connection connection) {
        super(connection);
    }

    @Override
    public void afficherResultat() {
        for(LigneCommande tmp : registreLignes) {
            System.out.println(tmp);
        }
    }

    @Override
    public Object create(Object object) {
        LigneCommande ligneCommande = (LigneCommande) object;
        try {
            preparedStatement = connection.prepareStatement(ISQLConstante.INSERT_INTO_LIGNECOMMANDE);
            preparedStatement.setLong(1, ligneCommande.getNoCommande());
            preparedStatement.setLong(2, ligneCommande.getNoArticle());
            preparedStatement.setLong(3, ligneCommande.getQuantite());

            preparedStatement.executeUpdate();
            System.out.println("\nLigne de commande créer avec succès..");

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
