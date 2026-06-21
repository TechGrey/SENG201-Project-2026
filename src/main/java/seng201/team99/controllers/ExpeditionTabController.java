package seng201.team99.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import seng201.team99.consumables.Adventurer;
import seng201.team99.consumables.Guild;
import seng201.team99.services.Difficulty;
import seng201.team99.services.GameHostingEnvironment;
import seng201.team99.services.expedition.Expedition;
import seng201.team99.services.expedition.ExpeditionBuilder;
import seng201.team99.services.expedition.ExpeditionManagerService;

import java.io.IOException;
import java.util.List;

/**
 * Controller for the main.fxml window
 *
 * @author Elliott Grey, Jonathan Voss
 */
public class ExpeditionTabController {
    // FXML for displaying the difficulty.
    private Guild guild;
    private GameHostingEnvironment environment;
    private MarketTabController marketTabController;

    // Shows the Expedition Event Difficulty and gives the FXML a place to display it.
    @FXML public ListView<Expedition> expeditionListView;
    @FXML public Label expeditionDifficultyLabel;
    @FXML public ListView<Adventurer> partyListView;

    // Holds the list of Expedition choices for the player to choose from in FXML.
    private ObservableList<Expedition> playerExpeditionChoices = FXCollections.observableArrayList();

    ExpeditionManagerService expeditionService = new ExpeditionManagerService();

    public void setMarketTabController(MarketTabController marketTabController) {
        this.marketTabController = marketTabController;
    }

    @FXML
    private void startExpedition(ActionEvent event) {
        Expedition selectedExpedition = expeditionListView.getSelectionModel().getSelectedItem();

        if (selectedExpedition == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please select an expedition on the right before playing.");
            alert.show();
        } else {
            expeditionService.runExpedition(selectedExpedition, guild);
            marketTabController.refreshMarket();
            if (guild.mainParty.getMembers().isEmpty()) {
                environment.checkGameOver();
            } else {
                String outcomeMessage = expeditionService.rollPostExpeditionEvents(guild, environment.getDifficulty());
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText(outcomeMessage);
                alert.show();

                environment.advanceExpedition();


                if (environment.checkGameWon()) {
                    // Woohoo!
                    // Loads success end screen:
                    loadEndScreen(true);

                } else if (environment.checkGameOver()) {
                    // Oh...
                    // Loads end screen (player died)
                    loadEndScreen(false);
                } else {
                    playerExpeditionChoices.clear();
                    playerExpeditionChoices.addAll(
                            ExpeditionBuilder.ancientRuinRun(environment.getDifficulty()),
                            ExpeditionBuilder.dragonsCastle(environment.getDifficulty()),
                            ExpeditionBuilder.intrepidMountains(environment.getDifficulty()),
                            ExpeditionBuilder.forestAmble(environment.getDifficulty())
                    );
                }
            }
        }
    }

    private void loadEndScreen(boolean won) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/EndCreditsScene.fxml"));
            Parent root = loader.load();
            EndCreditsSceneController controller = loader.getController();
            controller.init(environment, won);
            Stage stage = (Stage) expeditionListView.getScene().getWindow();
            stage.setScene(new Scene(root, 800, 700));
            stage.show();
        } catch (IOException exception) {
            throw new RuntimeException("Couldn't load the end credits scene because of " + exception);
        }
    }

    public void init(Stage stage, GameHostingEnvironment environment) {
        System.out.println("Staging the game environment.");
        this.guild = environment.getGuild();
        this.environment = environment;
        this.setMarketTabController(marketTabController);
        Difficulty difficulty = environment.getDifficulty();
        expeditionDifficultyLabel.setText("Expedition Difficulty: " + environment.getDifficulty());

        playerExpeditionChoices.addAll(
                ExpeditionBuilder.ancientRuinRun(difficulty),
                ExpeditionBuilder.dragonsCastle(difficulty),
                ExpeditionBuilder.intrepidMountains(difficulty),
                ExpeditionBuilder.forestAmble(difficulty)
        );

        // Setting the ExpeditionListView now with the choices...
        expeditionListView.setItems(playerExpeditionChoices);

        // Setting the party members...
        partyListView.setItems(FXCollections.observableArrayList(environment.getGuild().mainParty.getMembers()));
    }
}
