package java47.bookservise.book.dto;

import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter

public class AuthorDto {
	
	String name;
	LocalDate birthDate;
	
	

}
