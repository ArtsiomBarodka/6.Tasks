/*
 * 6.tasks
 * Task 1
 * Artsiom Barodka
 *
 */
package tasks.task1.handler;

import tasks.task1.model.Book;
import tasks.task1.model.ModelService;
import tasks.task1.properties.Constants;
import java.util.ArrayList;

public class ViewMenuHandler {

    private ArrayList<Book> books;
    private ModelService modelService;

    public ViewMenuHandler() {
        modelService = new ModelService();
    }

    public void viewBooksByAuthor(){
        books = modelService.getSortBooksByAuthor();
        print(1L);
    }

    public void viewBooksByTitle(){
        books = modelService.getSortBooksByTitle();
        print(1L);
    }

    public void viewBooksByPublisher(){
        books = modelService.getSortBooksByPublisher();
        print(1L);
    }

    public void viewBooksByYear(){
        books = modelService.getSortBooksByYear();
        print(1L);
    }

    public void viewBooksByNumPage(){
        books = modelService.getSortBooksByNumPage();
        print(1L);
    }

    public void viewBooksByPrice(){
        books = modelService.getSortBooksByPrice();
        print(1L);
    }

    public void viewBooksByPage(Long page){
        print(page);
    }

    private void print(long page){
        books.stream().skip((page-1)* Constants.PAGE_SIZE)
                .limit(Constants.PAGE_SIZE)
                .forEach(System.out::println);
        System.out.printf("Страниц %d из %d",page,countPage());
    }

    private int countPage(){
        int pages = books.size()/Constants.PAGE_SIZE;
        if(books.size()%Constants.PAGE_SIZE != 0){
            pages = pages+1;
        }
        return pages;
    }
}
