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

        MimeMessage msg = new MimeMessage(session);
        try {
            msg.setFrom(new InternetAddress(fromEmail));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            msg.setSubject("Kaip apsisaugoti nuo COVID - 19 ?");
            msg.setText("Kad apsaugotumėte save ir aplinkinius asmenis, žinokite faktus ir taikykite tinkamas atsargumo priemones. Vadovaukitės vietos sveikatos institucijos pateiktomis rekomendacijomis.\n" +
                    "Kad išvengtumėte COVID-19 plitimo:\n" +
                    "Dažnai plaukite rankas. Naudokite muilą ir vandenį arba alkoholinį skystį rankoms.\n" +
                    "Laikykitės saugiu atstumu nuo kosinčio ar čiaudinčio asmens.\n" +
                    "Jei laikytis fizinio atstumo neįmanoma, dėvėkite kaukę.\n" +
                    "Nelieskite akių, nosies ar burnos.\n" +
                    "Kosėdami ar čiaudėdami nosį ir burną pridenkite sulenkta alkūne arba audiniu.\n" +
                    "Jei jaučiatės prastai, likite namuose.\n" +
                    "Jeigu pasireiškė karščiavimas, kosulys, tapo sunku kvėpuoti, kreipkitės medicininės pagalbos.\n" +
                    "Jei skambinsite kuo skubiau, sveikatos apsaugos tarnyba galės greitai nukreipti jus į tinkamą sveikatos įstaigą. Tai padės jus apsaugoti ir išvengti virusų ir kitų infekcijų plitimo.\n" +
                    "Kaukės\n" +
                    "Kaukės jas dėvintiems asmenims gali padėti išvengti viruso perdavimo kitiems asmenims. Kaukės neapsaugo nuo COVID-19, dėvint kaukes būtina laikytis fizinio atstumo ir plauti rankas. Vadovaukitės vietos sveikatos institucijos pateiktomis rekomendacijomis.");

            Transport.send(msg);
            System.out.println("\nMessage Sent !");
        } catch (MessagingException e) {
            e.printStackTrace();

        }

    }
}
