package dao;

import connection.DBconnection;
import entityLayer.CastMember;
import entityLayer.User;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DMITRIUS on 18.01.2017.
 */
public class CastMemberDao extends GenericDao<CastMember> {

    private static final String NAME_TABLE = "castmembers";
    private static final String ADD_IN_CASTMEMBERS = "INSERT INTO castmembers (fname, lname, date_of_birth) VALUES (?, ?, ?)";
    private static final String ADD_IN_MOVIES_MEMBERS = "INSERT INTO movies_members (movie_id, cm_id, member_type) VALUES (?, ?, ?)";
    private static final String GET_ALL_CASTMEMBERS = "SELECT * FROM castmembers";
    private static final String GET_ALL_CASTMEMBERS_WITH_MOVIES = "SELECT c.fname, c.lname, c.date_of_birth, m.name FROM castmembers AS c \n" +
            "INNER JOIN movies_members AS mm ON c.cm_id = mm.cm_id JOIN movies AS m ON mm.movie_id = m.movie_id";
    private static final String GET_CASTMEMBERS_BY_MOVIE = "SELECT c.cm_id, c.fname, c.lname, c.date_of_birth, mm.member_type FROM castmembers AS c \n" +
            "INNER JOIN movies_members AS mm ON c.cm_id = mm.cm_id JOIN movies AS m ON mm.movie_id = m.movie_id \n" +
            "WHERE m.name = ?";
    private static final String GET_CASTMEMBERS_BY_NAME = "SELECT fname, lname, date_of_birth FROM castmembers WHERE " +
            "fname = ? OR lname = ?";
    private static final String GET_CASTMEMBERS_BY_TYPE = "SELECT c.fname, c.lname, c.date_of_birth, mm.member_type FROM castmembers AS c \n" +
            "INNER JOIN movies_members AS mm ON c.cm_id = mm.cm_id WHERE mm.member_type = ? GROUP BY c.fname, c.lname";

    @Override
    public void initDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public CastMember getById(long id) {
        CastMember result = null;
        ResultSet resultSet = getResultById(NAME_TABLE, id);
        try {
            if (resultSet != null && resultSet.next()) {
                result = new CastMember(resultSet.getLong("cm_id"), resultSet.getString("fname"),
                        resultSet.getString("lname"), resultSet.getString("mname") != null ?
                resultSet.getString("mname") : null, resultSet.getObject("date_of_birth") != null ?
                resultSet.getObject("date_of_birth", LocalDate.class) : null);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void addInTableCastMember(String fname, String lname, LocalDate date_of_birth) throws SQLException {
        Connection dbConnection = DBconnection.getConnection();
        PreparedStatement pStatement = dbConnection.prepareStatement(ADD_IN_CASTMEMBERS);
        pStatement.setString(1, fname);
        pStatement.setString(2, lname);
        pStatement.setObject(3, date_of_birth);
        pStatement.executeUpdate();
        pStatement.close();
        dbConnection.close();
    }

    public CastMember addInTableCastMembers(CastMember castMember) {
        try {
            Connection dbConnection = DBconnection.getConnection();
            if(dbConnection != null) {
                PreparedStatement pStatement = dbConnection.prepareStatement(ADD_IN_CASTMEMBERS, Statement.RETURN_GENERATED_KEYS);
                pStatement.setString(1, castMember.getFirstName());
                pStatement.setString(2, castMember.getLastName());
                pStatement.setObject(3, castMember.getDateOfBirth());
                pStatement.executeUpdate();
                ResultSet result = pStatement.getGeneratedKeys();
                while (result.next()) {
                    castMember.setId(result.getLong("cm_id"));
                }
                pStatement.close();
                dbConnection.close();
                return castMember;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addInTableMoviesMembers(int movie_id, int cm_id, String member_type) throws SQLException {
        Connection dbConnection = DBconnection.getConnection();
        PreparedStatement pStatement = dbConnection.prepareStatement(ADD_IN_MOVIES_MEMBERS);
        pStatement.setInt(1, movie_id);
        pStatement.setInt(2, cm_id);
        pStatement.setString(2, member_type);
        pStatement.executeUpdate();
        pStatement.close();
        dbConnection.close();
    }

    public List<CastMember> getAllCastMembers() {
        List<CastMember> castMemberList = null;
        try {
            Connection dbConnection = DBconnection.getConnection();
            if(dbConnection != null) {
                Statement statement = dbConnection.createStatement();
                ResultSet result = statement.executeQuery(GET_ALL_CASTMEMBERS);
                castMemberList = new ArrayList<>();
                while (result.next()) {
                    castMemberList.add(new CastMember(result.getLong("cm_id"), result.getString("fname"),
                            result.getString("lname"), result.getObject("date_of_birth", LocalDate.class)));
                }
                statement.close();
                result.close();
                dbConnection.close();
                return castMemberList;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<CastMember> getCatMembersByMovie(String name) {
        List<CastMember> castMemberList = null;
        try {
            Connection dbConnection = DBconnection.getConnection();
            if(dbConnection != null) {
                PreparedStatement pStatement = dbConnection.prepareStatement(GET_CASTMEMBERS_BY_MOVIE);
                pStatement.setString(1, name);
                ResultSet result = pStatement.executeQuery();
                while (result.next()) {
                    castMemberList.add(new CastMember(result.getLong("c.cm_id"), result.getString("fname"),
                            result.getString("lname"), result.getObject("date_of_birth", LocalDate.class)));
                }
                pStatement.close();
                result.close();
                dbConnection.close();
                return castMemberList;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public CastMember getCastmemberByName(String name) {
        CastMember castMember = null;
        try {
            Connection dbConnection = DBconnection.getConnection();
            PreparedStatement pStatement = dbConnection.prepareStatement(GET_CASTMEMBERS_BY_NAME);
            pStatement.setString(1, name);
            pStatement.setString(2, name);
            ResultSet result = pStatement.executeQuery();
            while (result.next()) {
                castMember = new CastMember(result.getLong("cm_id"), result.getString("fname"),
                        result.getString("lname"), result.getObject("date_of_birth", LocalDate.class));
            }
            pStatement.close();
            result.close();
            dbConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return castMember;
    }

    public List<CastMember> getCastmemberByType(String profession) {
        List<CastMember> castMemberList = null;
        try {
            Connection dbConnection = DBconnection.getConnection();
            PreparedStatement pStatement = dbConnection.prepareStatement(GET_CASTMEMBERS_BY_TYPE);
            pStatement.setString(1, profession);
            ResultSet result = pStatement.executeQuery();
            while (result.next()) {
                castMemberList.add (new CastMember(result.getString("fname"),
                        result.getString("lname"), result.getObject("date_of_birth", LocalDate.class),
                        result.getString("member_type")));
            }
            pStatement.close();
            result.close();
            dbConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return castMemberList;
    }
}
