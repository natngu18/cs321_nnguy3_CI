package com.example.javafxdemo;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class WorkflowItem {
    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public GeneaologyRequest getReq() {
        return req;
    }

    public void setReq(GeneaologyRequest req) {
        this.req = req;
    }

    public WorkflowItem(String step, GeneaologyRequest req) {
        this.step = step;
        this.req = req;
    }

    private String step;
    private GeneaologyRequest req;

    public void loadNextScreen(ActionEvent actionEvent) throws IOException {
            FXMLLoader loader = new FXMLLoader(WorkflowItem.class.getResource(step.toLowerCase() + ".fxml"));

            if (step.equalsIgnoreCase("approval")) {
                loader.setControllerFactory(param -> new ApprovalController(req));
            } else if (step.equalsIgnoreCase("review")) {
                loader.setControllerFactory(param -> new ReviewController(req));
            } else if(step.equalsIgnoreCase("data-entry")){
                loader.setControllerFactory(param -> new DataEntryController(req));
            } else {
                throw new IllegalStateException("Invalid step provided in GeneaologyRequest object.");
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
