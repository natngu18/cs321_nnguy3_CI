package com.example.javafxdemo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class ApprovalController {
    @FXML
    private TextField immigrantId;
    @FXML
    private TextField requesterName;
    @FXML
    private TextField requesterEmail;
    // Business Object passed to Controller.
    private GeneaologyRequestApproval request;
    // multi-select menu for forms
    @FXML
    private ListView<String> multiSelectFormList;
    public ApprovalController(GeneaologyRequestApproval request) {
        this.request = request;
    }
    public void initialize() {
        // Pre-populate the form fields based on the Business object
        if (request != null) {
            immigrantId.setText(String.valueOf(request.getImmigrantId()));
            requesterName.setText(String.valueOf(request.getRequester().getName()));
            requesterEmail.setText(String.valueOf(request.getRequester().getEmail()));
        }
        // TODO: populate selected forms.
        // Set selection mode to multiple (need to ctrl+click to select multiple)
        multiSelectFormList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        // This list should be populated with all possible forms
        ObservableList<String> forms = FXCollections.observableArrayList("Form 1", "Form 2", "Form 3");
        multiSelectFormList.setItems(forms);
    }

    public void submitButtonAction() throws IOException {
        // Approval doesn't have to do verification checks.

        ObservableList<String> selectedForms = multiSelectFormList.getSelectionModel().getSelectedItems();
        // Process the selected forms
        for (String item : selectedForms) {
            System.out.println("Selected form: " + item);
            // TODO: Would need to find these forms for the immigrant with "immigrantId" in database (in-memory database).
        }

        // Get the text from the TextField components
        String immigrantIdValue = immigrantId.getText();
        String requesterNameValue = requesterName.getText();
        String requesterEmailValue = requesterEmail.getText();

        // Process entered form fields:
        System.out.println("Immigrant ID: " + immigrantIdValue);
        System.out.println("Requester Name: " + requesterNameValue);
        System.out.println("Requester Email: " + requesterEmailValue);

        // TODO: Send email of requested forms..

        // Display confirmation alert.
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Your request was successful.");
        alert.setHeaderText(null);
        alert.setContentText("Submit successful!");
        alert.showAndWait();

        // Load the second GUI FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SecondView.fxml"));
        Parent secondView = loader.load();

        // Get the controller instance
        SecondController secondController = loader.getController();

        // Pass data to the second controller
        secondController.setImmigrantId("Hello from the first view!");

        // Create a new scene with the second GUI
        Scene secondScene = new Scene(secondView);
        // Get the stage from the current button
        Stage currentStage = (Stage) multiSelectFormList.getScene().getWindow();
        // Set the new scene
        currentStage.setScene(secondScene);

        // TODO: This works. Now set up controllers for Data Entry and Edit. Approval should not be able to edit.
        // TODO: Check if this works on VS code on my laptop
    }

    public void cancelButtonAction() {
        // TODO: Edit/Cancel Button, should go back to edit screen.
    }

}