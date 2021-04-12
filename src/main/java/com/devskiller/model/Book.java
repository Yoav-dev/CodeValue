package com.devskiller.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private final Author author;

	@Column
	private final String title;

	@Column
	private final String isbn;

	@Transient
	private final Genre genre;

	@ManyToOne
	private final GenreStr genreStr;
	
	public GenreStr getGenreStr() {
		return genreStr;
	}

	@Column
	private int rating;

	public Book() {
		this.author = null;
		this.title = "";
		this.isbn = "";
		this.genre = null;
		this.genreStr = new GenreStr();
	}
	
	public Book(Author author, String title, String isbn, Genre genre) {
		this.author = author;
		this.title = title;
		this.isbn = isbn;
		this.genre = genre;
		this.genreStr = new GenreStr(genre.name());
	}

	public Book(Author author, String title, String isbn, Genre genre, int rating) {
		validate(rating);
		this.author = author;
		this.title = title;
		this.isbn = isbn;
		this.genre = genre;
		this.genreStr = new GenreStr(genre.name());
		this.rating = rating;
	}

	private void validate(int rating) {
		if (rating > 5 || rating < 1) {
			throw new IllegalArgumentException();
		}
	}

	public Author getAuthor() {
		return author;
	}

	public String getTitle() {
		return title;
	}

	public String getIsbn() {
		return isbn;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		validate(rating);
		this.rating = rating;
	}

	public Genre getGenre() {
		return genre;
	}

	@Override
	public int hashCode() {
		int result = author != null ? author.hashCode() : 0;
		result = 31 * result + (title != null ? title.hashCode() : 0);
		result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
		result = 31 * result + (genre != null ? genre.hashCode() : 0);
		result = 31 * result + rating;
		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Book book = (Book) o;

		if (rating != book.rating) return false;
		if (!Objects.equals(author, book.author)) return false;
		if (!Objects.equals(title, book.title)) return false;
		if (!Objects.equals(isbn, book.isbn)) return false;
		return genre == book.genre;
	}
}
