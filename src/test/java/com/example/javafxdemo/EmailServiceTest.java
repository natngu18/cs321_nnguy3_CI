package com.example.javafxdemo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailServiceTest {


    @Test
    public void testValidEmails() {
        assertTrue(EmailService.isValidEmail("example@example.com"));
        assertTrue(EmailService.isValidEmail("john.doe@example.co.uk"));
        assertTrue(EmailService.isValidEmail("info@domain.co.in"));
        assertTrue(EmailService.isValidEmail("user123@example.com"));
    }
    @Test
    public void testInvalidEmails() {
        assertFalse(EmailService.isValidEmail("invalid-email.com"));
        assertFalse(EmailService.isValidEmail("invalid@-email.com"));
        assertFalse(EmailService.isValidEmail("invalid@.com"));
        assertFalse(EmailService.isValidEmail("invalid@domain"));
        assertFalse(EmailService.isValidEmail("invalid@domain."));
    }
}