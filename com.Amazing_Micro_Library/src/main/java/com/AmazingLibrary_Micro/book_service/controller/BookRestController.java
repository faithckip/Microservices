package com.AmazingLibrary_Micro.book_service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.AmazingLibrary_Micro.book_service.model.Book;
import com.AmazingLibrary_Micro.book_service.repository.BookRepository;

@RestController
@RequestMapping("api/books")
public class BookRestController {
	
	Logger logger = LoggerFactory.getLogger(BookRestController.class.getName());
	
	@Autowired
	private BookRepository bookRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	Iterable<Book> getBooks(){
		logger.info(">>> getBooks");
		return this.bookRepository.findAll();		
	}
}
