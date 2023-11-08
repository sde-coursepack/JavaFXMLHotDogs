package edu.virginia.sde.javafx.tacos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HotDogVotesApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        var fxmlLoader = new FXMLLoader(HotDogVotesApplication.class.getResource("taco-vote.fxml"));
        var scene = new Scene(fxmlLoader.load());
        var controller = (HotDogVotesController) fxmlLoader.getController();
        controller.setPrimaryStage(primaryStage);
        primaryStage.setTitle("Hot Dog Vote");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
