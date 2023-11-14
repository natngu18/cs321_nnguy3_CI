package com.example.javafxdemo;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SecondController {
    @FXML
    private TextField immigrantId;

    public void setImmigrantId(String data) {
        this.immigrantId.setText(data);
    }

    public SecondController() {

    }
}
