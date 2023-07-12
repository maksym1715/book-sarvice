package java47.bookservise.dao;



import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java47.bookservise.model.Publisher;

public interface PublisherRepository {
//	@Query("select distinct p.publisherName from Book b join b.authors a join b.publisher p where a.name=?1")
	List<String> findPublishersByAuthor(String authorName);

	Stream<Publisher> findDistinctByBooksAuthorsName(String authorName);

	Optional<Publisher> findById(String publisher);

	Publisher save(Publisher publisher);
	

}
