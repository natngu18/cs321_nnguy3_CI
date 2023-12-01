package com.example.javafxdemo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailServiceTest {
    // these emails should be valid
    @Test
    public void testValidEmails() {
        assertTrue(EmailService.isValidEmail("example@example.com"));
        assertTrue(EmailService.isValidEmail("john.doe@example.co.uk"));
        assertTrue(EmailService.isValidEmail("info@domain.co.in"));
        assertTrue(EmailService.isValidEmail("user123@example.com"));
    }
    // these emails should be invalid
    @Test
    public void testInvalidEmails() {
        assertFalse(EmailService.isValidEmail("invalid-email.com"));
        assertFalse(EmailService.isValidEmail("invalid@-email.com"));
        assertFalse(EmailService.isValidEmail("invalid@.com"));
        assertFalse(EmailService.isValidEmail("invalid@domain"));
        assertFalse(EmailService.isValidEmail("invalid@domain."));
    }

    @Test
    public void sendEmail_ShouldFail_WhenInvalidToEmailProvided() {
        EmailService sender = new EmailService("smtp.gmail.com", "587");
        assertFalse(sender.sendEmail("123.", "This should be invalid", "Invalid to email"));
    }

    // sendEmail shoud pass if valid email provided, bar no error in gmail/ connection issues
    @Test
    public void sendEmail_ShouldPass_WhenValidToEmailProvided() {
        EmailService sender = new EmailService("smtp.gmail.com", "587");
        assertTrue(sender.sendEmail("natngu18@gmail.com", "This should valid", "valid to email"));
    }
}