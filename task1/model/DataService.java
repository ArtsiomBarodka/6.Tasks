/*
 * 6.tasks
 * Task 1
 * Artsiom Barodka
 *
 */
package tasks.task1.model;

import tasks.task1.properties.Constants;
import tasks.task1.properties.Role;
import java.io.*;
import java.util.ArrayList;

public class DataService {

    private String booksPath;
    private String personsPath;

    DataService() {
         booksPath = Constants.BOOKS_PATH;
         personsPath = Constants.PERSONS_PATH;
    }

    public DataService(String booksPath,String personsPath) {
        this.booksPath = booksPath;
        this.personsPath = personsPath;
    }

    ArrayList<Book> parseBooks(){
        ArrayList<Book> result = new ArrayList<>();
        try(BufferedReader bf = new BufferedReader(new FileReader(booksPath))){
            String line;
            String[] props;
            Book book;
            while((line=bf.readLine())!=null){
                props = line.split(",");
                for (int i = 0; i < props.length; i++) {
                    props[i] = props[i].replaceAll("[a-zA-Z]*=","");
                }
                int id = Integer.parseInt(props[0]);
                String title = props[1];
                String author = props[2];
                String publisher = props[3];
                int year = Integer.parseInt(props[4]);
                int numPage = Integer.parseInt(props[5]);
                double price = Double.parseDouble(props[6]);
                book = new Book(id,title,author,publisher,year,numPage,price);
                result.add(book);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    void updateBooks(ArrayList<Book> books){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(booksPath))){
            for (Book b:books) {
                bw.write("id="+b.getId()+",");
                bw.write("title="+b.getTitle()+",");
                bw.write("author="+b.getAuthor()+",");
                bw.write("publisher="+b.getPublisher()+",");
                bw.write("year="+b.getYear()+",");
                bw.write("numPage="+b.getNumPage()+",");
                bw.write("price="+b.getPrice()+"\n");
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    ArrayList<Person> parsePersons(){
        ArrayList<Person> result = new ArrayList<>();
        try(BufferedReader bf = new BufferedReader(new FileReader(personsPath))){
            String line;
            String[] props;
            Person person;
            while((line=bf.readLine())!=null){
                props = line.split(",");
                for (int i = 0; i < props.length; i++) {
                    props[i] = props[i].replaceAll("[a-zA-Z]*=","");
                }
                int id = Integer.parseInt(props[0]);
                String name = props[1];
                int password = Integer.parseInt(props[2]);
                String mail = props[3];
                Role role = Role.valueOf(props[4]);
                person = new Person(id,name,password,mail,role);
                result.add(person);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    void updatePeople(ArrayList<Person> people){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(personsPath))){
            for (Person p:people) {
                bw.write("id="+p.getId()+",");
                bw.write("name="+p.getName()+",");
                bw.write("password="+p.getPassword()+",");
                bw.write("mail="+p.getMail()+",");
                bw.write("role="+p.getRole()+"\n");
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
