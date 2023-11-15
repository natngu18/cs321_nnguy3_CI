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
        // *** Change file path location to where Data-Entry fxml file is located on your computer
//        FXMLLoader fxmlLoader = new FXMLLoader(new File("C:/Users/srvth/Desktop/JavafxDemo/src/main/resources/com/example/javafxdemo/approval.fxml").toURI().toURL());
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("data-entry.fxml"));
        // This is the Request Business Object passed to Approval Screen, so that the form fields will be pre-populated.
//        GeneaologyRequestApproval passedRequest = new GeneaologyRequestApproval(123, new Citizen(1,
//                "John Doe",
//                "johndoe@gmail.com"),
//                List.of(new Form(51, "Test Form", "This is a test")),
//                "Pending",
//                124124 );

        // This passes the Business Object To Controller.
        fxmlLoader.setControllerFactory(controllerClass -> new DataEntryController());

        Scene scene = new Scene(fxmlLoader.load(), 720, 1080);
        stage.setTitle("Data Entry");
        stage.setScene(scene);
        stage.show();
    }



    public static void main(String[] args) {
        launch();
    }
}