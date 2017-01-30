package service.sender;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lombok.Getter;
import lombok.Setter;
import service.alerts.AlertService;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Krzysztof on 2017-01-25.
 */

public class SendMessageService {

    private Socket serverSocket;
    @Setter
    @Getter
    private String username;
    private TextField messsageInput;

    public SendMessageService(Socket serverSocket, TextField messageTextField) {
        this.serverSocket = serverSocket;
        this.username = null;
        this.messsageInput = messageTextField;
    }


    public void sendMessageToServer() throws IOException {

        if (serverSocket != null){

            String message = getMessageFromInputTextField();
            PrintWriter clientWriter = new PrintWriter(serverSocket.getOutputStream());
            clientWriter.println(message);
            clientWriter.flush();

            messsageInput.clear();

        }
        else{
            AlertService.showAlert(Alert.AlertType.ERROR,"Message error","Message can not be sent! Check your connection to the server.");
        }

    }

    private String getMessageFromInputTextField(){

        if (messsageInput != null){
            return username + " > " + messsageInput.getText();
        }
        else{
            return username + " > ";
        }

    }

}
