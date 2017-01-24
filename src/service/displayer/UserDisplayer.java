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

        if (usersListView != null) {
            usersListView.getItems().addAll(textToDisplay);
        } else {
            System.out.println("ListView is null");
        }

    }

    @Override
    public void remove() {

    }
}
