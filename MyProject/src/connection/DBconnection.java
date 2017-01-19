package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by DMITRIUS on 17.01.2017.
 */
public class DBconnection {

    private static final String DBURL = "jdbc:mysql://localhost:3306/movies_db";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private DBconnection() {
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(DBURL, USER, PASSWORD);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
