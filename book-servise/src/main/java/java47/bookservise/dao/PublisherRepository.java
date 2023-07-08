package java47.bookservise.dao;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import java47.bookservise.model.Publisher;

public interface PublisherRepository extends PagingAndSortingRepository<Publisher, String> {

	

	Optional<Publisher> findByPublisherName(String publisher);



}
