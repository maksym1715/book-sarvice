package java47.bookservise.dao;



import java.util.stream.Stream;

import org.springframework.data.repository.PagingAndSortingRepository;

import java47.bookservise.model.Book;


public interface BookRepository extends PagingAndSortingRepository<Book, String> {

		
	 Stream<Book> findByAuthorsName(String name);


	 Stream<Book> findByPublisherPublisherName(String name);
	 
	 
	 



	

}
