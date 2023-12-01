package com.example.javafxdemo;

import javafx.event.ActionEvent;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class WorkflowItemTest {

    @Test
    public void loadNextScreen_InvalidStep_ShouldThrowIllegalStateException() {
        // Create a WorkflowItem instance with an invalid step.
        // The only valid steps are "review", "approval" and "data-entry"
        WorkflowItem workflowItem = new WorkflowItem("invalidStep", new GeneaologyRequest());

        // mock ActionEvent
        ActionEvent actionEvent = new ActionEvent();

        // Verify that an IllegalStateException is thrown when an invalid step is provided
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            workflowItem.loadNextScreen(actionEvent);
        });

        // Verify the exception message, which indicates that error was directly thrown.
        String expectedMessage = "Invalid step provided in GeneaologyRequest object.";
        assertEquals(expectedMessage, exception.getMessage());
    }

}