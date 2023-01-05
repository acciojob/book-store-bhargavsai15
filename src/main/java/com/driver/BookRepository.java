package com.driver;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    HashMap<Integer,Book> bookDb;
    List<Book> books;
    public BookRepository(){
        this.bookDb=new HashMap<>();
        this.books=new ArrayList<>();
    }

    public Book save(Book book){
        int id=book.getId();
        if(!bookDb.containsKey(id)){
            bookDb.put(id,new Book(id,book.getName(),book.getGenre(),book.getAuthor()));
            books.add(new Book(book.getId(),book.getName(),book.getGenre(),book.getAuthor()));
        }
        return bookDb.get(id);
    }

    public Book findBookById(int id){
        return bookDb.get(id);
    }

    public List<Book> findAll(){
        return books;
    }

    public void deleteBookById(int id){
        if(bookDb.containsKey(id)){
            bookDb.remove(id);
        }
    }

    public void deleteAll(){
        bookDb.clear();
    }

    public List<Book> findBooksByAuthor(String author){
        List<Book> books1=new ArrayList<>();
        for(int key:bookDb.keySet()){
            String aut=bookDb.get(key).getAuthor();
            if(aut.equals(author)){
                books1.add(bookDb.get(key));
            }
        }
        return books1;
    }

    public List<Book> findBooksByGenre(String genre){
        List<Book> books1=new ArrayList<>();
        for(int key:bookDb.keySet()){
            String genre1=bookDb.get(key).getGenre();
            if(genre1.equals(genre)){
                books1.add(bookDb.get(key));
            }
        }
        return books1;
    }
}
