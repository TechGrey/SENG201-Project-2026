package seng201.team99.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import seng201.team99.controllers.SetupTabController;
//import seng201.team99.controllers.MainController;
import java.io.IOException;

/**
 * Class starts the javaFX application window
 *
 * @author Jonathan Voss
 */
public class MainWindow extends Application {

    /**
     * Launches the FXML application, this must be called from another class (in this cass App.java) otherwise JavaFX
     * errors out and does not run
     *
     * @param args command line arguments
     */
    public static void launchWrapper(String[] args) {
        launch(args);
    }

    /**
     * Opens the gui with the fxml content specified in resources/fxml/main.fxml
     *
     * @param primaryStage The current fxml stage, handled by javaFX Application class
     * @throws IOException if there is an issue loading fxml file
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader baseLoader = new FXMLLoader(getClass().getResource("/fxml/Setup.fxml"));
        Parent root = baseLoader.load();
        SetupTabController setupController = baseLoader.getController();
        setupController.init(primaryStage);

        primaryStage.setTitle("SENG201 2026 Project by Jonaathan Voss and Elliott Grey");
        primaryStage.setScene(new Scene(root, 800, 700));
        primaryStage.show();
    }

}
