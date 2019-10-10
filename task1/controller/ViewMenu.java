/*
 * 6.tasks
 * Task 1
 * Artsiom Barodka
 *
 */
package tasks.task1.controller;

import tasks.task1.handler.ViewMenuHandler;
import java.io.BufferedReader;
import java.io.IOException;

public class ViewMenu implements Menu {

    private boolean isNotExit;
    private ViewMenuHandler handler;
    private BufferedReader reader;

    ViewMenu(BufferedReader reader) {
        isNotExit = true;
        handler = new ViewMenuHandler();
        this.reader = reader;
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
                    handler.viewBooksByTitle();
                    printByPage(reader);
                    break;

                case "2":
                    handler.viewBooksByAuthor();
                    printByPage(reader);
                    break;

                case "3":
                    handler.viewBooksByPublisher();
                    printByPage(reader);
                    break;

                case "4":
                    handler.viewBooksByYear();
                    printByPage(reader);
                    break;

                case "5":
                    handler.viewBooksByNumPage();
                    printByPage(reader);
                    break;

                case "6":
                    handler.viewBooksByPrice();
                    printByPage(reader);
                    break;
            }
        }
    }

    @Override
    public void printMenu() {
        System.out.println("0 - Выход в пользовательское меню");
        System.out.println("1 - Показать книги отсортированные по названию");
        System.out.println("2 - Показать книги отсортированные по автору");
        System.out.println("3 - Показать книги отсортированные по издателю");
        System.out.println("4 - Показать книги отсортированные по году издания");
        System.out.println("5 - Показать книги отсортированные по количеству страниц");
        System.out.println("6 - Показать книги отсортированные по цене");
    }

    private void printByPage(BufferedReader reader) throws IOException {
        BufferedReader bufferedReader = reader;
        String pageChoice;
        long page;
        while (true){
            do {
                System.out.println("Введите страницу или 0 для выхода из просмотра");
                pageChoice = bufferedReader.readLine();
            } while (!isNumeric(pageChoice));
            page = Long.parseLong(pageChoice);
            if(page < 1){
                break;
            }
            handler.viewBooksByPage(page);
        }
    }

    private boolean isNumeric(String string) {
        if (string == null) return false;
        return string.matches("^-?\\d+$");
    }
}
