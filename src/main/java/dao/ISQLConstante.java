package dao;

public interface ISQLConstante {
    String SELECT_CLIENT_NOCLIENT = "SELECT * FROM client WHERE noClient = ?;";

    String SELECT_ALL_CLIENT = "SELECT * FROM client;";

    String SELECT_ARTICLE_PRICE_RANGE = "SELECT noArticle, description, prixUnitaire \n" +
            "FROM article\n" +
            "WHERE prixUnitaire BETWEEN ? AND ?;";

    String SELECT_CLIENT_ORDER_BY_DATE = "SELECT d.noClient, c.noTelephone, noCommande, dateCommande\n" +
                                                            "FROM client c JOIN commande d\n" +
                                                            "ON c.noClient = d.noClient\n" +
                                                            "WHERE dateCommande = ?;";

    // #a.
    String INSERT_INTO_CLIENT = "INSERT INTO client VALUES (?, ?, ?);";
    String INSERT_INTO_ARTICLE = "INSERT INTO article VALUES (?, ?, ?, ?);";
    String INSERT_INTO_COMMANDE = "INSERT INTO commande VALUES (?, ?, ?);";
    String INSERT_INTO_LIVRAISON = "INSERT INTO livraison VALUES (?, ?);";
    String INSERT_INTO_LIGNECOMMANDE = "INSERT INTO lignecommande VALUES (?, ?, ?);";
    String INSERT_INTO_DETAIL_LIVRAISON = "INSERT INTO detailLivraison VALUES (?, ?, ?, ?);";

    //#1
    public static final String SELECT_CLIENT_CHOISI_DONT_NOCMMANDE_PGRAND_CHOISI = "SELECT noclient, " +
            "nocommande, datecommande FROM commande WHERE noclient = ? AND nocommande > ? ORDER BY nocommande;";

    //#3
    String SELECT_ARTICLE_SELON_PREMIERE_LETTRE = "SELECT * FROM article where upper(description) like" +
            " ?;";

    //#4
    String SELECT_ARTICLES_PRIX_SUP_MOYENNE = "SELECT * from article where prixunitaire > " +
            "(select avg(prixunitaire) from article);";

    //#5
    String SELECT_NOCOMMANDE_NOLIVRAISONS_INCLUS_NONLIVRER = "SELECT c.*, d.noLivraison FROM " +
            "commande c left join detaillivraison d on c.noCommande = d.noCommande;";

    //#6
    String SELECT_NOCLIENT_TELEPHONE_FROM_CLIENTS_WITH_NO_ORDER = "SELECT noClient, noTelephone\n" +
            "FROM client\n" +
            "WHERE NOT EXISTS\n" +
            "\t(SELECT *\n" +
            " FROM commande\n" +
            " WHERE noClient = client.noClient);";
}
