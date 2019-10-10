/*
 * 6.tasks
 * Task 1
 * Artsiom Barodka
 *
 */
package tasks.task1.controller;

import tasks.task1.handler.AdminMenuHandler;
import java.io.BufferedReader;
import java.io.IOException;

public class AdminMenu implements Menu {

    private boolean isNotExit;
    private AdminMenuHandler handler;
    private BufferedReader reader;

    AdminMenu(BufferedReader reader) {
        isNotExit = true;
        handler = new AdminMenuHandler();
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
                    String numPage;
                    do {
                        System.out.println("Введите колличесво страниц в книге");
                        numPage = reader.readLine();
                    } while (!isNumeric(numPage));
                    String price;
                    do {
                        System.out.println("Введите цену книги");
                        price = reader.readLine();
                    } while (!isNumeric(price));
                    if(handler.createBook(title,author,publisher,year,numPage,price)){
                        handler.sendMail(title,author,publisher,year,numPage,price);
                        System.out.println("Книга добавлена в каталог");
                    } else {
                        System.out.println("Книга уже есть в каталоге");
                    }
                    break;

                case "2":
                    System.out.println("Введите название книги");
                    title = reader.readLine();
                    System.out.println("Введите автора книги");
                    author = reader.readLine();
                    if(handler.deleteBook(title,author)){
                        System.out.println("Книга удалена из каталога");
                    } else {
                        System.out.println("Такой книги нет в каталоге");
                    }
                    break;
            }
        }
    }

    @Override
    public void printMenu() {
        System.out.println("0 - Выход в главное меню");
        System.out.println("1 - Добавить книгу в библиотеку");
        System.out.println("2 - Убрать книгу из библиотеки");
    }

    private boolean isNumeric(String string) {
        if (string == null) return false;
        return string.matches("-?\\d+(\\.\\d+)?");
    }
}
