package service;

import javafx.scene.control.Alert;

/**
 * Created by Krzysztof on 2017-01-19.
 */
public class LoginFieldsValidatorService {

    public static boolean isFieldVerified(String login, String username, String pass1, String pass2){

        if (login.isEmpty() || username.isEmpty() || pass1.isEmpty() || pass2.isEmpty()){
            AlertService.showAlert(Alert.AlertType.INFORMATION, "Empty field","Please fill all fields.");
            return false;
        }
        else{
            if (pass1.equals(pass2)) return true;
            else{
                AlertService.showAlert(Alert.AlertType.ERROR,"Invalid password","Passwords are not the same!");
                return  false;
            }
        }

    }

    public static boolean isFieldVerified(String login,  String pass1){

        if (login.isEmpty() || pass1.isEmpty()){
            return false;
        }
        else{
            return true;
        }

    }

}
