package model;

import lombok.Setter;
import service.displayer.DisplayService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by Krzysztof on 2017-01-23.
 */

@Setter
public class ReceiverModel implements Runnable {

    private boolean continueThread;
    private ConnectionModel connectionModel;
    private Socket serverSocket;

    public ReceiverModel(boolean continueThread){
        this.continueThread = continueThread;
        this.connectionModel = ConnectionModel.getInstance();
        serverSocket = connectionModel.getServerSocket();
    }

    @Override
    public void run() {
        try {
            startListeningForMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void startListeningForMessage() throws IOException {

        if (serverSocket != null){

            InputStreamReader chatInput = new InputStreamReader(serverSocket.getInputStream());
            BufferedReader messageReader = new BufferedReader(chatInput);
            DisplayService messageDisplayer = new DisplayService();
            String message = "";

            while (continueThread){

                if ((message=messageReader.readLine()) != null){
                    System.out.println(message);
                    messageDisplayer.showMessage(connectionModel.getChatTextArea(),message);
                }

            }
        }

    }

}
