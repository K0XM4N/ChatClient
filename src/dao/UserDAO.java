package dao;

import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import lombok.Cleanup;
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
    private static final String READ_USERNAME = "SELECT username FROM user WHERE username = ?;";

    private UserBean userBean;


    public UserDAO(TextField loginInput,TextField usernameInput, PasswordField pass1Input, PasswordField pass2Input){
        this.loginInput = loginInput;
        this.usernameInput = usernameInput;
        this.pass1Input = pass1Input;
        this.pass2Input = pass2Input;

        userBean = new UserBean(loginInput.getText(),usernameInput.getText(),pass1Input.getText(),pass2Input.getText());
    }

    public UserDAO(TextField loginInput,TextField usernameInput, PasswordField pass1Input){
        this.loginInput = loginInput;
        this.usernameInput = usernameInput;
        this.pass1Input = pass1Input;

        userBean = new UserBean(loginInput.getText(),usernameInput.getText(),pass1Input.getText());
    }


    public void createUserInDB(){

        if (LoginFieldsValidatorService.isFieldVerified(userBean.getLogin(),userBean.getUsername(),userBean.getPassword1(),userBean.getPassword2())){

            try {
                @Cleanup
                Connection connection = ConnectionProvider.getConnection();
                @Cleanup
                PreparedStatement sqlStatement = connection.prepareStatement(CREATE);

                sqlStatement.setString(1, userBean.getLogin());
                sqlStatement.setString(2, userBean.getUsername());
                sqlStatement.setString(3, userBean.getPassword1());

                if (isLoginAlreadyInDB(connection) && isUsernameAlreadyInDB(connection)) {

                    int rowsAffected = sqlStatement.executeUpdate();
                    System.out.println("Rows affected: " + rowsAffected);
                    AlertService.showAlert(Alert.AlertType.INFORMATION, "Registraion", "Your account was succesfuly created.");

                }
            }
             catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Problem with SQL STATEMENTS");
            } catch (PropertyVetoException e) {
                e.printStackTrace();
            }

        }

    }

    public void selectUserLoginFromDB(){

        if (LoginFieldsValidatorService.isFieldVerified(userBean.getLogin(),userBean.getUsername(),userBean.getPassword1())){

            try {

                @Cleanup
                Connection connection = ConnectionProvider.getConnection();
                @Cleanup
                PreparedStatement selectLogin = connection.prepareStatement(READ_LOGIN);


            } catch (SQLException e) {
                e.printStackTrace();
            } catch (PropertyVetoException e) {
                e.printStackTrace();
            }

        }

    }






    public boolean isLoginAlreadyInDB(Connection connection) throws SQLException {

        return veryfication(connection, READ_LOGIN, userBean.getLogin(), Alert.AlertType.INFORMATION,"Registration","Login is already in use. Please use another.");

    }

    private boolean isUsernameAlreadyInDB(Connection connection) throws SQLException {

        return veryfication(connection,READ_USERNAME,userBean.getUsername(), Alert.AlertType.INFORMATION,"Registration","Username is already in use. Please use another else.");

    }


    private boolean veryfication(Connection connection, String SQL_STATEMENT, String registartionField, Alert.AlertType alertType, String windowTitle, String alertMessge) throws SQLException {


        PreparedStatement selectLogin = connection.prepareStatement(SQL_STATEMENT);
        selectLogin.setString(1,registartionField);
        ResultSet loginResult = selectLogin.executeQuery();

        if (loginResult.next()){
            AlertService.showAlert(alertType, windowTitle, alertMessge);
            return false;
        }
        else{
            return true;
        }

    }



}
