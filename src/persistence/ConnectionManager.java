package persistence;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {


        Connection connection = null;


        public Connection getConnection() {

            String dbUrl = "jdbc:mysql://localhost:3306/ac";
            String user = "root";
            String pass = "";

            try {
                if (connection == null) {
                    connection = DriverManager.getConnection(dbUrl, user, pass);
                }
            } catch (SQLException ex) {
                System.out.println("Failure to connect to database : " + ex.getMessage());
            }
            return connection;
        }

        public void close() {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println("Failure to close database connections: " + ex.getMessage());
            }
        }
}


