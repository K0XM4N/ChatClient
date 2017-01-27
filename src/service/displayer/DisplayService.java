package service.displayer;

import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import model.ReceiverModel;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Krzysztof on 2017-01-24.
 */
public class DisplayService implements Runnable{

    private StringBuilder conversation;
    private Socket serverSocket;
    private ListView onlineUsersListView;
    private int listViewSize;

    public DisplayService(Socket serverSocket, ListView onlineUsersListView){
        conversation = new StringBuilder();
        this.serverSocket = serverSocket;
    }

    public DisplayService(Socket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void showMessage(TextArea chatTextArea, String message){
        String messageTime = getMessageTime();
        conversation.append(messageTime + "\n       " + message + "\n");
        chatTextArea.setText(conversation.toString());
    }

    public synchronized void showUser(List<String> onlineUsers){

        onlineUsersListView.getItems().clear();
        onlineUsersListView.getItems().addAll(onlineUsers);
        listViewSize = onlineUsersListView.getItems().size();

    }

    public void removeUser(ListView userListView, String username){

    }

    private String getMessageTime(){

        LocalDateTime time = LocalDateTime.now();
        String messageTime = time.toString().substring(11,16);
        return messageTime;

    }

    /**
     * Allows to listen for online users update
     */
    @Override
    public void run() {
        try {
            updateUsers();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void updateUsers() throws IOException, ClassNotFoundException, InterruptedException {

        ReceiverModel onlineUsersReceiver = new ReceiverModel(false);
        List<String> firstUsersList = onlineUsersReceiver.getOnlineUsersList();

//        while (true){
//
//
//        }
    }
}
