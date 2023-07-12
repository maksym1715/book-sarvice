package java47.bookservise.dao;

import java.util.Optional;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java47.bookservise.model.Book;
@Repository
public class BookRepositoryImpl implements BookRepository {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public Stream<Book> findByAuthorsName(String name) {
		TypedQuery<Book> query = em.createQuery("select b from Book b join b.authors a where a.name=?1", Book.class);
		query.setParameter(1, name);
		return query.getResultStream();
	}

	@Override
	public Stream<Book> findByPublisherPublisherName(String name) {
		TypedQuery<Book> query = em.createQuery(
		        "SELECT b FROM Book b JOIN b.publisher p WHERE p.publisherName = :name",
		        Book.class
		    );
		    query.setParameter("name", name);
		    return query.getResultStream();
	}

	@Override
	public boolean existsById(String isbn) {
		return em.find(Book.class, isbn) != null;
	}

	@Override
//	@Transactional
	public Book save(Book book) {
		em.persist(book);
		return book;
	}

	@Override
	public Optional<Book> findById(String isbn) {
		return Optional.ofNullable(em.find(Book.class, isbn));
	}

	@Override
	@Transactional
	public void deleteById(String isbn) {
		Book book = em.getReference(Book.class, isbn);
	    em.remove(book);
        
	}

	

}
