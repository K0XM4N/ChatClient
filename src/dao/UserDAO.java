package dao;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import lombok.AllArgsConstructor;
import service.LoginFieldsValidatorService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by Krzysztof on 2017-01-19.
 */
@AllArgsConstructor
public class UserDAO {

    private TextField loginInput, usernameInput;
    private PasswordField pass1Input, pass2Input;

    private static final String CREATE = "INSERT INTO user( login, username, password) VALUES(?, ?, ?, ?);";
    private static final String READ = "SELECT password FROM user WHERE login = ?;";


    public void createUser(){

        String login = loginInput.getText();
        String username = usernameInput.getText();
        String pass1 = pass1Input.getText();
        String pass2 = pass2Input.getText();

        if (LoginFieldsValidatorService.isFieldVerified(login,username,pass1,pass2)){

            Connection connection = null;
            PreparedStatement sqlStatement = null;
            ResultSet sqlResult = null;

            try{

                connection = ConnectionProvider.getConnection();
                sqlStatement = connection.prepareStatement(CREATE);
                sqlStatement.setString(1, "");

            } catch (Exception ex){

            }

        }

    }

}
