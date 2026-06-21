package seng201.team99.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import seng201.team99.services.GameHostingEnvironment;

/**
 * Controller for the main.fxml window
 *
 * @author Jonathan Voss, Elliott Grey
 */
public class MainController {
    @FXML private MarketTabController marketTabController;

    @FXML private ExpeditionTabController expeditionTabController;

    @FXML private GuildTabController guildTabController;

    @FXML private Label goldLabel;

    @FXML
    public void initialize() {
        // At this point, the child controllers are fully loaded and injected.
        // You can now call your custom init methods on them.
    }

    public void initAllTabs(Stage stage, GameHostingEnvironment environment) {
        // Pass the stage or other data to your child controllers here
        double gold = environment.getGuild().getGold();
        goldLabel.setText("" + gold);
        if (marketTabController != null) {
            marketTabController.init(stage, environment);
        }

        if (expeditionTabController != null) {
            expeditionTabController.init(stage, environment);
        }

        if (guildTabController != null) {
            guildTabController.init(stage, environment);
        }

    }

}
