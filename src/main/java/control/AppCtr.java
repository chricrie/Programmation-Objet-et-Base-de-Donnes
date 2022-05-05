package control;

import accespersistance.ConnectionSQL;
import dao.*;
import modele.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class AppCtr {
    public static void main(String[] args) {

       /*  Projet remis par :
         Philippe Lafrance
         Jean-Claude Lahaie
         Yann Lebeau
         Christian Sayegh */


        Connection connection = ConnectionSQL.getInstance();
        CommonDAO<Client> clientCommonDAO = new ClientDAO(connection);

        //a. INSERTION - Enregistrement par tables

        //i. Insertion d'un enregistrement dans la table client.
        Client clientTmp = new Client(29, "Toto", "(514)777-8888");
        CommonDAO<Client> clientTest = new ClientDAO(connection);
        clientTest.create(clientTmp);

        //ii. Insertion d'un enregistrement dans la table article.
        Article articleTmp = new Article(95, "Un article test", 15.99, 1);
        CommonDAO<Article> articleTest = new ArticleDAO(connection);
        articleTest.create(articleTmp);

        //iii. Insertion d'un enregistrement dans la table commande.
        LocalDate javaDate = LocalDate.of(2000, 06, 04);
        java.sql.Date dateTmp = java.sql.Date.valueOf(javaDate);
        Commande commandeTmp = new Commande(31, dateTmp, 10);
        CommonDAO<Commande> commandeTest= new CommandeDAO(connection);
        commandeTest.create(commandeTmp);

        //iv. Insertion d'une enregistrement dans la table Livraison.
        javaDate = LocalDate.of(2020, 01, 05);
        dateTmp = java.sql.Date.valueOf(javaDate);
        Livraison livraison = new Livraison(21, dateTmp);
        CommonDAO<Livraison> livraisonTest = new LivraisonDAO(connection);
        livraisonTest.create(livraison);

        //v. Insertion d'un enregistrement dans la table LigneCommande.
        LigneCommande ligneCommande = new LigneCommande(4, 10, 3);

        CommonDAO<LigneCommande> commandeLigne = new LigneCommandeDAO(connection);
        commandeLigne.create(ligneCommande);

        //vi. Insertion d'un enregistrement dans la table DetailLivraison.
        DetailLivraison detailLivraison = new DetailLivraison(100,4,10,64);
        CommonDAO<DetailLivraison> detailLivraisonCommonDAO = new DetailLivraisonDAO(connection);
        detailLivraisonCommonDAO.create(detailLivraison);

        //b. SELECT divers avec affichage console

        // #1. SELECT de La liste des commande du client Y avec un numero de commande au dessus de X
        System.out.println("\n   #1. La Liste des commande du client Y avec un numero de commande au dessus de X..\n");
        CommonDAO<Commande> commandeCommonDAO = new CommandeDAO(connection);
        commandeCommonDAO.showCommandesClientByNoCommandeOverX(10,0);

        // #2. SELECT de La liste des commandes fait en date X.
        System.out.println("\n   #2. Selection de tout les commande en date du 2000-06-04 par client..\n");
        commandeCommonDAO = new CommandeDAO(connection);
        javaDate = LocalDate.of(2000, 06, 04);
        java.sql.Date dateSelect = java.sql.Date.valueOf(javaDate);
        commandeCommonDAO.findByDate(dateSelect);

        // #3. SELECT des articles dont la description débute par une lettre.
        System.out.println("\n   #3. Les Articles dont la description débute par la lettre « C »..\n");
        CommonDAO<Article> articleCommonDAO1 = new ArticleDAO(connection);
        articleCommonDAO1.findArticleStartWith('C');

        // #4. SELECT des articles dont le prix est supérieur à la moyenne
        System.out.println("\n   #4. SELECT des articles dont le prix est supérieur à la moyenne..\n");
        CommonDAO<Article> articleCommonDAO = new ArticleDAO(connection);
        articleCommonDAO.findOverAverage();

        // #5. SELECT des noCommande avec les noLivraisons associées, et ce, incluant aussi les noCommandes sans livraison.
        System.out.println("\n   #5. Select des noCommande avec les livraisons associées..\n");
        commandeCommonDAO = new CommandeDAO(connection);
        commandeCommonDAO.showAllCommandeWithLivraison();

        // #6. SELECT des clients sans aucune commandes.
        System.out.println("\n   #6. Clients qui n'ont rien commande.. \n");

        ClientDAO clientDAO = new ClientDAO(connection);
        clientDAO.findClientsWithNoOrder();

        System.out.println("\n\t\t --- Fin des opérations. Fermeture de la connection DB.. ---");
        ConnectionSQL.closeInstance(connection);
    }
}