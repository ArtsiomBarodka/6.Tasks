/*
 * 6.tasks
 * Task 1
 * Artsiom Barodka
 *
 */
package tasks.task1.handler;

import tasks.task1.handler.Mail.MailSender;
import tasks.task1.model.ModelService;
import tasks.task1.model.Person;
import tasks.task1.properties.Constants;
import tasks.task1.properties.Role;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

public class PersonMenuHandler implements MailSender {

    private ModelService modelService;

    public PersonMenuHandler() {
        modelService = new ModelService();
    }

    @Override
    public void sendMail(String ...s){
        String to = getAdminEMail();
        String from = getPersonEMail(s[0]);
        String host = Constants.HOST;
        s[0] = "";
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        Session session = Session.getDefaultInstance(properties);
        try {
            MimeMessage message = new MimeMessage(session); // email message
            message.setFrom(new InternetAddress(from)); // setting header fields
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("New Book!"); // subject line
            // actual mail body
            message.setText(Arrays.toString(s));
            // Send message
            Transport.send(message);
            System.out.println("Email Sent successfully....");
        } catch(MessagingException mex){
            mex.printStackTrace();
        }
    }

    private String getPersonEMail(String id){
        int personId = Integer.parseInt(id);
        ArrayList<Person> people = modelService.getPeople();
        for (Person p:people) {
            if(p.getId() == personId){
                return p.getMail();
            }
        }
        return "";
    }

    private String getAdminEMail(){
        ArrayList<Person> people = modelService.getPeople();
        for (Person p:people) {
            if(p.getRole().equals(Role.ADMIN)){
                return p.getMail();
            }
        }
        return "";
    }
}
