package dao;

import entityLayer.CastMember;
import entityLayer.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * Created by DMITRIUS on 18.01.2017.
 */
public class CastMemberDao extends GenericDao<CastMember> {

    private static final String NAME_TABLE = "castmembers";

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
        return result;
    }
}
