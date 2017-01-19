package service;

import java.io.IOException;

/**
 * Created by Krzysztof on 2017-01-18.
 */
public class AccountService extends LoginTypeSuperclass {



    @Override
    public void logIn() {

    }

    @Override
    protected void sendUsernameToServer() throws IOException {
        super.sendUsernameToServer();
    }
}
