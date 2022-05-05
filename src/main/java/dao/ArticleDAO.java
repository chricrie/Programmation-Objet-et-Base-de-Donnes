package dao;

import modele.Article;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ArticleDAO extends CommonDAO {

    private ArrayList<Article> registreArticle = new ArrayList<>();
    private Article article = null;
    PreparedStatement preparedStatement = null;

    public ArticleDAO(Connection connection) { super(connection); }

    @Override
    public void afficherResultat() {
        for (Article tmp : registreArticle) {
            System.out.println(tmp);
        }
    }

    @Override
    public Object create(Object object) {
        Article article = (Article) object;
        try {

            preparedStatement = connection.prepareStatement(ISQLConstante.INSERT_INTO_ARTICLE);
            preparedStatement.setLong(1, article.getNoArticle());
            preparedStatement.setString(2, article.getDescription());
            preparedStatement.setDouble(3, article.getPrixUnitaire());
            preparedStatement.setLong(4, article.getQuantiteEnStock());

            preparedStatement.executeUpdate();
            System.out.println("\nArticle " + article.getNoArticle() + " créer avec succès..");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public ArrayList findIntervale(double val1, double val2) {
        try {
            preparedStatement = connection.prepareStatement(ISQLConstante.SELECT_ARTICLE_PRICE_RANGE);
            preparedStatement.setDouble(1, val1);
            preparedStatement.setDouble(2, val2);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                registreArticle.add(new Article(resultSet.getInt("noArticle"),
                        resultSet.getString("description"),
                        resultSet.getDouble("prixUnitaire")));
            }

            afficherResultat();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return registreArticle;
    }

    @Override
    public ArrayList findOverAverage() {
        try {
            registreArticle.clear();
            preparedStatement = connection.prepareStatement(ISQLConstante.SELECT_ARTICLES_PRIX_SUP_MOYENNE);
            ResultSet resultatRequette = preparedStatement.executeQuery();

            while (resultatRequette.next()) {
                registreArticle.add(new Article(resultatRequette.getInt("noArticle"),
                        resultatRequette.getString("description"),
                        resultatRequette.getDouble("prixUnitaire")));
            }

            afficherResultat();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return registreArticle;
    }

    @Override
    public ArrayList<Article> findArticleStartWith(char caractere) {
        try {
            registreArticle.clear();

            PreparedStatement preparedStatement =
                    connection.prepareStatement(ISQLConstante.SELECT_ARTICLE_SELON_PREMIERE_LETTRE);
            preparedStatement.setString(1, caractere + "%");
            ResultSet resultatRequete = preparedStatement.executeQuery();

            while (resultatRequete.next()) {
                registreArticle.add(new Article(resultatRequete.getInt("noArticle"), resultatRequete.getString("description"),
                        resultatRequete.getDouble("prixUnitaire")));
            }

            afficherResultat();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return registreArticle;
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
    public ArrayList showAllCommandeWithLivraison() { return null; }

    @Override
    public ArrayList showCommandesClientByNoCommandeOverX(int noclient, int nocommande) {
        return null;
    }
}
