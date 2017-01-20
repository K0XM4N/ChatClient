package dao;

import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import lombok.AllArgsConstructor;
import service.AlertService;
import service.LoginFieldsValidatorService;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Krzysztof on 2017-01-19.
 */

public class UserDAO {

    private TextField loginInput, usernameInput;
    private PasswordField pass1Input, pass2Input;

    private static final String CREATE = "INSERT INTO user( login, username, password) VALUES(?, ?, ?, ?);";
    private static final String READ = "SELECT password FROM user WHERE login = ?;";

    private String login;
    private String username;
    private String pass1;
    private String pass2;


    public UserDAO(TextField loginInput,TextField usernameInput, PasswordField pass1Input, PasswordField pass2Input){
        this.loginInput = loginInput;
        this.usernameInput = usernameInput;
        this.pass1Input = pass1Input;
        this.pass2Input = pass2Input;

        String login = loginInput.getText();
        String username = usernameInput.getText();
        String pass1 = pass1Input.getText();
        String pass2 = pass2Input.getText();
    }

    public UserDAO(TextField loginInput,TextField usernameInput, PasswordField pass1Input){
        this.loginInput = loginInput;
        this.usernameInput = usernameInput;
        this.pass1Input = pass1Input;
        this.pass2Input = pass2Input;

        String login = loginInput.getText();
        String username = usernameInput.getText();
        String pass1 = pass1Input.getText();
    }

    public void createUser(){

        if (LoginFieldsValidatorService.isFieldVerified(login,username,pass1,pass2)){

            Connection connection = null;
            PreparedStatement sqlStatement = null;
            ResultSet sqlResult = null;

            try{

                connection = ConnectionProvider.getConnection();
                sqlStatement = connection.prepareStatement(CREATE);
                sqlStatement.setString(1, login);

                // read from database, check login -> if there is no login, create user.

            } catch (SQLException ex){
                AlertService.showAlert(Alert.AlertType.WARNING, "Database error", "Cannot connect do database");
            } catch (PropertyVetoException e) {
                e.printStackTrace();
            }

        }

    }

    public void selectUserLoginFromDB(){

        if (LoginFieldsValidatorService.isFieldVerified(login,username,pass1)){

        }

    }

    public void selectUserRegisterFromDB(){

    }

}
