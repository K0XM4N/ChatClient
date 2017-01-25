package service.sender;

import lombok.Getter;
import lombok.Setter;

import java.net.Socket;

/**
 * Created by Krzysztof on 2017-01-25.
 */
@Getter
@Setter
public class SendMessageService {

    private Socket serverSocket;
    private String username;

    public SendMessageService(Socket serverSocket, String username) {
        this.serverSocket = serverSocket;
        this.username = username;
    }


}
