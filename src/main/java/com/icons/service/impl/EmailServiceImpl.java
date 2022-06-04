
package com.icons.service.impl;

import com.icons.service.EmailService;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private Environment env;

    @Value("${com.icons.email.sender}")
    private String emailSender;

    @Value("${com.icons.email.enabled}")
    private boolean enabled;

    public void sendWelcomeEmailTo(String to) {
        if (!enabled) {
            return;
        }
        // String apiKey = env.getProperty("EMAIL_API_KEY");
        String apiKey = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";

        Email fromEmail = new Email(emailSender);
        Email toEmail = new Email(to);
        Content content = new Content(
                "text/plain",
                "Bienvenido/a a Icons Alkemy");
        String subject = "Semper Icons";

        Mail mail = new Mail(fromEmail, subject, toEmail, content);
        SendGrid sg = new SendGrid(apiKey);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
        } catch (IOException e) {
            System.out.println("Error trying to send the email");
        }
    }
}
