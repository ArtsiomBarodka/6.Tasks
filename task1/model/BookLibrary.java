/*
 * 6.tasks
 * Task 1
 * Artsiom Barodka
 *
 */
package tasks.task1.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class BookLibrary {

    private static BookLibrary instance;
    private ArrayList<Book> books;
    private DataService dataService;

    private BookLibrary(ArrayList<Book> books){
        dataService = new DataService();
        this.books = books;
    }

    static BookLibrary getInstance(ArrayList<Book> books){
        if(instance == null){
            instance = new BookLibrary(books);
        }
        return instance;
    }

    void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    ArrayList<Book> getBooks() {
        return books;
    }

    void addBook(Book book){
        books.add(book);
    }

    void deleteBook(Book book){
        books.remove(book);
    }

    void sortById(){
        Collections.sort(books, Comparator.comparing(Book::getId));
    }

    void sortByTitle(){
        Collections.sort(books, Comparator.comparing(Book::getTitle)
                .thenComparing(Book::getId));
    }

    void sortByAuthor(){
        Collections.sort(books, Comparator.comparing(Book::getAuthor)
                    .thenComparing(Book::getId));
    }

    void sortByPublisher(){
        Collections.sort(books, Comparator.comparing(Book::getPublisher)
                .thenComparing(Book::getId));
    }

    void sortByYear(){
        Collections.sort(books, Comparator.comparing(Book::getYear)
                .thenComparing(Book::getId));
    }

    void sortByNumPage(){
        Collections.sort(books, Comparator.comparing(Book::getNumPage)
                .thenComparing(Book::getId));
    }

    void sortByPrice(){
        Collections.sort(books, Comparator.comparing(Book::getPrice)
                .thenComparing(Book::getId));
    }

    ArrayList<Book> searchBooksByAuthor(String author){
        ArrayList<Book> result = new ArrayList<>();
        for (Book b:books) {
            if(b.getAuthor().equalsIgnoreCase(author)){
                result.add(b);
            }
        }
        return result;
    }

    ArrayList<Book> searchBooksByTitle(String title){
        ArrayList<Book> result = new ArrayList<>();
        for (Book b:books) {
            if(b.getTitle().equalsIgnoreCase(title)){
                result.add(b);
            }
        }
        return result;
    }

    ArrayList<Book> searchBooksByPublisher(String publisher){
        ArrayList<Book> result = new ArrayList<>();
        for (Book b:books) {
            if(b.getPublisher().equalsIgnoreCase(publisher)){
                result.add(b);
            }
        }
        return result;
    }

    ArrayList<Book> searchBooksByYear(int minYear, int maxYear){
        ArrayList<Book> result = new ArrayList<>();
        for (Book b:books) {
            if(b.getYear() >= minYear && b.getYear() <= maxYear){
                result.add(b);
            }
        }
        return result;
    }

    ArrayList<Book> searchBooksByNumPage(int minNumPage, int maxNumPage){
        ArrayList<Book> result = new ArrayList<>();
        for (Book b:books) {
            if(b.getNumPage() >= minNumPage && b.getNumPage() <= maxNumPage){
                result.add(b);
            }
        }
        return result;
    }

    ArrayList<Book> searchBooksByPrice(double minPrice, double maxPrice){
        ArrayList<Book> result = new ArrayList<>();
        for (Book b:books) {
            if(b.getPrice() >= minPrice && b.getPrice() <= maxPrice){
                result.add(b);
            }
        }
        return result;
    }

}
