package dao;

import modele.Article;
import modele.Client;
import modele.Commande;
import modele.DetailLivraison;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CommandeDAO extends CommonDAO{

    private ArrayList<Commande> registreCommande = new ArrayList<>();
    private Commande commande = null;
    PreparedStatement preparedStatement = null;

    Client client = new Client();

    public CommandeDAO(Connection connection) {
        super(connection);
    }

    @Override
    public void afficherResultat() {
        for(Commande tmp : registreCommande) {
            System.out.println(tmp);
        }
    }

    @Override
    public Object create(Object object) {
        Commande commande = (Commande) object;
        try {

            preparedStatement = connection.prepareStatement(ISQLConstante.INSERT_INTO_COMMANDE);
            preparedStatement.setLong(1, commande.getNoCommande());
            preparedStatement.setString(2, commande.getDateCommande().toString());
            preparedStatement.setLong(3, commande.getNoClient());

            preparedStatement.executeUpdate();
            System.out.println("\nCommande " + commande.getNoCommande() + " créer avec succès..");

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public ArrayList findByDate(java.sql.Date date) {
        try {
            preparedStatement = connection.prepareStatement(ISQLConstante.SELECT_CLIENT_ORDER_BY_DATE);
            preparedStatement.setDate(1, date);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                Client client = new Client();
                client.setNoTelephone(resultSet.getString("noTelephone"));

                Commande commande = new Commande(resultSet.getInt("noClient"),
                        resultSet.getDate("dateCommande"), resultSet.getInt("noCommande"));
                commande.setClient(client);

                registreCommande.add(commande);
            }
            afficherResultat();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList showAllCommandeWithLivraison() {
        try {
            registreCommande.clear();
            preparedStatement = connection.prepareStatement(ISQLConstante.SELECT_NOCOMMANDE_NOLIVRAISONS_INCLUS_NONLIVRER);
            ResultSet resultatRequette = preparedStatement.executeQuery();

            while(resultatRequette.next()) {

                Commande commande = new Commande(resultatRequette.getInt("noCommande"),resultatRequette.getDate("dateCommande"),resultatRequette.getInt("noClient"));

                DetailLivraison livraison = new DetailLivraison();
                livraison.setNoLivraison(resultatRequette.getInt("noLivraison"));

                //J'affiche ici parce que le toString est redéfini pour une autre requête (qui demande un no de telephone)
                System.out.print("No Commande: " + commande.getNoCommande() +"  |  ");
                System.out.println("No Livraison: " + livraison.getNoLivraison());

            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return registreCommande;
    }

    @Override
    public ArrayList showCommandesClientByNoCommandeOverX(int noclient, int nocommande) {
        try {
            registreCommande.clear();
            preparedStatement = connection.prepareStatement(ISQLConstante.SELECT_CLIENT_CHOISI_DONT_NOCMMANDE_PGRAND_CHOISI);
            preparedStatement.setInt(1,noclient);
            preparedStatement.setInt(2,nocommande);
            ResultSet resultatRequette = preparedStatement.executeQuery();

            while(resultatRequette.next()) {

                Commande commande = new Commande(resultatRequette.getInt("noCommande"),resultatRequette.getDate("dateCommande"),resultatRequette.getInt("noClient"));
                //J'affiche ici parce que le toString est redéfini pour une autre requête (qui demande un no de telephone)
                System.out.print("No Client: " + commande.getNoClient() + "  |  ");
                System.out.print("No Commande: " + commande.getNoCommande() +"  |  ");
                System.out.println("Date Commande : " + commande.getDateCommande());

            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return registreCommande;
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
    public boolean delete(Object object) {
        return false;
    }

    @Override
    public boolean update(Object oobject) {
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

}
