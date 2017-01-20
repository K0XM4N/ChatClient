package service;

/**
 * Created by Krzysztof on 2017-01-19.
 */
public class LoginFieldsValidatorService {

    public static boolean isFieldVerified(String login, String username, String pass1, String pass2){

        if (login.isEmpty() || username.isEmpty() || pass1.isEmpty() || pass2.isEmpty()){
            return false;
        }
        else{
            if (pass1.equals(pass2)) return true;
            else return  false;
        }

    }

}
