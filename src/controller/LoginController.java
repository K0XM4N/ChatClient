package controller;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import dao.ConnectionProvider;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import model.SceneSwitcherModel;
import service.LoginChooserService;
import service.LoginType;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Connection;
import java.sql.SQLException;


public class LoginController {


    @FXML
    private VBox mainContainer;
    @FXML
    private TextField loginTextField;
    @FXML
    private PasswordField passPasswordField;
    @FXML
    private CheckBox checkBoxGuest;

    private SceneSwitcherModel sceneSwitcher;
    private LoginChooserService loginChooserService;
    private LoginType loginType;

    public void initialize(){
        sceneSwitcher = new SceneSwitcherModel();
    }

    public void handleLoginButton(ActionEvent event) throws IOException {

        loginChooserService = new LoginChooserService(loginTextField, passPasswordField,checkBoxGuest);
        loginType = loginChooserService.chooseLoginType();
        loginType.logIn();

    }

    public void handleRegisterButton(ActionEvent event) throws IOException {
        VBox changedContainer = sceneSwitcher.loadScreen("../view/registerWindow.fxml");
        sceneSwitcher.show(mainContainer,changedContainer);
    }


}
