package service.displayer;

import javafx.scene.control.TextArea;

import java.time.LocalDateTime;

/**
 * Created by Krzysztof on 2017-01-24.
 */

public class MessageDisplayer implements Displayer {

    private TextArea chatTextArea;
    private StringBuilder conversation;

    public MessageDisplayer(TextArea chatTextArea){
        this.chatTextArea = chatTextArea;
        conversation = new StringBuilder();
    }


    @Override
    public void show(String textToDisplay) {

        String messageTime = getMessageTime();
        conversation.append(messageTime + "\n       " +textToDisplay + "\n");
        chatTextArea.setText(conversation.toString());

    }


    private String getMessageTime() {
        LocalDateTime currentTime = LocalDateTime.now();
        return currentTime.toString().substring(11,16);
    }
}
