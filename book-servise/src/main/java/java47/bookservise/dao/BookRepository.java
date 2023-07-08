package java47.bookservise.dao;


import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.repository.PagingAndSortingRepository;

import java47.bookservise.model.Book;
import java47.bookservise.model.Publisher;

public interface BookRepository extends PagingAndSortingRepository<Book, String> {

	
	

	
	Stream<Book> findBooksByAuthors(String author);


	Stream<Book> findByPublisher(String publisher);


	


	


	


	


	

	

	
	

	

}
