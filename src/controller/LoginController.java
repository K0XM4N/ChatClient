package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import lombok.Getter;
import model.SceneSwitcherModel;
import service.login.logic.LoginChooserService;
import service.login.logic.LoginType;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;


public class LoginController {

    @Getter
    @FXML
    private VBox mainContainer;
    @FXML
    private TextField loginTextField;
    @FXML
    private PasswordField passPasswordField;
    @FXML
    private CheckBox checkBoxGuest;
    private ChatController chatController;

    private SceneSwitcherModel sceneSwitcher;
    private LoginChooserService loginChooserService;
    private LoginType loginType;

    public void initialize() throws IOException {
        sceneSwitcher = new SceneSwitcherModel();
    }

    public void handleLoginButton(ActionEvent event) throws IOException, PropertyVetoException, SQLException {

        loginChooserService = new LoginChooserService(loginTextField, passPasswordField,checkBoxGuest,mainContainer);
        loginType = loginChooserService.chooseLoginType();
        loginType.logIn();

    }

    public void handleRegisterButton(ActionEvent event) throws IOException {
        VBox changedContainer = sceneSwitcher.loadScreen("../view/registerWindow.fxml");
        sceneSwitcher.show(mainContainer,changedContainer);
    }


}
