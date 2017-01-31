package service.displayer;

import javafx.application.Platform;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import model.ReceiverModel;
import service.sender.SendMessageService;

import java.io.IOException;
import java.net.Socket;
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
    private SendMessageService sendMessageService;

    public DisplayService(Socket serverSocket, ListView onlineUsersListView, SendMessageService sendService){
        this.serverSocket = serverSocket;
        this.onlineUsersListView = onlineUsersListView;
        this.sendMessageService = sendService;
    }

    public DisplayService(Socket serverSocket) {
        this.serverSocket = serverSocket;
        conversation = new StringBuilder();
    }

    public DisplayService(Socket serverSocket, ListView onlineUsersListView) {
        this.serverSocket = serverSocket;
        this.onlineUsersListView = onlineUsersListView;
    }

    public void showMessage(TextArea chatTextArea, String message){
        String messageTime = getMessageTime();
        conversation.append(messageTime + "\n       " + message + "\n");
        chatTextArea.setText(conversation.toString());
    }

    public void showOnlineUsers(List<String> onlineUsers){

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
        List<String> beforeUpdateOnlineUsersList = new LinkedList<>();

        while (true){

            List<String> currentOnlineUsers = onlineUsersReceiver.getOnlineUsersListFromServer();
            if (beforeUpdateOnlineUsersList.size() != currentOnlineUsers.size()){

                System.out.println("NEW USER CONNECTED");

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        showOnlineUsers(currentOnlineUsers);
                    }
                });

                beforeUpdateOnlineUsersList = currentOnlineUsers;

                if (sendMessageService.getUsername() == null){
                    String currentUser = currentOnlineUsers.get(currentOnlineUsers.size()-1);
                    sendMessageService.setUsername(currentUser);
                }
            }

        }
    }
}
