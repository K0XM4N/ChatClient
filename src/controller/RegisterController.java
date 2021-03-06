package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import model.SceneSwitcherModel;

import java.io.IOException;

/**
 * Created by Krzysztof on 2017-01-18.
 */
public class RegisterController {


    @FXML
    private VBox registerContainer;

    private SceneSwitcherModel sceneSwitcher;

    public void initialize(){
        sceneSwitcher = new SceneSwitcherModel();
    }

    public void handleBackButton(ActionEvent event) throws IOException {

        VBox changedContainer = sceneSwitcher.loadScreen("../view/loginWindow.fxml");
        sceneSwitcher.show(registerContainer, changedContainer);

    }
}
