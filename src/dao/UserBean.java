package dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Created by Krzysztof on 2017-01-19.
 */


@Setter
@Getter
@AllArgsConstructor
public class UserBean {

    private int id;
    private String login;
    private String username;
    private String password1;
    private String password2;

    public UserBean(String login, String username, String actualPassword){
        this.login = login;
        this.username = username;
        this.password1 = actualPassword;
    }

}
