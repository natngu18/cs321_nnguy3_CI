package com.example.javafxdemo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.List;

public class GeneaologyRequestApproval {

    public GeneaologyRequestApproval(String citizenName, int citizenId, String immigrantName, int immigrantId, int formId, String formDescription, int reviewerId, String birthCountry, String dateOfBirth, String dateOfDeath) {
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



//    private int requestId;
//    private Citizen requester;
//    private List<Form> requestedForms;
//    private String status = "Pending";
//    private int immigrantId;
//
    public GeneaologyRequestApproval() {
    }
//    public GeneaologyRequestApproval(int requestId, Citizen requester, List<Form> requestedForms, String status, int immigrantId) {
//        this.requestId = requestId;
//        this.requestedForms = requestedForms;
//        this.status = status;
//        this.immigrantId = immigrantId;
//        this.requester = requester;
//    }
//    public Citizen getRequester(){
//        return requester;
//    }
//    public int getRequestId() {
//        return requestId;
//    }
//    public void setRequestId(int requestId) {
//        this.requestId = requestId;
//    }
//    public List<Form> getRequestedForms() {
//        return requestedForms;
//    }
//    public void setRequestedForms(List<Form> requestedForms) {
//        this.requestedForms = requestedForms;
//    }
//    public String getStatus() {
//        return status;
//    }
//    public void setStatus(String status) {
//        this.status = status;
//    }
//    public int getImmigrantId() {
//        return immigrantId;
//    }
//    public void setImmigrantId(int immigrantId) {
//        this.immigrantId = immigrantId;
//    }
//
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
