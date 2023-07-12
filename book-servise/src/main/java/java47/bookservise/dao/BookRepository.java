package java47.bookservise.dao;



import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.repository.PagingAndSortingRepository;

import java47.bookservise.model.Book;
import java47.bookservise.model.Publisher;


public interface BookRepository {

		
	Stream<Book> findByAuthorsName(String name);

	Stream<Book> findByPublisherPublisherName(String name);

	boolean existsById(String isbn);

	Book save(Book book);

	Optional<Book> findById(String isbn);

	void deleteById(String isbn);


	
	 
	 
	 



	

}
