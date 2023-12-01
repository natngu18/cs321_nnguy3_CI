package com.example.javafxdemo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class ApprovalController {
    @FXML private Label recipientErrorLabel;
    @FXML private TextField recipientEmail;
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
        recipientEmail.setText("");
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
        // Then, we can send email with business object sendEmail function.
        String toEmail = recipientEmail.getText();
        if (!EmailService.isValidEmail(toEmail)) {
            // Invalid email format - show error message
            recipientErrorLabel.setText("Invalid email format.");
            return;
        }

        // remove error message if it exists.
        recipientErrorLabel.setText("");
        boolean emailSuccess = request.sendEmail(toEmail, "Geneaology Request", "hello");
        // Display confirmation alert if email succesful.

        // The sendEmail functoin can return true or false, we need to display notification accordingly.
        if (emailSuccess) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Submit succesful!");
            alert.setHeaderText(null);
            alert.setContentText("Email has been successfully sent to " + toEmail);
            alert.showAndWait();
        }

        else {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Something went wrong!");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Something went wrong in the attempt to send to " + toEmail);
            errorAlert.showAndWait();
        }

    }

    public void cancelButtonAction(ActionEvent actionEvent) throws IOException {
        WorkflowItem workflowItem = new WorkflowItem("review", this.request);
        workflowItem.loadNextScreen(actionEvent);
    }
}