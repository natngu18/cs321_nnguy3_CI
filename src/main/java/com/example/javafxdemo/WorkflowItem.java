package com.example.javafxdemo;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class WorkflowItem {
    public static void loadFXML(ActionEvent actionEvent, String step, GeneaologyRequestApproval req) throws IOException {
            FXMLLoader loader = new FXMLLoader(WorkflowItem.class.getResource(step.toLowerCase() + ".fxml"));

            if (step.equalsIgnoreCase("approval")) {
                loader.setControllerFactory(param -> new ApprovalController(req));
            } else if (step.equalsIgnoreCase("review")) {
                loader.setControllerFactory(param -> new ReviewController(req));

            }

            Parent newView = loader.load();

            Scene scene = new Scene(newView, 720, 720);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle(step.toUpperCase());

            Stage currentStage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
            currentStage.close(); // Close the current window if needed

            stage.show();
        }
    }
