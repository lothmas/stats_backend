package com.iqa.utilities;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


import com.sun.mail.smtp.SMTPMessage;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmailMessages {
    public void sendMessage(String toEmail,String candidateId,String institute) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "805");

        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("lothmasmaparura@gmail.com", "siuolsiuol");
            }
        });

        try {

            SMTPMessage message = new SMTPMessage(session);
            message.setFrom(new InternetAddress("verification@everify.org.zw"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("lothmasmaparura@gmail.com"));

            message.setSubject("E-Verify Verification Notice");
            message.setText("Your Verification Request for Candidate: "+candidateId +"   Institute: "+institute +" has been resolved");
//                message.setContent("This Is my First Mail Through Java");
            message.setNotifyOptions(SMTPMessage.NOTIFY_SUCCESS);
            int returnOption = message.getReturnOption();
            System.out.println(returnOption);
            Transport.send(message);
            System.out.println("sent");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}