package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {
    @Autowired
    BookService bookService;

    // One example controller, make the rest by yourself
    @PostMapping("/create-book")
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        Book newbook = bookService.createBook(book);
        return new ResponseEntity<>(newbook, HttpStatus.CREATED);
    }

    @GetMapping("/books/get-book-by-id/{id}")
    public ResponseEntity<Book> findBookById(@PathVariable("id")Integer id){
        Book book=bookService.findBookById(id);
        return new ResponseEntity<>(book,HttpStatus.FOUND);
    }

    @GetMapping("/books/get-all-books")
    public ResponseEntity<List<Book>> findAllBooks(){
        List<Book> books=bookService.findAllBooks();
        return new ResponseEntity<>(books,HttpStatus.FOUND);
    }

    @DeleteMapping("/books/delete-book-by-id/{id}")
    public void deleteBookById(@PathVariable("id")Integer id){
        bookService.deleteBookById(id);
    }

    @GetMapping("/books/get-books-by-author?author=author+name")
    public ResponseEntity<List<Book>> findBooksByAuthor(@RequestParam("author")String author,@RequestParam("name")String name){
        List<Book> books=bookService.findBooksByAuthor(author+name);
        return new ResponseEntity<>(books,HttpStatus.FOUND);

    }

    @GetMapping("/books/get-books-by-genre?genre=genre+name")
    public ResponseEntity<List<Book>> findBooksByGenre(@RequestParam("genre")String genre,@RequestParam("name")String name){
        List<Book> books=bookService.findBooksByGenre(genre);
        return new ResponseEntity<>(books,HttpStatus.FOUND);
    }

    @DeleteMapping("/books/delete-all-books")
    public void deleteAllBooks(){
        bookService.deleteAllBooks();
    }
}
