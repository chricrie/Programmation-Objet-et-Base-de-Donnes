package accespersistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSQL {

    private String url = "jdbc:mysql://localhost:3306/vente";
    private String username = "chricri";
    private String password = "a5edfjwo";

    private static Connection connection;

    private ConnectionSQL() {
        try{
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("\n\t\t --- Connection DB Réussi. Début des opérations.. --- ");
    }

    public static Connection getInstance() {
        if(connection == null){
            new ConnectionSQL();
        }
        return connection;
    }

    public static void closeInstance(Connection connection) {
        if(connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
