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

public class SearchMenuHandler {

    private ArrayList<Book> books;
    private ModelService modelService;

    public SearchMenuHandler() {
        modelService = new ModelService();
    }

    public void searchBooksByTitle(String title){
        books = modelService.searchBooksByTitle(title);
        print(1L);
    }

    public void searchBooksByAuthor(String author){
        books = modelService.searchBooksByAuthor(author);
        print(1L);
    }

    public void searchBooksByPublisher(String publisher){
        books = modelService.searchBooksByPublisher(publisher);
        print(1L);
    }

    public void searchBooksByYear(String minYear, String maxYear){
        int minYearInt = Integer.parseInt(minYear);
        int maxYearInt = Integer.parseInt(maxYear);
        books = modelService.searchBooksByYear(minYearInt,maxYearInt);
        print(1L);
    }

    public void searchBooksByNumPage(String minNumPage, String maxNumPage){
        int minNumPageInt = Integer.parseInt(minNumPage);
        int maxNumPageInt = Integer.parseInt(maxNumPage);
        books = modelService.searchBooksByNumPage(minNumPageInt,maxNumPageInt);
        print(1L);
    }

    public void searchBooksByPrice(String minPrice, String maxPrice){
        int minPriceInt = Integer.parseInt(minPrice);
        int maxPriceInt = Integer.parseInt(maxPrice);
        books = modelService.searchBooksByPrice(minPriceInt,maxPriceInt);
        print(1L);
    }

    public void searchBooksByPage(Long page){
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
