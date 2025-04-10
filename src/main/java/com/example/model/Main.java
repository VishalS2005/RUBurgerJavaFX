package com.example.model;

import com.example.controller.MainController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends javafx.application.Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        MainController mainController = fxmlLoader.getController();
        mainController.setPrimaryStage(stage, scene);
        stage.setTitle("RU Burger");
        stage.setScene(scene);
        mainController.initializeCartView();
        mainController.initializeOrderView();
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}