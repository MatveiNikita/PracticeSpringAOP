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
        List<Book> books = bookRepository.findAll();
        return new CustomResponse<>(books, CustomStatus.SUCCESS);
    }

    public CustomResponse<Book> getBookByTitle(String title) {
        Book book = bookRepository.findBookByTitle(title).orElseThrow();
        return new CustomResponse<>(Stream.of(book).collect(Collectors.toList()), CustomStatus.SUCCESS);
    }

    public CustomResponse<Book> addBook(Book book) {
        Book newBook = null;
        newBook = bookRepository.save(book);
        return new CustomResponse<>(Stream.of(newBook).collect(Collectors.toList()), CustomStatus.SUCCESS);
    }
}
