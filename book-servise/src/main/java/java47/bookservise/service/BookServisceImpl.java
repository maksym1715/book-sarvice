package java47.bookservise.service;



import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java47.bookservise.book.dto.AuthorDto;
import java47.bookservise.book.dto.BookDto;
import java47.bookservise.book.dto.exeptions.EntityNotFounfExeption;
import java47.bookservise.dao.AuthorRepository;
import java47.bookservise.dao.BookRepository;
import java47.bookservise.dao.PublisherRepository;
import java47.bookservise.model.Author;
import java47.bookservise.model.Book;
import java47.bookservise.model.Publisher;
import lombok.RequiredArgsConstructor;




@Service
@RequiredArgsConstructor
public class BookServisceImpl implements BookService {
	
	final BookRepository bookRepository;
	final AuthorRepository authorRepository;
	final PublisherRepository publisherRepository;
	final ModelMapper modelMapper;

	@Override
	public boolean addBook(BookDto bookDto) {
		if(bookRepository.existsById(bookDto.getIsbn())) {
			return false;
		}
		Publisher publisher = publisherRepository.findById(bookDto.getPublisher())
				.orElse(publisherRepository.save(new Publisher (bookDto.getPublisher())));
		Set<Author> authors = bookDto.getAuthors()
				.stream()
				.map(a -> authorRepository.findById(a.getName())
						.orElse(authorRepository.save(new Author(a.getName(), a.getBirthDate()))))
						.collect(Collectors.toSet());
						
		Book book = new Book(bookDto.getIsbn(), bookDto.getTitle(), authors, publisher);
		bookRepository.save(book);
		return true;
	}

	@Override
	public BookDto findBookByIsbn(String isbn) {
		Book book = bookRepository.findById(isbn).orElseThrow(() -> new EntityNotFounfExeption());
		return modelMapper.map(book, BookDto.class);
	}

	@Override
	public BookDto removeBook(String isbn) {
		Book book = bookRepository.findById(isbn).orElseThrow(() -> new EntityNotFounfExeption());
		bookRepository.deleteById(isbn);
		return modelMapper.map(book, BookDto.class);
	}

	@Override
	public BookDto updateBookTitle(String isbn, String title) {
		Book book = bookRepository.findById(isbn).orElseThrow(() -> new EntityNotFounfExeption());
		book.setTitle(title);
		bookRepository.save(book);
		return modelMapper.map(book, BookDto.class);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<BookDto> findBookByAuthor(String author) {    
	    return bookRepository.findBooksByAuthors(author)
				.map(p -> modelMapper.map(p, BookDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public Iterable<BookDto> findBooksByPublisher(String publisher) {
		return bookRepository.findByPublisher(publisher)
				.map(p -> modelMapper.map(p, BookDto.class))
				.collect(Collectors.toList());
	}
	
	

	  @Override public Iterable<AuthorDto> findBookAuthors(String isbn)	  {
	 Book book = bookRepository.findById(isbn).orElseThrow(() -> new EntityNotFounfExeption()); 
	  return book.getAuthors().stream().map(author -> modelMapper.map(author, AuthorDto.class)) .collect(Collectors.toList()); 
	  }
	  
	/*
	 * @Override public List<String> findPublishersByAuthor(String author) {
	 * List<Book> books = bookRepository.findBooksByAuthorsName(author); return
	 * books.stream() .map(book -> modelMapper.map(book, BookDto.class))
	 * .collect(Collectors.toList()); }
	 */
	 

}
