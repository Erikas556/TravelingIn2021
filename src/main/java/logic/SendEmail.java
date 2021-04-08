package logic;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmail {

    public static void sendEmail (String email){

        final String username = "javaTest556@gmail.com";
        final String password = "Test556@";
        String fromEmail = "javaTest556@gmail.com";
        String toEmail = email;

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        //Start our mail message
        MimeMessage msg = new MimeMessage(session);
        try {
            msg.setFrom(new InternetAddress(fromEmail));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            msg.setSubject("Subject Line");
            msg.setText("Nu jeigu paejo tai buk mielas ir apsidovanuok save vienu dideliu ir saltu alaus ;) ");

            Transport.send(msg);
            System.out.println("Message Sent !");
        } catch (MessagingException e) {
            e.printStackTrace();

        }

    }
}
