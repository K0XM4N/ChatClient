package service.displayer;

import javafx.scene.control.TextArea;

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

        conversation.append(textToDisplay);
        chatTextArea.setText(conversation.toString());

    }

}
