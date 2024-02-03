package com.AmazingLibrary_Micro.book_service.repository;

import org.springframework.data.repository.CrudRepository;
import com.AmazingLibrary_Micro.book_service.model.*;

public interface BookRepository extends CrudRepository<Book, Long>{
	Book findByTitle(String name);
	
	Book findByIsbn(String isbn);

}
