package com.example.demo.controlller;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book/v1")
public class BookController {

    private final BookService bookService;

    @Autowired
   public BookController(BookService bookService) {
        this.bookService = bookService;
    }

//    public List<ResponseEntity<Book>> readBooks() {
//        List<Book> books = bookService.getBooks();
//        return ResponseEntity.ok(books);
//    }

    //search with name
    @GetMapping("/getBook/{bookName}")
    public ResponseEntity<Book> getBook(@PathVariable("bookName") String title) {
        Book book = bookService.getBookByName(title);
        return ResponseEntity.ok(book);
    }


    @PostMapping("/addBook")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book savedBook = bookService.addBook(book);
        return ResponseEntity.ok(savedBook);
    }

    @PutMapping("/updateBook")
    public ResponseEntity<Book> updateBook(@RequestBody Book book) {
        Book updatedBook = bookService.updateBook(book);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable("id") Integer id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok().build();
    }


}
