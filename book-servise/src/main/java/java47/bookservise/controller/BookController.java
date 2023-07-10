package java47.bookservise.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java47.bookservise.book.dto.AuthorDto;
import java47.bookservise.book.dto.BookDto;
import java47.bookservise.service.BookService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BookController  {
	
	final BookService bookService;

	@PostMapping("book")
	public boolean addBook(@RequestBody BookDto bookDto) {
	
		return bookService.addBook(bookDto);
	}

	@GetMapping("/book/{isbn}")
	public BookDto findBookByIsbn(@PathVariable String isbn) {
		return bookService.findBookByIsbn(isbn);
	}
	
	@DeleteMapping("/book/{isbn}")
    public BookDto removeBook(@PathVariable String isbn) {
        return bookService.removeBook(isbn);
    }

	@PutMapping("/book/{isbn}/title/{title}")
    public BookDto updateBookTitle(@PathVariable String isbn, @PathVariable String title) {
         return bookService.updateBookTitle(isbn, title);
    }

    @GetMapping("/books/author/{author}")
    public Iterable<BookDto> findBookByAuthor(@PathVariable String authorName) {
        return bookService.findBookByAuthor(authorName);
    }

    @GetMapping("/books/publisher/{publisher}")
    public Iterable<BookDto> findBooksByPublisher(@PathVariable String publisherName) {
        return bookService.findBooksByPublisher(publisherName);
    }


	  @GetMapping("/authors/book/{isbn}") 
	  public Iterable<AuthorDto> findBookAuthors(@PathVariable String isbn) {
		  return bookService.findBookAuthors(isbn); 
	  }
	  
	  @DeleteMapping("/author/{author}")
	    public BookDto removeAuthor(@PathVariable String authorName) {
	        return bookService.removeBook(authorName);
	    }
	  
	  @GetMapping("/publishers/author/{author}") 
	  public Iterable<String> findPublishersByAuthor(@PathVariable String author)
	  { return bookService.findPublishersByAuthor(author); }
	 

}
