package seng201.team99.services;

//*
// @author Elliott Grey

import seng201.team99.consumables.Guild;
import seng201.team99.services.expedition.ExpeditionManagerService;

/* This class is where the game would look initially to start the game and set all the resources, etc.
In here, the game would initialise a lot of Events, build an ExpeditionBuilder and so on.
*/
public class GameStartService {

    public static void main(String[] args) {
        // Where the game will run.

        String guildName = "Deep Dark";

        Guild guild = new Guild(guildName);

        ExpeditionManagerService expeditionManagerService =
            new ExpeditionManagerService();
        //        expeditionManagerService.runExpedition(, guild);
    }
}
