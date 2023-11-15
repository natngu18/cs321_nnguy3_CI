package com.example.javafxdemo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class ReviewController {
    // Define form fields for review screen here

    // Example Form Field
    // Made possible by this line in review.fxml: <TextField fx:id="exampleTextField" promptText="This is example text field" />
    // "fx:id" must match this variable
    @FXML
    private TextField exampleTextField;

    // empty constructor is required
    public ReviewController() { }

    // initialize() function is automatically called upon creation of controller. (May not need it)
    public void initialize() { }


    // Function to demonstrate how to read inputted text into the example text field when button is pressed.
    // Made possible by this line in review.fxml: <Button text="Print example text field to terminal" onAction="#printExampleTextField" />
    // "onAction" must match this function name
    public void printExampleTextField() {
        // read inputted text
        String value = exampleTextField.getText();
        System.out.println(value);
    }

    // May not need to go back to data entry screen, idk
    // Called when button to switch to data entry screen is pressed.
    // May need to do additional things to pass data entered in review screen back to the data-entry screen.
    public void switchToDataEntryScreen(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("data-entry.fxml"));
        Parent reviewView = loader.load();

        // Pass data here.
        // Multiple ways to pass data to Data-entry screen:
        // 1. Calling a function defined in DataEntryController:
        //        // Get the controller instance
        //        DataEntryController controller = loader.getController();
        //
        //        // Pass data to the second controller by calling function defined in DataEntryController
        //        controller.setImmigrantId("example");
        // 2. If DataEntryController has business object defined in its class and an initialize() function which sets its fields based on the passed object
        //          -see how data is passed from Review screen to Approval screen below

        // new scene for Data Entry screen
        Scene secondScene = new Scene(reviewView, 720, 720);
        // Get the stage from the current button
        Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        // Change title
        currentStage.setTitle("Data Entry");
        // Set the new scene
        currentStage.setScene(secondScene);
    }

    // Called when button to switch to approval screen is pressed.
    public void switchToApprovalScreen(ActionEvent actionEvent) throws IOException {

        // This is the Request Business Object passed to Approval Screen, so that the form fields will be pre-populated in the approval screen.
        // Would need to construct the object based on inputted form fields in this Review screen
        GeneaologyRequestApproval passedRequest = new GeneaologyRequestApproval(123, new Citizen(1,
                "John Doe",
                "johndoe@gmail.com"),
                List.of(new Form(51, "Form 1", "This is a test")),
                "Pending",
                124124 );

        FXMLLoader loader = new FXMLLoader(getClass().getResource("approval.fxml"));

        // passing business object created above to ApprovalController/ approval screen
        loader.setControllerFactory(param -> new ApprovalController(passedRequest));

        Parent reviewView = loader.load();
        // new scene for Approval screen
        Scene secondScene = new Scene(reviewView, 720, 720);
        // Get the stage from the current button
        Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        // Change title
        currentStage.setTitle("Approval");
        // Set the new scene
        currentStage.setScene(secondScene);
    }
}
