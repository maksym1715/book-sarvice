package java47.bookservise.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "name")
@Entity
@Table(name = "AUTHOR")
public class Author implements Serializable {

	
	private static final long serialVersionUID = -7569642285011160198L;
	@Id
	String name;
	LocalDate birthDate;
	@ManyToMany(mappedBy = "authors", cascade = CascadeType.ALL)
	Set<Book> books;

	public Author(String name, LocalDate birthDate) {
		this.name = name;
		this.birthDate = birthDate;
	}
	
	
}
