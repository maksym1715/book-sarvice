package java47.bookservise.model;

import java.io.Serializable;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "publisherName")
@Entity
public class Publisher implements Serializable {

	private static final long serialVersionUID = 6991812064357166411L;
	
	@Id
	String publisherName;

	
}
