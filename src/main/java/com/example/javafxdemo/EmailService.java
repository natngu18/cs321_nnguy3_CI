package com.example.javafxdemo;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailService {

    private String fromEmail;
    private String password;
    private String host;
    private String port;
    private Properties properties;
    private Session session;

    public EmailService(String host, String port) {
        this.fromEmail = System.getenv("EMAIL_USER");
        // App Password
        this.password = "jefs ozwq kkqx uhub";
        this.host = host;
        this.port = port;

        // Set up mail server properties
        properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Create a session with authentication
        session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });
    }
    public static boolean isValidEmail(String email) {
        // Regular expression for email pattern validation
        String emailPattern = "^[\\w.-]+@[a-zA-Z]+(\\.[a-zA-Z]{2,3}){1,2}$";
        return email.matches(emailPattern);
    }


    public boolean sendEmail(String toEmail, String subject, String content) {
        if (!isValidEmail(toEmail)) {
            return false;
        }
        try {
            MimeMessage message = new MimeMessage(session);
            // Set from email
            message.setFrom(new InternetAddress(fromEmail));

            // Set recipient
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

            // Set Subject
            message.setSubject(subject);

            // Set message
            message.setText(content);

            // Send message
            Transport.send(message);
            System.out.println("Email sent successfully to " + toEmail);
            return true;
        } catch (MessagingException mex) {
            mex.printStackTrace();
            return false;
        }
    }


}