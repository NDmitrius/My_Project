package entityLayer;

import connection.DBconnection;
import dao.MovieDao;

import java.sql.*;
import java.time.LocalDate;

/**
 * Created by DMITRIUS on 19.01.2017.
 */
public class TestConnection {
    private static Connection myConnection;
    private static Statement statement;
    private static ResultSet resultSet;

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        String query1 = "select count(*) from movies";
        String query2 = "SELECT name, year, country FROM movies";


        try {
            myConnection = DBconnection.getConnection();
            statement = myConnection.createStatement();
            resultSet = statement.executeQuery(query1);
            while (resultSet.next()) {
                int count = resultSet.getInt(1);
                System.out.println("Total number of movies in the table: " + count);
            }
            myConnection.close();
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            String query3 = "SELECT * FROM movies;";
            myConnection = DBconnection.getConnection();
            statement = myConnection.createStatement();
            resultSet = statement.executeQuery(query3);
            while (resultSet.next()) {
                int id = resultSet.getInt("movie_id");
                String name = resultSet.getString("name");
                LocalDate year = resultSet.getObject("year", LocalDate.class);
                String country = resultSet.getString("country");
                System.out.println(id + " " + name + " " + year + " " + country);
            }
            myConnection.close();
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {

            MovieDao movieDao = new MovieDao();
            Movie movie = movieDao.getById(1L);
            System.out.println(movie.getId() + " " + movie.getName());
            myConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
