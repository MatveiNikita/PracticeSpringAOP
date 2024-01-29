package com.learnAOP.demo.service;

import com.learnAOP.demo.entity.Book;
import com.learnAOP.demo.repository.BookRepository;
import com.learnAOP.demo.util.CustomResponse;
import com.learnAOP.demo.util.CustomStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
@Slf4j
public class BookService {

    private final BookRepository bookRepository;
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public CustomResponse<Book> getAll(){
        List<Book> books;
        try {
            log.info("Try to get all books");
            books = bookRepository.findAll();
        }catch (Exception e){
            log.info(e.getMessage(), e);
            return new CustomResponse<>(null, CustomStatus.EXCEPTION);
        }
        log.info("Got books Successful");
        return new CustomResponse<>(books, CustomStatus.SUCCESS);
    }

    public CustomResponse<Book> getBookByTitle(String title) {
        Book book;
        try {
            log.info("Try to get book with title - {}", title);
            book = bookRepository.findBookByTitle(title).orElseThrow();
        }catch (NoSuchElementException e){
            log.info(e.getMessage(),e);
            return new CustomResponse<>(null, CustomStatus.EXCEPTION);
        }catch (Exception e){
            log.info(e.getMessage(),e);
            return new CustomResponse<>(null,CustomStatus.EXCEPTION);
        }
        log.info("Got book with title - {}",title);
        return new CustomResponse<>(Stream.of(book).collect(Collectors.toList()), CustomStatus.SUCCESS);
    }

    public CustomResponse<Book> addBook(Book book) {
        Book newBook = null;
        try {
            log.info("Try to add book {} in our library", book.getTitle());
            newBook = bookRepository.save(book);
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return new CustomResponse<>(null, CustomStatus.EXCEPTION);
        }
        log.info("Book - {} was added", book.getTitle());
        return new CustomResponse<>(Stream.of(newBook).collect(Collectors.toList()), CustomStatus.SUCCESS);
    }
}
