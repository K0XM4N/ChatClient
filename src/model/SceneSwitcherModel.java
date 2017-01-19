package model;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;

import java.io.IOException;

/**
 * Created by Krzysztof on 2017-01-18.
 */
public class SceneSwitcherModel {

    private VBox container;
    public VBox loadScreen(String pathToViewFXML) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(pathToViewFXML));
        container = loader.load();

        return container;
    }

    public void show(VBox currentVBoxContainer, VBox changedContainer){

        currentVBoxContainer.getChildren().clear();
        currentVBoxContainer.getChildren().addAll(changedContainer);

    }
}
