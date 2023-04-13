package com.sacral.test333.controller;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sacral.test333.model.MailServiceModel;
import com.sacral.test333.service.ForgetPasswordServiceImplService;
import com.sacral.test333.service.MailService;

@RestController
@RequestMapping("/api/v1/mail")
public class MailServiceController {

    @Autowired
    private MailService mailService;
    @Autowired
    private ForgetPasswordServiceImplService forgetPasswordServiceImplService;

    @PostMapping
    public MimeMessage sendMail(@RequestBody MailServiceModel mailServiceModel) {
        MimeMessage mimeMessage = mailService.createMessage(mailServiceModel.getSender(), mailServiceModel.getRecipients()[0], mailServiceModel.getSubject(), mailServiceModel.getBody());
        mimeMessage = mailService.attachFile(mailServiceModel.getFilePath());
        mimeMessage = mailService.addRecipients(mailServiceModel.getRecipients(), mailServiceModel.getCc(), mailServiceModel.getBcc());
        return mimeMessage;
    }

    @PostMapping("/forgetPassword")
    public ForgetPasswordServiceImpl findUser(@RequestBody String username) {
        return forgetPasswordServiceImplService.findByUsername(username);
    }

}