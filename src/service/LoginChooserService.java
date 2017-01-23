package service;

import dao.UserBean;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import lombok.AllArgsConstructor;
import model.ConnectionModel;
import model.SceneSwitcherModel;

/**
 * Created by Krzysztof on 2017-01-18.
 */
@AllArgsConstructor
public class LoginChooserService {


    private TextField loginTextField;
    private PasswordField passPasswordField;
    private CheckBox checkBoxGuest;
    private VBox mainContainer;

    public LoginType chooseLoginType(){

        if (checkBoxGuest.isSelected()){
            return new GuestService(new SceneSwitcherModel(),new ConnectionModel(),mainContainer);
        }
        else{
            return new AccountService(new SceneSwitcherModel(), new ConnectionModel(),loginTextField,passPasswordField, mainContainer);
        }
    }
}
