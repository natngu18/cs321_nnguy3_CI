package com.example.javafxdemo;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Load Data-entry, since we start with data entry screen.
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("data-entry.fxml"));
        fxmlLoader.setControllerFactory(controllerClass -> new DataEntryController());

        Scene scene = new Scene(fxmlLoader.load(), 720, 720);
        stage.setTitle("Data Entry");
        stage.setScene(scene);
        stage.show();
    }



    public static void main(String[] args) {
        launch();
    }
}