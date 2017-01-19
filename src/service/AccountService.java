package service;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import lombok.AllArgsConstructor;

import java.io.IOException;

/**
 * Created by Krzysztof on 2017-01-18.
 */
@AllArgsConstructor
public class AccountService extends LoginTypeSuperclass {

    private TextField loginInput;
    private PasswordField passInput;

    @Override
    public void logIn() {

    }

    @Override
    protected void sendUsernameToServer() throws IOException {
        super.sendUsernameToServer();
    }
}
