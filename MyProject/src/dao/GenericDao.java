package dao;

import connection.DBconnection;
import entityLayer.Entity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Formatter;

/**
 * Created by DMITRIUS on 17.01.2017.
 */
public abstract class GenericDao <T extends Entity> {

    private static final String GENERIC_GET_BY_ID_QUERY = "SELECT * FROM %s";

    public abstract T getById(long id);

    public abstract void initDB();

    protected ResultSet getResultById(String tableName, long id) {
        Connection connection = DBconnection.getConnection();
        try {
            Formatter formatter = new Formatter();
            Statement statement = connection.createStatement();
            return statement.executeQuery(formatter.format(GENERIC_GET_BY_ID_QUERY, tableName, id).toString());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
