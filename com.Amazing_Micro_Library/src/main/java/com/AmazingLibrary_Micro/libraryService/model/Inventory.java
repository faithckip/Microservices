package com.AmazingLibrary_Micro.libraryService.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Inventory {
	
	private Date requestDate;
	private Iterable<LibraryBook> books;
	
	public Inventory(Date requestDate, Iterable<LibraryBook> books) {
		super();
		this.requestDate = requestDate;
		this.books = books;
	}

	public Inventory() {
		
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public Iterable<LibraryBook> getBooks() {
		return books;
	}

	public void setBooks(Iterable<LibraryBook> books) {
		this.books = books;
	}
}