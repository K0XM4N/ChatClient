package model;

import lombok.AllArgsConstructor;
import lombok.Setter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by Krzysztof on 2017-01-23.
 */
@AllArgsConstructor
@Setter
public class ReceiverModel implements Runnable {

    private boolean continueThread;
    private Socket serverSocket;


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

            String message = "";

            while (continueThread){

                if ((message=messageReader.readLine()) != null){
                    System.out.println(message);
                }

            }
        }

    }
}
