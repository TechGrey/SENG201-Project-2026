package seng201.team99.controllers.nodes;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ListCell;

import java.io.IOException;

/**
 * Abstract constructor for List Cells with Custom FXML Nodes replacing
 * Labels.
 *
 * @param <T> Type for Input Data, Typically Type of ListView Array
 * @author Jonathan Voss
 */
public abstract class AbstractCustomListCell<T> extends ListCell<T> {
    private Node view;
    private final String fxmlPath;

    protected AbstractCustomListCell(String fxmlPath) {
        this.fxmlPath = fxmlPath;
    }

    @Override
    protected void updateItem(T item, boolean empty) {
        super.updateItem(item, empty);

        if (empty || item == null) {
            setGraphic(null);
            setText(null);
        } else {
            if (view == null) {
                initializeView();
            }
            setupLabels(item);
            setGraphic(view);
        }
    }

    private void initializeView() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        loader.setController(this);
        try {
            view = loader.load();
        } catch (IOException e) {
            throw new RuntimeException("Could not load FXML: " + fxmlPath, e);
        }
    }

    /**
     * Override this to map your object properties to your FXML @FXML fields.
     * function will be called everytime that updateItem is called.
     */
    protected abstract void setupLabels(T item);
}
