package com.devskiller.model;

import javax.annotation.PostConstruct;
import javax.persistence.Column;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BooksSystem {
	@Autowired
	private Books books;
	
	@Autowired
	private Authors authors;
	
	@Autowired
	private Readers readers;
	
	@Autowired
	private Genres genres;
	
	public static void main(String [] args) {
		SpringApplication.run(BooksSystem.class, args);
	}
	
	private Author findAuthor(int authorId) {
		return authors.getOne(authorId);
	}
	
	public void addAuthor(String firstName, String lastName) {
		authors.<Author>saveAndFlush(new Author(firstName, lastName));
	}
	
	public void addBook(int authorId, String title, String isbn, Genre genre) {
		genres.<GenreStr>saveAndFlush(new GenreStr(genre.name()));
		books.<Book>saveAndFlush(new Book(findAuthor(authorId), title, isbn, genre));
	}
	
	public void Reader() {
		genres.<GenreStr>saveAndFlush(new GenreStr(genre.name()));
		books.<Book>saveAndFlush(new Book(findAuthor(authorId), title, isbn, genre));
	}
	
	@PostConstruct
	public void initDb() {
		addAuthor("Author", "Author");
		addBook(1, "T", "I", Genre.COMEDY);
		addBook(1, "T2", "I2", Genre.COMEDY);
	}
}