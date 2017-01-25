package service.displayer;

import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by Krzysztof on 2017-01-24.
 */
public class DisplayService {

    private StringBuilder conversation;

    public DisplayService(){
        conversation = new StringBuilder();
    }

    public void showMessage(TextArea chatTextArea, String message){
        String messageTime = getMessageTime();
        conversation.append(messageTime + "\n       " + message + "\n");
        chatTextArea.setText(conversation.toString());
    }

    public void showUser(ListView usersListView, String username){
        usersListView.getItems().add(username);
    }

    public void removeUser(ListView userListView, String username){

    }

    private String getMessageTime(){

        LocalDateTime time = LocalDateTime.now();
        String messageTime = time.toString().substring(11,16);
        return messageTime;

    }
}
