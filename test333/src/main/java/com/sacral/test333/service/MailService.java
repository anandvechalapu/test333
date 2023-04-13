package com.sacral.test333.service;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sacral.test333.repository.MailServiceRepository;

@Service
public class MailService {

    @Autowired
    private MailServiceRepository mailServiceRepository;

    public MimeMessage createMessage(String sender, String recipient, String subject, String body) {
        return mailServiceRepository.createMessage(sender, recipient, subject, body);
    }

    public MimeMessage attachFile(String filePath) {
        return mailServiceRepository.attachFile(filePath);
    }

    public boolean handleException(Exception ex) {
        return mailServiceRepository.handleException(ex);
    }

    public MimeMessage addRecipients(String[] recipients, String[] cc, String[] bcc) {
        return mailServiceRepository.addRecipients(recipients, cc, bcc);
    }

}