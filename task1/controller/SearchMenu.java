/*
 * 6.tasks
 * Task 1
 * Artsiom Barodka
 *
 */
package tasks.task1.controller;

import tasks.task1.handler.SearchMenuHandler;
import java.io.BufferedReader;
import java.io.IOException;

public class SearchMenu implements Menu{

    private boolean isNotExit;
    private SearchMenuHandler handler;
    private BufferedReader reader;

    SearchMenu(BufferedReader reader) {
        isNotExit = true;
        handler = new SearchMenuHandler();
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
                    handler.searchBooksByTitle(title);
                    printByPage(reader);
                    break;

                case "2":
                    System.out.println("Введите имя автора книги");
                    String author = reader.readLine();
                    handler.searchBooksByAuthor(author);
                    printByPage(reader);
                    break;

                case "3":
                    System.out.println("Введите издателя книги");
                    String publisher = reader.readLine();
                    handler.searchBooksByPublisher(publisher);
                    printByPage(reader);
                    break;

                case "4":
                    String minYear;
                    do {
                        System.out.println("Введите минимальный год издания книг");
                        minYear = reader.readLine();
                    } while (!isNumeric(minYear));
                    String maxYear;
                    do {
                        System.out.println("Введите максимальный год издания книг");
                        maxYear = reader.readLine();
                    } while (!isNumeric(maxYear));
                    handler.searchBooksByYear(minYear,maxYear);
                    printByPage(reader);
                    break;

                case "5":
                    String minNumPage;
                    do {
                        System.out.println("Введите минимальное количество страниц книг");
                        minNumPage = reader.readLine();
                    } while (!isNumeric(minNumPage));
                    String maxNumPage;
                    do {
                        System.out.println("Введите максимальное количество страниц книг");
                        maxNumPage = reader.readLine();
                    } while (!isNumeric(maxNumPage));
                    handler.searchBooksByNumPage(minNumPage,maxNumPage);
                    printByPage(reader);
                    break;

                case "6":
                    String minPrice;
                    do {
                        System.out.println("Введите минимальную цену книг");
                        minPrice = reader.readLine();
                    } while (!isNumeric(minPrice));
                    String maxPrice;
                    do {
                        System.out.println("Введите максимальную цену книг");
                        maxPrice = reader.readLine();
                    } while (!isNumeric(maxPrice));
                    handler.searchBooksByPrice(minPrice,maxPrice);
                    printByPage(reader);
                    break;
            }
        }
    }

    @Override
    public void printMenu() {
        System.out.println("0 - Выход в пользовательское меню");
        System.out.println("1 - Поиск книг по названию");
        System.out.println("2 - Поиск книг по автору");
        System.out.println("3 - Поиск книг по издателю");
        System.out.println("4 - Поиск книг по году издания");
        System.out.println("5 - Поиск книг по количеству страниц");
        System.out.println("6 - Поиск книг по цене");
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
            handler.searchBooksByPage(page);
        }
    }

    private boolean isNumeric(String string) {
        if (string == null) return false;
        return string.matches("^-?\\d+$");
    }
}
