package seng201.team99.controllers;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import seng201.team99.consumables.Adventurer;
import seng201.team99.items.Item;
import seng201.team99.services.GameHostingEnvironment;

import java.util.List;

/**
 * Controller for the main.fxml window
 *
 * @author Elliott Grey
 */
public class GuildTabController {

    private GameHostingEnvironment environment;

    @FXML private ListView<Adventurer> currentPartyListView;
    @FXML private ListView<Item> inventoryListView;
    @FXML private ListView<Adventurer> reservePartyListView;
    @FXML private Button moveAdventurerButon;
    @FXML private Button useItemButton;

    @FXML
    private void moveAdventurerButon() {

        // Here, putting in code that helps move characters around.
        Adventurer selectedAdventurerOnCurrentParty = currentPartyListView.getSelectionModel().getSelectedItem();
        Adventurer selectedAdventurerOnReserveParty = reservePartyListView.getSelectionModel().getSelectedItem();

        // This code checks if the move is a valid thing to achieve. If it is, then it will move the selected Adventurer.
        if (environment.getGuild().mainParty.getMembers().size() > 1) {
            if (selectedAdventurerOnCurrentParty == null && selectedAdventurerOnReserveParty == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("You need to select an adventurer to move.");
                alert.show();
            } else {
                if (selectedAdventurerOnReserveParty != null) {
                    environment.getGuild().reserveParty.removeMember(selectedAdventurerOnReserveParty);
                    environment.getGuild().mainParty.addMember(selectedAdventurerOnReserveParty);
                } else {
                    environment.getGuild().mainParty.removeMember(selectedAdventurerOnCurrentParty);
                    environment.getGuild().reserveParty.addMember(selectedAdventurerOnCurrentParty);
                }
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("You need at least one Adventurer to move! Time to hire some help...");
            alert.show();
        }

        refreshAllLists();
    }

    @FXML void setUseItemButton(ActionEvent event) {

    }

    public void init(Stage stage, GameHostingEnvironment gameHostingEnvironment) {
        this.environment = gameHostingEnvironment;
        refreshAllLists();
    }

    private void refreshAllLists() {
        // Refreshes the listViews.

        currentPartyListView.setItems(FXCollections.observableArrayList(
                environment.getGuild().mainParty.getMembers()
        ));

        reservePartyListView.setItems(FXCollections.observableArrayList(
                environment.getGuild().reserveParty.getMembers()
        ));

        inventoryListView.setItems(FXCollections.observableArrayList(
                environment.getGuild().inventory.getItems()
        ));
    }
}
