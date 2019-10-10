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
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

public class AdminMenuHandler implements MailSender {

    private ModelService modelService;

    public AdminMenuHandler() {
        modelService = new ModelService();
    }

    public boolean createBook(String title, String author, String publisher,
                           String year, String numPage, String price){
        int yearInt = Integer.parseInt(year);
        int numPageInt = Integer.parseInt(numPage);
        double priceDouble = Double.parseDouble(price);
        return modelService.createBook(title,author,publisher,
                yearInt,numPageInt,priceDouble);
    }

    public boolean deleteBook(String title, String author){
        return modelService.removeBook(title,author);
    }

    @Override
    public void sendMail(String... s) {
        String [] addresses = getAllEMail();
        String from = getAdminEMail();
        String host = Constants.HOST;
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        Session session = Session.getDefaultInstance(properties);
        try {
            MimeMessage message = new MimeMessage(session); // email message
            message.setFrom(new InternetAddress(from)); // setting header fields
            for (String address:addresses) {
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(address));
            }
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

    private String getAdminEMail(){
        ArrayList<Person>people = modelService.getPeople();
        for (Person p:people) {
            if(p.getRole().equals(Role.ADMIN)){
                return p.getMail();
            }
        }
        return "";
    }

    private String[] getAllEMail(){
        ArrayList<String>result = new ArrayList<>();
        ArrayList<Person>people = modelService.getPeople();
        for (Person p:people) {
            if(p.getRole().equals(Role.USER)){
                result.add(p.getMail());
            }
        }
        return result.toArray(new String[result.size()]);
    }
}
