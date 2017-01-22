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
public class UserBean {

    private int id;
    private String login;
    private String username;
    private String password1;
    private String password2;

    public UserBean(String login, String password1){
        this.login = login;
        this.password1 = password1;
    }

    public UserBean(String login, String username, String password1, String password2) {
        this.login = login;
        this.username = username;
        this.password1 = password1;
        this.password2 = password2;

    }

}
