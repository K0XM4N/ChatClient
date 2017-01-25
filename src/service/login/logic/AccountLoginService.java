package service.login.logic;

import dao.UserDAO;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import model.ConnectionModel;
import model.SceneSwitcherModel;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;

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
    public void logIn() throws IOException, PropertyVetoException, SQLException {
        UserDAO userDAO = new UserDAO(loginInput,passInput);

        if (userDAO.logIn()) {
            setUsername(userDAO.getUserBean().getUsername());

            connectionModel = ConnectionModel.getInstance();

            if (connectionModel.connectToServer()) {
                connectionModel.sendUsernameToServer(username);
                connectionModel.receiveUsernameFromServer();
                loadChatWindow();
                connectionModel.displayOnlineUser();
                listenForMessage();
            }

        }

    }


}
