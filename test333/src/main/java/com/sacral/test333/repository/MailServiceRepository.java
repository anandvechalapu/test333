package com.sacral.test333.repository;

import javax.mail.internet.MimeMessage;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MailServiceRepository extends JpaRepository<MimeMessage, String> {

    // Method to create a MimeMessage with the correct parameters such as the sender, the recipient(s), the subject, and the body
    MimeMessage createMessage(String sender, String recipient, String subject, String body);

    // Method to attach files if provided by the user
    MimeMessage attachFile(String filePath);

    // Method to handle exceptions and return the status of the email (success or failure)
    boolean handleException(Exception ex);

    // Method to handle multiple recipients and cc/bcc lists if provided by the user
    MimeMessage addRecipients(String[] recipients, String[] cc, String[] bcc);

}