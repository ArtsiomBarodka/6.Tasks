/*
 * 6.tasks
 * Task 1
 * Artsiom Barodka
 *
 */
package tasks.task1.model;

import tasks.task1.properties.Role;
import java.util.ArrayList;

public class ModelService {

    private BookLibrary bookLibrary;
    private Book book;
    private Person person;
    private DataService dataService;

    public ModelService() {
        dataService = new DataService();
        bookLibrary = BookLibrary.getInstance(dataService.parseBooks());
    }

    public boolean createBook(String title, String author,String publisher,
                          int year, int numPage, double price){
        int id = getLastBookId()+1;
        Book book = new Book(id,title,author,publisher,year,numPage,price);
        if(!hasBook(book)){
            addBook(book);
            return true;
        }
        return false;
    }

    public boolean removeBook(String title, String author){
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        if(hasBook(book)){
            deleteBook(book);
            return true;
        }
        return false;
    }

    public ArrayList<Book> searchBooksByAuthor(String author){
        return bookLibrary.searchBooksByAuthor(author);
    }

    public ArrayList<Book> searchBooksByTitle(String title){
        return bookLibrary.searchBooksByTitle(title);
    }

    public ArrayList<Book> searchBooksByPublisher(String publisher){
        return bookLibrary.searchBooksByPublisher(publisher);
    }

    public ArrayList<Book> searchBooksByYear(int minYear, int maxYear){
        return bookLibrary.searchBooksByYear(minYear, maxYear);
    }

    public ArrayList<Book> searchBooksByNumPage(int minNumPage, int maxNumPage){
        return bookLibrary.searchBooksByNumPage(minNumPage, maxNumPage);
    }

    public ArrayList<Book> searchBooksByPrice(double minPrice, double maxPrice){
        return bookLibrary.searchBooksByPrice(minPrice, maxPrice);
    }

    public ArrayList<Book> getSortBooksByAuthor(){
        bookLibrary.sortByAuthor();
        return bookLibrary.getBooks();
    }

    public ArrayList<Book> getSortBooksByTitle(){
        bookLibrary.sortByTitle();
        return bookLibrary.getBooks();
    }

    public ArrayList<Book> getSortBooksByPublisher(){
        bookLibrary.sortByPublisher();
        return bookLibrary.getBooks();
    }

    public ArrayList<Book> getSortBooksByYear(){
        bookLibrary.sortByYear();
        return bookLibrary.getBooks();
    }

    public ArrayList<Book> getSortBooksByNumPage(){
        bookLibrary.sortByNumPage();
        return bookLibrary.getBooks();
    }

    public ArrayList<Book> getSortBooksByPrice(){
        bookLibrary.sortByPrice();
        return bookLibrary.getBooks();
    }

    private void addBook(Book book){
        bookLibrary.addBook(book);
        updateBooks();
    }

    private void deleteBook(Book book){
        bookLibrary.deleteBook(book);
        updateBooks();
    }

    private void updateBooks(){
        dataService.updateBooks(bookLibrary.getBooks());
        bookLibrary.setBooks(dataService.parseBooks());
    }

    private int getLastBookId(){
        bookLibrary.sortById();
        ArrayList<Book> books = bookLibrary.getBooks();
        return books.get(books.size()-1).getId();
    }

    private boolean hasBook(Book book){
        ArrayList<Book> books = bookLibrary.getBooks();
        for (Book b:books) {
            if(b.equals(book)){
                return true;
            }
        }
        return false;
    }

    public void createPerson(String name, int pass, String mail){
        person = new Person(getLastPersonId(),name,pass,mail, Role.USER);
        ArrayList<Person> people = dataService.parsePersons();
        people.add(person);
        dataService.updatePeople(people);
    }

    public ArrayList<Person> getPeople(){
        return dataService.parsePersons();
    }

    private int getLastPersonId(){
        ArrayList<Person> people = dataService.parsePersons();
        int id = 0;
        for (Person p:people) {
            if(p.getId()>id){
                id = p.getId();
            }
        }
        return id;
    }



}
