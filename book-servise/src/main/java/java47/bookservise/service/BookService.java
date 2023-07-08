package java47.bookservise.service;

import java.util.List;

import java47.bookservise.book.dto.AuthorDto;
import java47.bookservise.book.dto.BookDto;


public interface BookService {
	
	boolean addBook(BookDto bookDto);
	
	BookDto findBookByIsbn(String isbn);
	
	BookDto removeBook(String isbn);
	
	BookDto updateBookTitle(String isbn, String title);
	
	Iterable<BookDto> findBookByAuthor(String author);
	
	Iterable<BookDto> findBooksByPublisher(String publisherName);
	
	Iterable<AuthorDto> findBookAuthors(String isbn);
	 
	 // List<String> findPublishersByAuthor(String author);
	 
    

}
