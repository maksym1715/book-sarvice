package java47.bookservise.dao;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import java47.bookservise.model.Author;
import java47.bookservise.model.Publisher;

public interface AuthorRepository {
	
 Optional<Author> findById(String authorName);
	
	Author save(Author author);
	
	void delete(Author author);

}
