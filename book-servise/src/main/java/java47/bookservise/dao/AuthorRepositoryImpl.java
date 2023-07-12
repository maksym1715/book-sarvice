package java47.bookservise.dao;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java47.bookservise.model.Author;
@Repository
public class AuthorRepositoryImpl implements AuthorRepository {
	
	@PersistenceContext
	EntityManager em;

	
	@Override
	public Optional<Author> findById(String authorName) {
		return Optional.ofNullable(em.find(Author.class, authorName));
	}

	@Override
//	@Transactional
	public Author save(Author author) {
		em.persist(author);
//		em.merge(author);
		return author;
	}

	@Override
	@Transactional
	public void delete(Author author) {
		em.remove(author);

	}

}
