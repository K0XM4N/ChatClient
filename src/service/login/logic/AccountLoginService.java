package service.login.logic;

import dao.UserDAO;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import model.ConnectionModel;
import model.SceneSwitcherModel;

import java.io.IOException;

/**
 * Created by Krzysztof on 2017-01-18.
 */

public class AccountLoginService extends LoginTypeSuperclass {

    private TextField loginInput;
    private PasswordField passInput;

    public AccountLoginService(SceneSwitcherModel sceneSwitcher, ConnectionModel connectionModel, TextField loginInput, PasswordField passInput, VBox mainContainer) {
        super(sceneSwitcher, connectionModel,mainContainer);
        this.loginInput = loginInput;
        this.passInput = passInput;
        this.mainContainer = mainContainer;
    }

    @Override
    public void logIn() throws IOException {
        UserDAO userDAO = new UserDAO(loginInput,passInput);
        userDAO.logIn();
        setUsername(userDAO.getUserBean().getUsername());

        connectionModel = ConnectionModel.getInstance();
        connectionModel.connectToServer();
        connectionModel.sendUsernameToServer(username);
        loadChatWindow();
    }


}
