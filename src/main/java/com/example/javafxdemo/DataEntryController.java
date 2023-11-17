package com.example.javafxdemo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class DataEntryController {
    // Define form fields for data entry here

    // Example Form Field
    // Made possible by this line in data-entry.fxml: <TextField fx:id="exampleTextField" promptText="This is example text field" />
    // "fx:id" must match this variable

    @FXML private TextField citizenNameField;
    @FXML private TextField citizenIDField;
    @FXML private TextField immigrantNameField;
    @FXML private TextField immigrantIDField;
    @FXML private TextField formIDField;
    @FXML private TextField formDescriptionField;
    @FXML private Label errorMessageLabel;



    private GeneaologyRequest request;
    // empty constructor is required

    public DataEntryController() {}

    // Constructor to set value for business object.
    public DataEntryController(GeneaologyRequest request) {
        this.request = request;
    }

    // initialize() function is automatically called upon creation of controller. (May not need it)
    public void initialize() {
        errorMessageLabel.setText("");

        if (request != null) {
            citizenNameField.setText(request.getCitizenName());
            citizenIDField.setText(String.valueOf(request.getCitizenId()));
            immigrantNameField.setText(request.getImmigrantName());
            immigrantIDField.setText(String.valueOf(request.getImmigrantId()));
            formIDField.setText(String.valueOf(request.getFormId()));
            formDescriptionField.setText(request.getFormDescription());
        }
    }

    // Function to demonstrate how to read inputted text into the example text field when button is pressed.
    // Made possible by this line in data-entry.fxml: <Button text="Print example text field to terminal" onAction="#printExampleTextField" />
    // "onAction" must match this function name
    //public void printExampleTextField() {
    // read inputted text
    //  String value = exampleTextField.getText();
    // System.out.println(value);
    //}

    // Called when button to switch to review screen is pressed.
    // May need to do additional things to pass data entered in data entry screen to the review screen.
    public void switchToReviewScreen(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("review.fxml"));
        Parent reviewView = loader.load();
        // Pass data here.
        // Multiple ways to pass data to Review screen:
        // 1. Calling a function defined in ReviewController:
        //        // Get the controller instance
        //        ReviewController reviewController = loader.getController();
        // Set all data and save all data from data-entry screen
        String citizenName = citizenNameField.getText();

        String citizenID = citizenIDField.getText();

        String immigrantID = immigrantIDField.getText();

        String formID = formIDField.getText();

        String formDescription = formDescriptionField.getText();

        String immigrantName = immigrantNameField.getText();

        ReviewController reviewController = loader.getController();

//        //Set up data for the review portion
//        reviewController.setCitizenName(citizenName);
//        reviewController.setCitizenID(citizenID);
//        reviewController.setImmigrantID(immigrantID);
//        reviewController.setImmigrantName(immigrantName);
//        reviewController.setFormID(formID);
//        reviewController.setFormDescription(formDescription);
        //Basic validation that all fields are filled, will not continue to review if missing data
        if (citizenName.isEmpty() || citizenID.isEmpty() || immigrantID.isEmpty() || formID.isEmpty() ||formDescription.isEmpty()|| immigrantName.isEmpty()) {
            errorMessageLabel.setText("Error: Please ensure all fields are filled");
        } else {
            errorMessageLabel.setText("");
            GeneaologyRequest passedRequest = new GeneaologyRequest(
                    citizenNameField.getText(),
                    Integer.parseInt(citizenIDField.getText()),
                    immigrantNameField.getText(),
                    Integer.parseInt(immigrantIDField.getText()),
                    Integer.parseInt(formIDField.getText()),
                    formDescriptionField.getText()
            );
            WorkflowItem workflowItem = new WorkflowItem("review", passedRequest);
            workflowItem.loadNextScreen(actionEvent);
            //
            //        // Pass data to the second controller by calling function defined in ReviewController
            //        reviewController.setImmigrantId("example");
            // 2. If ReviewController has business object defined in its class and an initialize() function which sets its fields based on the passed object
            //          -see how data is passed from Review screen to Approval screen

            // new scene for Review screen
//            Scene secondScene = new Scene(reviewView, 720, 720);
//            // Get the stage from the current button
//            Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
//            // Change title
//            currentStage.setTitle("Review");
//            // Set the new scene
//            currentStage.setScene(secondScene);
        }
    }
}