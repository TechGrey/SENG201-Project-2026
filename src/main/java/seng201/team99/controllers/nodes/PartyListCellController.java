package seng201.team99.controllers.nodes;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import seng201.team99.consumables.Adventurer;

public class PartyListCellController extends AbstractCustomListCell<Adventurer> {
    @FXML private Label nameLabel;
    @FXML private Label costLabel;
    @FXML private Label descriptionLabel;
    @FXML private Label statsLabel;

    public PartyListCellController() {
        super("/fxml/PartyListCell.fxml");
    }

    @Override
    protected void setupLabels(Adventurer adventurer) {
        nameLabel.setText(adventurer.name);
        costLabel.setText("Free");
        descriptionLabel.setText(adventurer.getDescription());
        statsLabel.setText(adventurer.getStats().toString());
    }
}
