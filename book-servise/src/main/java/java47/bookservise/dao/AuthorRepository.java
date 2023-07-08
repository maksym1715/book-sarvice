package java47.bookservise.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import java47.bookservise.model.Author;


public interface AuthorRepository extends PagingAndSortingRepository<Author, String>{

}
