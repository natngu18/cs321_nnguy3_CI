package com.example.javafxdemo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

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
     * These are boolean flags to ensure the buttons for the next step do not execute if
     * the current step gives an invalid output.
     */
    private boolean supplementalCheckPassed = false;

    private boolean dataValidationPassed = false;

    private boolean updateSuccessful = false;


    /**
     * This variable is used for storing the current form details and edits
     * made from the Reviewer.
     */
    private String updatedForm = "";


    // empty constructor is required
    public ReviewController() { }
    private GeneaologyRequest request;


    // Constructor to set value for business object.
    public ReviewController(GeneaologyRequest request) {
        this.request = request;
    }
    // initialize() function is automatically called upon creation of controller. (May not need it)
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

        //Valid input only if both IDs are at least 6 characters
        if (immigrantIDLabel.getText().length() >= 6 && formIDLabel.getText().length() >= 6) {

            //Enable next button on screen to execute
            supplementalCheckPassed = true;

            System.out.println("Yes, data entry is valid");

        } else {

            //Since current step failed, next button should not execute
            supplementalCheckPassed = false;

            System.out.println("Supplemental checks are not passed due to invalid Form ID or Immigrant ID, please go back to data entry");

        }

    }

    /**
     * This method will display the current form data which was inputted in the data-entry screen.
     */
    public void displayCurrentFormData() {

        //boolean check to make sure next button is not executed if current step is invalid
        if (!supplementalCheckPassed) {

            System.out.println("Cannot display form data: Supplemental checks have not been passed.");

            return;
        }

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

        //boolean check
        if (!supplementalCheckPassed) {

            System.out.println("Cannot save edits: Supplemental checks have not been passed.");

            return;

        }

        updateFormString();

        System.out.println("Edits made from Reviewer are saved");

    }

    /**
     * This method validates the Reviewer's edits.
     */
    public void validateData() {

        //boolean check
        if (!supplementalCheckPassed) {

            System.out.println("Cannot validate data: Supplemental checks have not been passed.");

            return;

        }

        //All three fields must not be empty in order for the edits to be valid.
        if (!birthCountryField.getText().isEmpty() && !dateOfBirthField.getText().isEmpty() && !dateOfDeathField.getText().isEmpty()) {

            dataValidationPassed = true;

            System.out.println("Data is valid");

        } else {

            dataValidationPassed = false;

            //At least one of the Reviewer's edits is empty
            System.out.println("Data Validation failed, please correct edits");

        }

    }

    /**
     * This method will display the fully edited form.
     */
    public void displayEditedForm() {

        //boolean check
        if (!supplementalCheckPassed || !dataValidationPassed) {

            System.out.println("Cannot display edited form: Required checks have not been passed.");

            return;

        }

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

        //boolean checks
        if (!supplementalCheckPassed || !dataValidationPassed) {

            System.out.println("Cannot update data: Required checks have not been passed.");

            return;

        }

        System.out.println("Review has been finalized and Workflow table is updated with edited form for Immigrant:" + immigrantNameLabel.getText() + " from the Requester:" + citizenNameLabel.getText());

        //becomes true since update was successful, so we can now switch to approval screen
        updateSuccessful = true;

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
        WorkflowItem workflowItem = new WorkflowItem("data-entry", this.request);
        workflowItem.loadFXML(actionEvent);
    }

    // Called when button to switch to approval screen is pressed.
    public void switchToApprovalScreen(ActionEvent actionEvent) throws IOException {

        // This is the Request Business Object passed to Approval Screen, so that the form fields will be pre-populated in the approval screen.
        // Would need to construct the object based on inputted form fields in this Review screen

        //Disables user to go to approval screen due to invalid updates.
        if (!updateSuccessful) {

            System.out.println("Cannot switch to Approval Screen: Update has not been successful.");

            return;

        }

        //This gets printed when the Reviewer clicks the go to approval button.
        System.out.println("Request is now sent to Approval");

        GeneaologyRequest passedRequest = new GeneaologyRequest(
            citizenNameLabel.getText(),
            Integer.parseInt(citizenIDLabel.getText()),
            immigrantNameLabel.getText(),
            Integer.parseInt(immigrantIDLabel.getText()),
            Integer.parseInt(formIDLabel.getText()),
            formDescriptionLabel.getText(),
            Integer.parseInt(reviewerIDField.getText()),
            birthCountryField.getText(),
            dateOfBirthField.getText(),
            dateOfDeathField.getText()
        );

        WorkflowItem workflowItem = new WorkflowItem("approval", passedRequest);
        workflowItem.loadFXML(actionEvent);
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