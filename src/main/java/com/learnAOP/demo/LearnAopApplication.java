package com.learnAOP.demo;

import com.learnAOP.demo.entity.Book;
import com.learnAOP.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class LearnAopApplication implements CommandLineRunner {
	public static void main(String[] args){
		SpringApplication.run(LearnAopApplication.class, args);
	}
	@Autowired
	private final BookRepository bookRepository;

	public LearnAopApplication(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		Book book1 = new Book("Lord of the flies", "Уилиям Голдинг");
		Book book2 = new Book("Advence of the Tom Soyar", "Mark Tven");
		bookRepository.save(book2);
		bookRepository.save(book1);
	}


}
