package com.learnAOP.demo.controller;

import com.learnAOP.demo.entity.Book;
import com.learnAOP.demo.service.BookService;
import com.learnAOP.demo.util.CustomResponse;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
;

@RestController
@RequestMapping("/api")
public class BookController {
    BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public CustomResponse<Book> getAll(){
       return bookService.getAll();
    }
    @GetMapping("/book/{title}")
    public CustomResponse<Book> getBookByTitle(@PathVariable String title){
        return bookService.getBookByTitle(title);
    }
    @PostMapping("/books")
    public CustomResponse<Book> addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }
}

