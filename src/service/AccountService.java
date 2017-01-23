package service;

import dao.UserBean;
import dao.UserDAO;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import lombok.AllArgsConstructor;
import model.ConnectionModel;
import model.SceneSwitcherModel;

import java.io.IOException;

/**
 * Created by Krzysztof on 2017-01-18.
 */

public class AccountService extends LoginTypeSuperclass {

    private TextField loginInput;
    private PasswordField passInput;

    public AccountService(SceneSwitcherModel sceneSwitcher, ConnectionModel connectionModel, TextField loginInput, PasswordField passInput) {
        super(sceneSwitcher, connectionModel);
        this.loginInput = loginInput;
        this.passInput = passInput;
    }

    @Override
    public void logIn() throws IOException {
        UserDAO userDAO = new UserDAO(loginInput,passInput);
        userDAO.logIn();
        setUsername(userDAO.getUserBean().getUsername());

        connectionModel = new ConnectionModel();
        connectionModel.connectToServer();
        connectionModel.sendUsernameToServer(username);
    }


}
