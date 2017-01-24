package service.displayer;

import javafx.scene.control.ListView;

/**
 * Created by Krzysztof on 2017-01-24.
 */
public class UserDisplayer implements Displayer, DisplayRemover {

    private ListView usersListView;

    public UserDisplayer(ListView usersListView){
        this.usersListView = usersListView;
    }

    @Override
    public void show(String textToDisplay) {

        usersListView.getItems().add(textToDisplay);

    }

    @Override
    public void remove() {

    }
}
