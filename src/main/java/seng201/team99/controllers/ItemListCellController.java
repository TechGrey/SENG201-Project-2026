package seng201.team99.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class ItemListCellController extends ListCell<String> {
    @FXML
    private Label nameLabel;

    @FXML
    private Label descriptionLabel;

    @FXML
    private Label costLabel;

    @FXML
    private Label statsLabel;

    @FXML
    private GridPane gridPaneController;

    private FXMLLoader cellLoader;

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);

        if (empty || item == null) {
            setText(null);
            setGraphic(null);
        } else {
            if (cellLoader == null) {
                cellLoader = new FXMLLoader(getClass().getResource("/fxml/components/marketListItem.fxml"));
                cellLoader.setController(this);
                try {
                    cellLoader.load();
                } catch (IOException e) {
                    throw new IllegalStateException("Unable to load marketListItem.fxml", e);
                }
            }

            nameLabel.setText(item);
            descriptionLabel.setText(item);
            costLabel.setText(item);
            statsLabel.setText(item);

            setGraphic(gridPaneController);
        }
    }
}
