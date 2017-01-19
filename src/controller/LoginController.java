package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import model.SceneSwitcherModel;
import service.LoginChooserService;
import service.LoginType;

import java.io.IOException;


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

    public void handleLoginButton(ActionEvent event) {
        loginChooserService = new LoginChooserService(loginTextField, passPasswordField,checkBoxGuest);
        loginType = loginChooserService.chooseLoginType();
        loginType.logIn();

    }

    public void handleRegisterButton(ActionEvent event) throws IOException {
        VBox changedContainer = sceneSwitcher.loadScreen("../view/registerWindow.fxml");
        sceneSwitcher.show(mainContainer,changedContainer);
    }


}
