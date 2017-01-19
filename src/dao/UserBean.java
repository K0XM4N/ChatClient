package dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
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
    private String password;

}
