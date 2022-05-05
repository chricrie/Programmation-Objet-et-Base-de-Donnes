package dao;

import modele.Client;

import java.sql.*;
import java.util.ArrayList;

public class ClientDAO extends CommonDAO{

    private ArrayList<Client> registreClient = new ArrayList<>();
    private Client client = null;
    PreparedStatement preparedStatement = null;

    public ClientDAO(Connection connection) { super(connection); }

    @Override
    public void afficherResultat() {
        for(Client tmp : registreClient) {
            System.out.println(tmp);
        }
    }

    @Override
    public Object create(Object object) {
        Client client = (Client) object;
        try {
            preparedStatement = connection.prepareStatement(ISQLConstante.INSERT_INTO_CLIENT);
            preparedStatement.setLong(1, client.getNoClient());
            preparedStatement.setString(2, client.getNomClient());
            preparedStatement.setString(3, client.getNoTelephone());

            preparedStatement.executeUpdate();
            System.out.println("\nClient " + client.getNomClient() + " créer avec succès..");

        } catch (SQLIntegrityConstraintViolationException d) {
            System.out.println("Doublon trouvé. Le client " + client.getNoClient() + " existe déja..");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Object findById(int noClient) {

        try {
            preparedStatement = connection.prepareStatement(ISQLConstante.SELECT_CLIENT_NOCLIENT);
            preparedStatement.setLong(1, noClient);
            ResultSet resultatRequette = preparedStatement.executeQuery();

            while(resultatRequette.next()) {
                client = new Client(resultatRequette.getInt("noClient"),
                        resultatRequette.getString("nomClient"),
                        resultatRequette.getString("noTelephone"));
            }
            System.out.println(client);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return client;
    }

    @Override
    public Object findByName(String name) {
        return null;
    }

    @Override
    public ArrayList findAll() {

        try {
            preparedStatement = connection.prepareStatement(ISQLConstante.SELECT_ALL_CLIENT);
            ResultSet resultatRequette = preparedStatement.executeQuery();

            while(resultatRequette.next()) {
                registreClient.add(new Client(resultatRequette.getInt("noClient"),
                        resultatRequette.getString("nomClient"),
                        resultatRequette.getString("noTelephone")));
            }
        afficherResultat();

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return registreClient;
    }

    //Le noClient, noTéléphone des Clients sans aucune commande
    public Client findClientsWithNoOrder() {

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement(ISQLConstante.SELECT_NOCLIENT_TELEPHONE_FROM_CLIENTS_WITH_NO_ORDER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int noClient = resultSet.getInt("noClient");
                String noTel = resultSet.getString("noTelephone");
                client = new Client(noClient, null, noTel);
                System.out.printf("noClient : %s, noTel : %s \n", noClient, noTel);
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return client;
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

    @Override
    public ArrayList findIntervale(double val1, double val2) {
        return null;
    }

    @Override
    public ArrayList findByDate(java.sql.Date date) {
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
}
