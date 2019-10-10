/*
 * 6.tasks
 * Task 1
 * Artsiom Barodka
 *
 */
package tasks.task1.controller;

import tasks.task1.handler.PersonMenuHandler;
import java.io.BufferedReader;
import java.io.IOException;

public class PersonMenu implements Menu {

    private boolean isNotExit;
    private PersonMenuHandler handler;
    private BufferedReader reader;
    private int personId;

    PersonMenu(BufferedReader reader,int id) {
        isNotExit = true;
        handler = new PersonMenuHandler();
        this.reader = reader;
        personId = id;
    }

    @Override
    public void run() throws IOException {
        while (isNotExit){
            printMenu();
            String choice = reader.readLine();
            switch (choice){
                case "0":
                    isNotExit = false;
                    break;

                case "1":
                    Menu menu = new ViewMenu(reader);
                    menu.run();
                    break;

                case "2":
                    menu = new SearchMenu(reader);
                    menu.run();
                    break;

                case "3":
                    System.out.println("Введите название книги");
                    String title = reader.readLine();
                    System.out.println("Введите автора книги");
                    String author = reader.readLine();
                    System.out.println("Введите издателя книги");
                    String publisher = reader.readLine();
                    String year;
                    do {
                        System.out.println("Введите год книги");
                        year = reader.readLine();
                    } while (!isNumeric(year));
                        handler.sendMail(String.valueOf(personId),title,author,publisher,year);
                    break;
            }
        }
    }

    @Override
    public void printMenu() {
        System.out.println("0 - Выход в главное меню");
        System.out.println("1 - Просмотр книг в каталоге");
        System.out.println("2 - Поиск книг в каталоге");
        System.out.println("3 - Предложить книгу в каталог");
    }

    private boolean isNumeric(String string) {
        if (string == null) return false;
        return string.matches("^-?\\d+$");
    }
}
