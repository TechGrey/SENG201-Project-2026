package seng201.team99.controllers.nodes;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import seng201.team99.consumables.Adventurer;
import seng201.team99.consumables.Purchasable;
import seng201.team99.items.Item;
import seng201.team99.items.ItemType;

public class MarketListCellController extends AbstractCustomListCell<Item> {
    @FXML private Label nameLabel;
    @FXML private Label descriptionLabel;
    @FXML private Label costLabel;
    @FXML private Label typeLabel;
    @FXML private Label statsLabel;

    public MarketListCellController() {
        super("/fxml/MarketListCell.fxml");
    }

    @Override
    protected void setupLabels(Item item) {
        nameLabel.setText(item.name);
        descriptionLabel.setText(item.getDescription());
        costLabel.setText(String.format("$%.2f", item.getCost()));

        switch (item.type){
            case PERMANENT -> typeLabel.setText("P");
            case EQUIPMENT -> typeLabel.setText("E");
            case TIMED -> typeLabel.setText("T");
        }

        statsLabel.setText(item.stats.toString());
    }
}
