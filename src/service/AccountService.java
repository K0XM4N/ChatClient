package service;

import dao.UserBean;
import dao.UserDAO;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import lombok.AllArgsConstructor;
import model.ConnectionModel;

import java.io.IOException;

/**
 * Created by Krzysztof on 2017-01-18.
 */
@AllArgsConstructor
public class AccountService extends LoginTypeSuperclass {

    private TextField loginInput;
    private PasswordField passInput;
    private ConnectionModel connectionModel;


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
