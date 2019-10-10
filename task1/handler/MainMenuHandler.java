/*
 * 6.tasks
 * Task 1
 * Artsiom Barodka
 *
 */
package tasks.task1.handler;

import tasks.task1.model.ModelService;
import tasks.task1.model.Person;
import tasks.task1.properties.Role;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainMenuHandler {

    private ModelService modelService;
    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                    "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final int NUM_PASSWORD = 6;


    public MainMenuHandler() {
        modelService = new ModelService();
    }

    public boolean checkName(String name){
        ArrayList<Person> people = modelService.getPeople();
        for (Person p:people) {
            if (p.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    public boolean checkAccount(String name, String pass){
        ArrayList<Person> people = modelService.getPeople();
        for (Person p:people) {
            if(p.getName().equals(name)&&
                    p.getPassword() == Integer.parseInt(pass)){
                return true;
            }
        }
        return false;
    }

    public boolean checkPassword(String password){
        return password.length() <= NUM_PASSWORD;
    }

    public boolean checkMail(String mail){
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(mail);
        return matcher.matches();
    }

    public boolean checkAdmin(String name, String pass){
        ArrayList<Person> people = modelService.getPeople();
        for (Person p:people) {
            if(p.getName().equals(name)&&
                    p.getPassword() == Integer.parseInt(pass)){
                if(p.getRole().equals(Role.ADMIN)){
                    return true;
                }
            }
        }
        return false;
    }

    public void createPerson(String name, String password, String mail){
        int pass = Integer.parseInt(password);
        modelService.createPerson(name,pass,mail);
    }

    public int getPersonId(String name, String pass){
        ArrayList<Person> people = modelService.getPeople();
        for (Person p:people) {
            if(p.getName().equals(name)&&
                    p.getPassword() == Integer.parseInt(pass)){
                return p.getId();
            }
        }
        return -1;
    }
}
