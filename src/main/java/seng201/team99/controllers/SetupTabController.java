package seng201.team99.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import seng201.team99.consumables.Adventurer;
import seng201.team99.controllers.nodes.PartyListCellController;
import seng201.team99.services.Difficulty;
import seng201.team99.services.GameHostingEnvironment;
import seng201.team99.stores.Stat;

import java.io.IOException;

/**
 * @author Elliott Grey
 */
public class SetupTabController {

    @FXML private ChoiceBox<Difficulty> startingDifficultyChoiceBox;
    @FXML private Slider expeditionLengthSlider;
    @FXML private Button startGameButton;
    @FXML private ListView<Adventurer> adventurerSelectionListView;
    @FXML private TextField guildNameTextField;
    private Stage stage;

    public boolean checkName(String name) {
        /* Lines 37, 38 and 39 are code that I've adapted from GeeksForGeeks.
        https://www.geeksforgeeks.org/java/java-program-to-check-whether-the-string-consists-of-special-characters/
         */

        for (int i = 0; i < name.length(); i++) {
            if (!Character.isLetterOrDigit(name.charAt(i))) {
                if (!Character.isWhitespace(name.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    @FXML
    public void startGameButton(ActionEvent event) {
        // Checking the basics for nameLength, what a good name is and the list of adventurers.
        int nameLength = guildNameTextField.getLength();
        boolean goodName = checkName(guildNameTextField.getText());
        ObservableList<Adventurer> selectedAdventurers = adventurerSelectionListView.getSelectionModel().getSelectedItems();

        // Checking if all OK...
        if (goodName && (nameLength > 2 && nameLength < 16)) {
            // If Not due to lack of party size...
            if (selectedAdventurers.size() != 3) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("You've selected " + selectedAdventurers.size() + " adventurers. Please change your selection to three adventurers to continue.");
                alert.show();
            } else {
                // Good to go. Deploy the main scene.
                GameHostingEnvironment gameHostingEnvironment = new GameHostingEnvironment(
                        guildNameTextField.getText(),
                        startingDifficultyChoiceBox.getValue(),
                        (int) expeditionLengthSlider.getValue(),
                        selectedAdventurers
                );

                try {
                    FXMLLoader sceneLoader = new FXMLLoader(getClass().getResource("/fxml/Root.fxml"));
                    Parent root = sceneLoader.load();

                    MainController mainController = sceneLoader.getController();
                    mainController.initAllTabs(stage, gameHostingEnvironment);

                    stage.setScene(new Scene(root, 800, 700));
                    stage.show();
                } catch (IOException exception) {
                    throw new RuntimeException("Couldn't load Root.fxml. Error: ", exception);
                }

            }
        } else {
            Alert screenAlert = new Alert(Alert.AlertType.ERROR);
            screenAlert.setContentText("Guild name must be 3-15 characters long and not contain any special characters. Sorry.");
            screenAlert.show();
        }
    }
    public void init(Stage stage) {
        this.stage = stage;
        startingDifficultyChoiceBox.getItems().addAll(Difficulty.values());
        startingDifficultyChoiceBox.setValue(Difficulty.NORMAL);

        ObservableList<Adventurer> availableAdventurers = FXCollections.observableArrayList(
                new Adventurer("Aldric the Bold", "A seasoned warrior with high stamina.", 0, 10, new Stat(80, 20, 40)),
                new Adventurer("Lyra Swiftfoot", "A nimble scout with keen perception.", 0, 8, new Stat(50, 70, 60)),
                new Adventurer("Dorin Stoneback", "A dwarven tank, slow but unstoppable.", 0, 12, new Stat(100, 10, 20)),
                new Adventurer("Syla the Wise", "A mage who spots hidden treasure easily.", 0, 15, new Stat(40, 80, 30)),
                new Adventurer("Brennan Ashcloak", "A rogue with high dexterity.", 0, 9, new Stat(60, 50, 90)),
                new Adventurer("Mira Dawnbringer", "A cleric who keeps the party going.", 0, 11, new Stat(70, 60, 40))
        );

        adventurerSelectionListView.setItems(availableAdventurers);
        adventurerSelectionListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        adventurerSelectionListView.setCellFactory(adventurerListView -> new PartyListCellController());
    }
}
