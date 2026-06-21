package seng201.team99.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import seng201.team99.controllers.nodes.MarketListCellController;
import seng201.team99.items.Item;
import seng201.team99.services.FakeDataService;
import seng201.team99.services.GameHostingEnvironment;

/**
 * Controller for the main.fxml window
 *
 * @author Jonathan Voss
 */
public class MarketTabController {
    @FXML
    private ListView<Item> marketItemsListView;

    @FXML
    private ListView<Item> inventoryItemsListView;

    private ObservableList<Item> marketItems = FXCollections.observableArrayList();
    private ObservableList<Item> inventoryItems = FXCollections.observableArrayList();

    private GameHostingEnvironment environment;

    private void refreshInventory() {
        inventoryItems.clear();
        inventoryItems.addAll(environment.getGuild().inventory.getItems());
        inventoryItemsListView.setItems(inventoryItems);
    }

    @FXML
    private void buyItem() {
        Item selectedItem = marketItemsListView.getSelectionModel().getSelectedItem();
        if (selectedItem == null) {
            showMarketAlert("You need to select an item to buy first. Air not for sale.");
        } else {
            if (environment.getGuild().getGold() < selectedItem.getCost()) {
                showMarketAlert("You can't afford that right now. You currently have " + environment.getGuild().getGold() + " gold, but need " + selectedItem.getCost() + ".");
            } else {
                environment.getGuild().addGold(-selectedItem.getCost());
                environment.getGuild().inventory.addItem(selectedItem);
                marketItems.remove(selectedItem);
                refreshInventory();
            }
        }
    }

    @FXML
    private void sellItem() {
        Item selectedItem = inventoryItemsListView.getSelectionModel().getSelectedItem();
        if (selectedItem == null) {
            showMarketAlert("You need to select an item to sell.");
        } else {

            // Adding a debuff to the item so the player can't mind the gold mechanic.
            environment.getGuild().addGold(selectedItem.getCost()* 0.75);
            environment.getGuild().inventory.removeItem(selectedItem);
            refreshInventory();
        }
    }

    public void showMarketAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(message);
        alert.show();
    }

    public void refreshMarket() {
        marketItems.clear();
        marketItems.addAll(new FakeDataService().getFakeSkillItems(5));
        marketItems.addAll(new FakeDataService().getFakeUpgradeItems(5));
        marketItems.sort((t1, t2) -> (int) (t1.getCost() - t2.getCost()));
        marketItemsListView.setItems(marketItems);
    }

    public void init(Stage stage, GameHostingEnvironment environment) {
        this.environment = environment;
        marketItems.clear();
        refreshInventory();

        // Fill out some fake data for UI testing
        marketItems.addAll(new FakeDataService().getFakeEquipmentItems(5));
        marketItems.addAll(new FakeDataService().getFakeSkillItems(5));
        marketItems.addAll(new FakeDataService().getFakeUpgradeItems(5));

        marketItems.sort((t1, t2) -> (int) (t1.getCost() - t2.getCost()));

        marketItemsListView.setItems(marketItems);

        marketItemsListView.setCellFactory(li -> new MarketListCellController());
        inventoryItemsListView.setCellFactory(li -> new MarketListCellController());
    }

}
