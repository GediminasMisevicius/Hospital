package lt.bit.hospital.patient;

import java.io.Serializable;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.function.Supplier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="Patients")
public class Patient implements Serializable {
	

	@Id
	@NotNull
	@Column(name="id")
	private UUID id;
	
	@Column(name="name", nullable=false)
	@NotBlank
	@Size(min=5, max=100)
	private String name;
	
	@Column(name="surname", nullable=false)
	@NotBlank
	@Size(min=5, max=100)
	private String surname;
	
	@Column(name="diagnosis", nullable=false)
	@NotBlank
	@Size(min=5, max=200)
	private String diagnosis;
	
	@Column(name="recipe", nullable=false)
	private Recipe recipe;
	
	

	public Patient() {
		
	}
}