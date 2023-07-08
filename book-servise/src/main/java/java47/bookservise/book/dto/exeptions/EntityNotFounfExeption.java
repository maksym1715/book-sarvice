package java47.bookservise.book.dto.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)

public class EntityNotFounfExeption extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5632056896469652678L;

}
