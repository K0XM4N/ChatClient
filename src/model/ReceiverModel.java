package model;

import lombok.Getter;
import lombok.Setter;
import service.displayer.DisplayService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Krzysztof on 2017-01-23.
 */

@Setter
public class ReceiverModel implements Runnable {

    private boolean continueThread;
    private ConnectionModel connectionModel;
    private Socket serverSocket;
    @Getter
    private List<String> onlineUsers;

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
            DisplayService messageDisplayer = new DisplayService(serverSocket);
            String message = "";

            while (continueThread){

                if ((message=messageReader.readLine()) != null){
                    System.out.println(message);
                    messageDisplayer.showMessage(connectionModel.getChatTextArea(),message);
                }

            }
        }

    }

    public List<String> getOnlineUsersListFromServer() throws IOException, ClassNotFoundException {

        //List<String> onlineUsers = null;

        if (serverSocket != null){

            ObjectInputStream usersStream = new ObjectInputStream(serverSocket.getInputStream());
            onlineUsers = (LinkedList<String>) usersStream.readObject();

            System.out.println("Users online");
            for (String x: onlineUsers){
                System.out.println(x);
            }

            return onlineUsers;
        }
        else{
            onlineUsers = new LinkedList<>();
            onlineUsers.add("NULL");
            return onlineUsers;
        }

    }
}
