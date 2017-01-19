package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by Krzysztof on 2017-01-19.
 */
public class UserDAO {

    private static final String CREATE = "INSERT INTO user( login, username, password) VALUES(?, ?, ?, ?);";
    private static final String READ = "SELECT password FROM user WHERE login = ?;";

    public void createUser(){

        Connection connection = null;
        PreparedStatement sqlStatement = null;
        ResultSet sqlResult = null;

        try{

            connection = ConnectionProvider.getConnection();
            sqlStatement = connection.prepareStatement(CREATE);
            sqlStatement.setString(1, "l");

        } catch (Exception ex){

        }

    }

}
