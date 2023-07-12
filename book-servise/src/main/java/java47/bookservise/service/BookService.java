package java47.bookservise.service;

import java47.bookservise.book.dto.AuthorDto;
import java47.bookservise.book.dto.BookDto;


public interface BookService {
	
	boolean addBook(BookDto bookDto);
	
	BookDto findBookByIsbn(String isbn);
	
	BookDto remove(String isbn);
	
	BookDto updateBook(String isbn, String title);
	
	Iterable<BookDto> findBooksByAuthor(String authorName);
	
	Iterable<BookDto> findBooksByPublisher(String publisherName);
	
	Iterable<AuthorDto> findBookAuthors(String isbn);
	 
	Iterable<String> findPublishersByAuthor(String authorName);
	
	AuthorDto removeAuthor (String authorName);
	 
    

}
