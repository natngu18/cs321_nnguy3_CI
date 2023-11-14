package com.example.javafxdemo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class ApprovalApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ApprovalApplication.class.getResource("hello-view.fxml"));

        // This is the Request Business Object passed to Approval Screen, so that the form fields will be pre-populated.
        GeneaologyRequestApproval passedRequest = new GeneaologyRequestApproval(123, new Citizen(1,
                "John Doe",
                "johndoe@gmail.com"),
                List.of(new Form(51, "Test Form", "This is a test")),
                "Pending",
                124124 );

        // This passes the Business Object To Controller.
        fxmlLoader.setControllerFactory(controllerClass -> new ApprovalController(passedRequest));

        Scene scene = new Scene(fxmlLoader.load(), 720, 1080);
        stage.setTitle("Approval");
        stage.setScene(scene);
        stage.show();
    }



    public static void main(String[] args) {
        launch();
    }
}