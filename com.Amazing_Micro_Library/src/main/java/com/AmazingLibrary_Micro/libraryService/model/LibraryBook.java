package com.AmazingLibrary_Micro.libraryService.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LibraryBook {
	
	private String title, isbn, description;

	private LibraryBook() {
		
	}

	public LibraryBook(String title, String isbn, String description) {
		super();
		this.title = title;
		this.isbn = isbn;
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}