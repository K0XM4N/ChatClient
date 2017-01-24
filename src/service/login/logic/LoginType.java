package service.login.logic;

import lombok.Getter;
import lombok.NonNull;

import java.io.IOException;

/**
 * Created by Krzysztof on 2017-01-18.
 */

public interface LoginType {

    public void logIn() throws IOException;

}
