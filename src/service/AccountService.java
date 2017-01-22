package service;

import dao.UserBean;
import dao.UserDAO;
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
        UserDAO userDAO = new UserDAO(loginInput,passInput);
        userDAO.logIn();
        setUsername(userDAO.getUserBean().getUsername());
    }

    @Override
    protected void sendUsernameToServer() throws IOException {
        super.sendUsernameToServer();
    }
}
