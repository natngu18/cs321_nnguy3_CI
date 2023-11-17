package com.example.javafxdemo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
/**
 * This is how I will be implementing the Review process.
 * @author Aditi Reddy
 */

public class ReviewController {
    
    /**
     * All of these labels are received from the data given in the Data entry screen 
     * and their values are presented on the Review screen.
     */
    @FXML private Label citizenNameLabel; 
    
    @FXML private Label citizenIDLabel;   
    
    @FXML private Label immigrantNameLabel; 
    
    @FXML private Label immigrantIDLabel;   
    
    @FXML private Label formIDLabel;        
    
    @FXML private Label formDescriptionLabel; 


    /**
     * These variables are independent to the Review screen since their values 
     * will be inputted from only the Reviewer.
     */
    @FXML private TextField reviewerIDField;

    @FXML private TextField birthCountryField;

    @FXML private TextField dateOfBirthField;

    @FXML private TextField dateOfDeathField;

    /**
     * This variable is used for storing the current form details and edits
     * made from the Reviewer.
     */
    private String updatedForm = "";
    

    // empty constructor is required
    public ReviewController() { }

    // initialize() function is automatically called upon creation of controller. (May not need it)
    public void initialize() { }

    /**
     * Setter method for the citizenNameLabel data that was initially given in data entry.
     * @param name for input.
     */
    public void setCitizenName(String name) {
        
        citizenNameLabel.setText(name);
    
    }

    /**
     * Setter method for the citizenIDLabel data that was initially given in data entry.
     * @param id for input.
     */
    public void setCitizenID(String id) {
        
        citizenIDLabel.setText(id);
    
    }

    /**
     * Setter method for the immigrantNameLabel data that was initially given in data entry.
     * @param name for input.
     */
    public void setImmigrantName(String name) {
        
        //null check
        if (this.immigrantNameLabel != null) { 
            
            this.immigrantNameLabel.setText(name);
        
        }
    
    }

    /**
     * Setter method for the immigrantIDLabel data that was initially given in data entry.
     * @param id for input.
     */
    public void setImmigrantID(String id) {
        
        //null check
        if (this.immigrantIDLabel != null) {
            
            this.immigrantIDLabel.setText(id);
        
        }
    
    }
    
    /**
     * Setter method for the formIDLabel data that was initially given in data entry.
     * @param id for input.
     */
    public void setFormID(String id) {
        
        //null check
        if (this.formIDLabel != null) {
            
            formIDLabel.setText(id);
        
        }
    
    }

    /**
     * Setter method for the formDescriptionLabel data that was initially given in data entry.
     * @param description for input.
     */
    public void setFormDescription(String description) {
        
        //null check
        if (this.formDescriptionLabel != null) {
            
            formDescriptionLabel.setText(description);
        
        }
    
    }

    /**
     * This method represents the system doing supplemental checks on the data given in data-entry.
     */
    public void performSupplementalChecks() {
        
        //immigrant ID AND form ID must be at least 6 characters for a valid ID number.
        if (immigrantIDLabel.getText().length() >= 6 && formIDLabel.getText().length() >= 6) {
            
            System.out.println("Yes, data entry is valid");
        
        } else {
            
            //If one or both IDs are invalid, user must go back to the data-entry screen and input valid IDs
            System.out.println("Supplemental checks are not passed due to invalid Form ID or Immigrant ID, please go back to data entry");
        
        }
            
    }

    /**
     * This method will display the current form data which was inputted in the data-entry screen.
     */
    public void displayCurrentFormData() {
        
        System.out.println("Displaying current form data: ");
        
        //null checks

        if (this.immigrantNameLabel != null){
            
            System.out.println("Deceased person name: " + immigrantNameLabel.getText());
        
        }
        
        if (this.immigrantIDLabel != null) {
            
            System.out.println("Deceased immigrant’s ID: " + immigrantIDLabel.getText());
        
        }
        
        if (this.formIDLabel != null) {
            
            System.out.println("Deceased immigrant’s Form ID: " + formIDLabel.getText());
        
        }
        
        if (this.formDescriptionLabel != null) {
            
            System.out.println("Form Description: " + formDescriptionLabel.getText());
        
        }
    
    }

    /**
     * This method saves the additional fields that the Reviewer inputs into a variable.
     */
    public void saveEdits() {
        
        updateFormString();
        
        System.out.println("Edits made from Reviewer are saved");
    
    }

    /**
     * This method validates the Reviewer's edits.
     */
    public void validateData() {
        
        //All three fields must not be empty in order for the edits to be valid.
        if (!birthCountryField.getText().isEmpty() && !dateOfBirthField.getText().isEmpty() && !dateOfDeathField.getText().isEmpty()) {
            
            System.out.println("Data is valid");
        
        } else {
            
            //At least one of the Reviewer's edits is empty
            System.out.println("Data Validation failed, please correct edits");
        
        }
    
    }

    /**
     * This method will display the fully edited form.
     */
    public void displayEditedForm() {
        
        //Making sure valid edits were done by the Reviewer.
        if (updatedForm != null && !updatedForm.isEmpty()) {
            
            System.out.println("Displaying edited form data: ");
            
            System.out.println(updatedForm);
        
        } else {
            
            System.out.println("No edits have been made to display.");
        
        }
    
    }

    /**
     * This method prints a message to confirm that the review is updated and finalized.
     */
    public void updateData() {
        
        System.out.println("Review has been finalized and Workflow table is updated with edited form for Immigrant:" + immigrantNameLabel.getText() + " from the Requester:" + citizenNameLabel.getText());
    
    }

    // Function to demonstrate how to read inputted text into the example text field when button is pressed.
    // Made possible by this line in review.fxml: <Button text="Print example text field to terminal" onAction="#printExampleTextField" />
    // "onAction" must match this function name
    //public void printExampleTextField() {
        // read inputted text
        //String value = exampleTextField.getText();
       // System.out.println(value);
   // }

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
        
        //This gets printed when the Reviewer clicks the go to approval button.
        System.out.println("Request is now sent to Approval");

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

    /**
     * Helper for updating the form (updatedForm) when the edited form needs to be displayed.
     */
    private void updateFormString() {
        
        updatedForm = String.format(
            "Deceased person name: %s\n" +
            "Deceased immigrant’s ID: %s\n" +
            "Deceased immigrant’s Form ID: %s\n" +
            "Form Description: %s\n" +
            "Birth Country: %s\n" +
            "Date of birth: %s\n" +
            "Date of death: %s",
            immigrantNameLabel.getText(),
            immigrantIDLabel.getText(),
            formIDLabel.getText(),
            formDescriptionLabel.getText(),
            birthCountryField.getText(),
            dateOfBirthField.getText(),
            dateOfDeathField.getText()
        );
    
    }

}