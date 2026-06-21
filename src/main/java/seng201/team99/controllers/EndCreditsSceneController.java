package seng201.team99.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import seng201.team99.consumables.Guild;
import seng201.team99.services.GameHostingEnvironment;

public class EndCreditsSceneController {
    @FXML public Label outcomeLabel;
    @FXML public Label guildGoldLabel;
    @FXML public Label expeditionsCompletedLabel;
    @FXML public Label adventurersRemainingLabel;
    @FXML public Label guildNameLabel;

    public void init(GameHostingEnvironment environment, boolean won) {
        guildNameLabel.setText(environment.getGuild().name);
        guildGoldLabel.setText("" + environment.getGuild().getGold());
        outcomeLabel.setText(won ? "You won!" : "Defeated. Try again.");
        expeditionsCompletedLabel.setText("" + environment.getCurrentExpeditionNumber());
        adventurersRemainingLabel.setText("" + environment.getGuild().mainParty.getMembers().size());
    }


}
