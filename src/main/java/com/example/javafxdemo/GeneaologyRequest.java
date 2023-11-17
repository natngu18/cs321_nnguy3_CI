package com.example.javafxdemo;

import java.util.List;

public class GeneaologyRequest {

    public GeneaologyRequest(String citizenName, int citizenId, String immigrantName, int immigrantId, int formId, String formDescription, int reviewerId, String birthCountry, String dateOfBirth, String dateOfDeath) {
        this.citizenName = citizenName;
        this.citizenId = citizenId;
        this.immigrantName = immigrantName;
        this.immigrantId = immigrantId;
        this.formId = formId;
        this.formDescription = formDescription;
        this.reviewerId = reviewerId;
        this.birthCountry = birthCountry;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
    }

    public GeneaologyRequest(String citizenName, int citizenId, String immigrantName, int immigrantId, int formId, String formDescription) {
        this.citizenName = citizenName;
        this.citizenId = citizenId;
        this.immigrantName = immigrantName;
        this.immigrantId = immigrantId;
        this.formId = formId;
        this.formDescription = formDescription;

    }

    private String citizenName;



    private int citizenId;
    private String immigrantName;
    private int immigrantId;
    private int formId;
    private String formDescription;
    private int reviewerId;
    private String birthCountry;
    private String dateOfBirth;
    private String dateOfDeath;
    public int getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(int citizenId) {
        this.citizenId = citizenId;
    }
    public String getCitizenName() {
        return citizenName;
    }

    public void setCitizenName(String citizenName) {
        this.citizenName = citizenName;
    }

    public String getImmigrantName() {
        return immigrantName;
    }

    public void setImmigrantName(String immigrantName) {
        this.immigrantName = immigrantName;
    }

    public int getImmigrantId() {
        return immigrantId;
    }

    public void setImmigrantId(int immigrantId) {
        this.immigrantId = immigrantId;
    }

    public int getFormId() {
        return formId;
    }

    public void setFormId(int formId) {
        this.formId = formId;
    }

    public String getFormDescription() {
        return formDescription;
    }

    public void setFormDescription(String formDescription) {
        this.formDescription = formDescription;
    }

    public int getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(int reviewerId) {
        this.reviewerId = reviewerId;
    }

    public String getBirthCountry() {
        return birthCountry;
    }

    public void setBirthCountry(String birthCountry) {
        this.birthCountry = birthCountry;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(String dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public GeneaologyRequest() {
    }

    public void submitRequest() {
        // this.status = "Submitted";
    }

    public void sendEmail() {

    }
    public void cancelRequest() {
        // this.status = "Canceled";
        // send back to reviewer
    }

//    // Used to access database to retrieve forms with matching ids.
    public List<Form> findFormsByIds(List<Integer> listOfFormIds) {
        return List.of(new Form(1, "test", "test"));
    }

    // Used to access database to retrieve immigrant with matching id.


}
