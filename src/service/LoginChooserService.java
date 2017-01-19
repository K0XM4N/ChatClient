package service;

import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import lombok.AllArgsConstructor;

/**
 * Created by Krzysztof on 2017-01-18.
 */
@AllArgsConstructor
public class LoginChooserService {


    private TextField loginTextField;
    private PasswordField passPasswordField;
    private CheckBox checkBoxGuest;

    public LoginType chooseLoginType(){

        if (checkBoxGuest.isSelected()){
            return new GuestService();
        }
        else{
            return new AccountService(loginTextField,passPasswordField);
        }
    }
}
