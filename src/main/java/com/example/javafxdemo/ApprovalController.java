package com.example.javafxdemo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class ApprovalController {
    // Form Fields
    // Use Labels so approval screen can not edit.
    @FXML private Label citizenNameLabel;

    @FXML private Label citizenIDLabel;

    @FXML private Label immigrantNameLabel;

    @FXML private Label immigrantIDLabel;

    @FXML private Label formIDLabel;

    @FXML private Label formDescriptionLabel;

    @FXML private Label reviewerIDField;

    @FXML private Label birthCountryField;

    @FXML private Label dateOfBirthField;

    @FXML private Label dateOfDeathField;

    // Business Object passed to ApprovalController from ReviewController.
    private GeneaologyRequest request;

    public ApprovalController() {}

    // Constructor to set value for business object.
    public ApprovalController(GeneaologyRequest request) {
        this.request = request;
    }

    // initialize() function is automatically called upon creation of controller.
    public void initialize() {
        if (request != null) {
            citizenNameLabel.setText(request.getCitizenName());
            citizenIDLabel.setText(String.valueOf(request.getCitizenId()));
            immigrantNameLabel.setText(request.getImmigrantName());
            immigrantIDLabel.setText(String.valueOf(request.getImmigrantId()));
            formIDLabel.setText(String.valueOf(request.getFormId()));
            formDescriptionLabel.setText(request.getFormDescription());
            reviewerIDField.setText(String.valueOf(request.getReviewerId()));
            birthCountryField.setText(request.getBirthCountry());
            dateOfBirthField.setText(request.getDateOfBirth());
            dateOfDeathField.setText(request.getDateOfDeath());
        }

    }

    public void submitButtonAction(ActionEvent actionEvent) throws IOException {
        // TODO: Send email of requested forms..
        request.sendEmail();

        // Display confirmation alert.
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Your request was successful.");
        alert.setHeaderText(null);
        alert.setContentText("Submit successful!");
        alert.showAndWait();
    }

    public void cancelButtonAction(ActionEvent actionEvent) throws IOException {
        WorkflowItem workflowItem = new WorkflowItem("review", this.request);
        workflowItem.loadNextScreen(actionEvent);
//        WorkflowItem.loadFXML(actionEvent, "review", this.request);

//        FXMLLoader loader = new FXMLLoader(getClass().getResource("review.fxml"));
//        Parent reviewView = loader.load();
//
//        // TODO: Pass data back to review screen
//
//        // new scene for Review screen
//        Scene secondScene = new Scene(reviewView, 720, 720);
//        // Get the stage from the current button
//        Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
//        // Change title
//        currentStage.setTitle("Review");
//        // Set the new scene
//        currentStage.setScene(secondScene);
    }
//    GeneaologyRequest passedRequest = new GeneaologyRequest(
//            citizenNameLabel.getText(),
//            Integer.parseInt(citizenIDLabel.getText()),
//            immigrantNameLabel.getText(),
//            Integer.parseInt(immigrantIDLabel.getText()),
//            Integer.parseInt(formIDLabel.getText()),
//            formDescriptionLabel.getText(),
//            Integer.parseInt(reviewerIDField.getText()),
//            birthCountryField.getText(),
//            dateOfBirthField.getText(),
//            dateOfDeathField.getText()
//    );
}