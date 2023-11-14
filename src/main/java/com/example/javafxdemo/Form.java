package com.example.javafxdemo;

public class Form {

    /**
     * Attributes for Form.
     */
    private int formID;
    private String formName;
    private String formDescription;

    /**
     * Initializing all parameters.
     * @param formID for input.
     * @param formName for input.
     * @param formDescription for input.
     */
    public Form(int formID, String formName, String formDescription) {

        this.formID = formID;

        this.formName = formName;

        this.formDescription = formDescription;

    }
    public Form() {

    }

    /**
     * Getter for testing purposes.
     * @return formID for output.
     */
    public int getFormID() {

        return (formID);

    }

    /**
     * Getter for testing purposes.
     * @return formName for output.
     */
    public String getFormName() {

        return (formName);

    }

    /**
     * Getter for testing purposes.
     * @return formDescription for output.
     */
    public String getFormDescription() {

        return (formDescription);

    }

}
