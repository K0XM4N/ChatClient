package service.login.logic;

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
            return new GuestLoginService(new SceneSwitcherModel(),ConnectionModel.getInstance(),mainContainer);
        }
        else{
            return new AccountLoginService(new SceneSwitcherModel(), ConnectionModel.getInstance(),loginTextField,passPasswordField, mainContainer);
        }
    }
}
