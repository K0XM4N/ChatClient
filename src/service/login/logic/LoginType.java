package service.login.logic;

import lombok.Getter;
import lombok.NonNull;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Krzysztof on 2017-01-18.
 */

public interface LoginType {

    public void logIn() throws IOException, PropertyVetoException, SQLException;

}
