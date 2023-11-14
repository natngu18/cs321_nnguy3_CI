package com.example.javafxdemo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.List;

public class GeneaologyRequestApproval {
    private int requestId;
    private Citizen requester;
    private List<Form> requestedForms;
    private String status = "Pending";
    private int immigrantId;

    public GeneaologyRequestApproval() {
    }
    public GeneaologyRequestApproval(int requestId, Citizen requester, List<Form> requestedForms, String status, int immigrantId) {
        this.requestId = requestId;
        this.requestedForms = requestedForms;
        this.status = status;
        this.immigrantId = immigrantId;
        this.requester = requester;
    }
    public Citizen getRequester(){
        return requester;
    }
    public int getRequestId() {
        return requestId;
    }
    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }
    public List<Form> getRequestedForms() {
        return requestedForms;
    }
    public void setRequestedForms(List<Form> requestedForms) {
        this.requestedForms = requestedForms;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public int getImmigrantId() {
        return immigrantId;
    }
    public void setImmigrantId(int immigrantId) {
        this.immigrantId = immigrantId;
    }

    public void submitRequest() {
        // this.status = "Submitted";
    }

    public void cancelRequest() {
        // this.status = "Canceled";
        // send back to reviewer
    }

    // Used to access database to retrieve forms with matching ids.
    public List<Form> findFormsByIds(List<Integer> listOfFormIds) {
        return List.of(new Form(1, "test", "test"));
    }

    // Used to access database to retrieve immigrant with matching id.


}
