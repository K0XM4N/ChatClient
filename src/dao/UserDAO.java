package dao;

/**
 * Created by Krzysztof on 2017-01-19.
 */
public class UserDAO {

    private static final String CREATE = "INSERT INTO user(id, login, username, password) VALUES(?, ?, ?, ?);";
    private static final String READ = "SELECT login FROM user WHERE login = ?;";



}
