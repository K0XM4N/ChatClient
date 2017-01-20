package dao;

import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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

    private static final String CREATE = "INSERT INTO user( login, username, password) VALUES(?, ?, ?);";
    private static final String READ_PASSWORD = "SELECT password FROM user WHERE login = ?;";
    private static final String READ_LOGIN = "SELECT login FROM user WHERE login = ?;";

    private String login;
    private String username;
    private String pass1;
    private String pass2;


    public UserDAO(TextField loginInput,TextField usernameInput, PasswordField pass1Input, PasswordField pass2Input){
        this.loginInput = loginInput;
        this.usernameInput = usernameInput;
        this.pass1Input = pass1Input;
        this.pass2Input = pass2Input;

        this.login = loginInput.getText();
        this.username = usernameInput.getText();
        this.pass1 = pass1Input.getText();
        this.pass2 = pass2Input.getText();
    }

    public UserDAO(TextField loginInput,TextField usernameInput, PasswordField pass1Input){
        this.loginInput = loginInput;
        this.usernameInput = usernameInput;
        this.pass1Input = pass1Input;

        login = loginInput.getText();
        username = usernameInput.getText();
        pass1 = pass1Input.getText();
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
                sqlStatement.setString(2, username);
                sqlStatement.setString(3,pass1);

                int rowsAffected;

                // read from database, check login -> if there is no login, create user.
                if (isUserAlreadyRegistrated(connection)){
                    rowsAffected = sqlStatement.executeUpdate();
                    System.out.println("Rows affected: " + rowsAffected);
                    AlertService.showAlert(Alert.AlertType.INFORMATION,"Registraion","Your account was succesfuly created.");
                }
                else{
                    //send message: login is already in use!
                    AlertService.showAlert(Alert.AlertType.INFORMATION,"Registration","Login is already in use. Please use another.");
                }

            } catch (SQLException ex){
                AlertService.showAlert(Alert.AlertType.WARNING, "Database error", "Cannot connect do database");
                ex.printStackTrace();
            } catch (PropertyVetoException e) {
                e.printStackTrace();
            }

        }

    }

    public void selectUserLoginFromDB(){

        if (LoginFieldsValidatorService.isFieldVerified(login,username,pass1)){

        }

    }

    public boolean isUserAlreadyRegistrated(Connection connection) throws SQLException {

        PreparedStatement selectLogin = connection.prepareStatement(READ_LOGIN);
        selectLogin.setString(1,login);
        ResultSet loginResult = selectLogin.executeQuery();

        if (loginResult.next()){
            return false;
        }
        else{
            return true;
        }

    }

}
