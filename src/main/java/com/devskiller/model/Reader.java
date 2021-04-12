package com.devskiller.model;

import java.lang.reflect.Field;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.google.common.collect.Sets;

@Entity
public class Reader {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@OneToMany
	private final Set<Book> favouriteBooks = Sets.newHashSet();
	
	@Transient
	private final Set<Genre> favouriteGenres = Sets.newHashSet();
	
	@ManyToMany
	private final Set<GenreStr> favouriteGenresStrs = Sets.newHashSet();
	
	@Column
	private int age;

	public Reader() {
	}
	
	public Reader(int age) {
		this.age = age;
	}

	public void addToFavourites(Book book) {
		favouriteBooks.add(book);
	}

	public void addToFavourites(Genre genre) {
		favouriteGenres.add(genre);
	}

	public void removeFromFavourites(Book book) {
		favouriteBooks.remove(book);
	}

	public void removeFromFavourites(Genre genre) {
		favouriteGenres.remove(genre);
	}

	public int getAge() {
		return age;
	}

	public Set<Book> getFavouriteBooks() {
		return Sets.newHashSet(favouriteBooks);
	}

	public Set<Genre> getFavouriteGenres() {
		return Sets.newHashSet(favouriteGenres);
	}

	@Override
	public int hashCode() {
		int result = favouriteBooks.hashCode();
		result = 31 * result + favouriteGenres.hashCode();
		result = 31 * result + age;
		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Reader reader = (Reader) o;

		if (age != reader.age) return false;
		if (!favouriteBooks.equals(reader.favouriteBooks)) return false;
		return favouriteGenres.equals(reader.favouriteGenres);
	}
}
