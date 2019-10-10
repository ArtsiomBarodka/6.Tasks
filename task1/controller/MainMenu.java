/*
 * 6.tasks
 * Task 1
 * Artsiom Barodka
 *
 */
package tasks.task1.controller;

import tasks.task1.handler.MainMenuHandler;
import java.io.BufferedReader;
import java.io.IOException;

public class MainMenu implements Menu {

    private boolean isNotExit;
    private MainMenuHandler handler;
    private BufferedReader reader;

    public MainMenu(BufferedReader reader) {
        isNotExit = true;
        handler = new MainMenuHandler();
        this.reader = reader;
    }

    public void run() throws IOException {
        while (isNotExit){
            printMenu();
            String choice = reader.readLine();
            switch (choice){
                case "0":
                    isNotExit = false;
                    break;

                case "1":
                    System.out.println("Введите имя пользователя");
                    String name = reader.readLine();
                    String password;
                    do {
                        System.out.println("Введите пароль");
                        password = reader.readLine();
                    } while (!isNumeric(password));
                    if(handler.checkAccount(name,password)){
                        int id = handler.getPersonId(name,password);
                        Menu menu = handler.checkAdmin(name,password)?
                                new AdminMenu(reader): new PersonMenu(reader,id);
                        menu.run();
                    } else {
                        System.out.println("Неверные данные");
                    }
                    break;

                case "2":
                    do {
                        System.out.println("Введите имя");
                        name = reader.readLine();
                    } while (handler.checkName(name));
                    do {
                        System.out.println("Введите пароль");
                        password = reader.readLine();
                    } while (!isNumeric(password)
                                &&!handler.checkPassword(password));
                    String mail;
                    do {
                        System.out.println("Введите mail");
                        mail = reader.readLine();
                    } while (!handler.checkMail(mail));
                    handler.createPerson(name,password,mail);
                    break;
            }
        }
    }

    private boolean isNumeric(String string) {
        if (string == null) return false;
        return string.matches("^-?\\d+$");
    }

    public void printMenu(){
        System.out.println("0 - Выход");
        System.out.println("1 - Войти");
        System.out.println("2 - Зарегистрироваться");
    }
}
