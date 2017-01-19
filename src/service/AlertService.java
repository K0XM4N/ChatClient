package service;

import javafx.scene.control.Alert;

/**
 * Created by Krzysztof on 2017-01-19.
 */
public abstract class AlertService {

    public static void showAlert(Alert.AlertType alertType, String title, String message){

        Alert alert = new Alert(alertType,message);
        alert.setTitle(title);
        alert.show();

    }

}
