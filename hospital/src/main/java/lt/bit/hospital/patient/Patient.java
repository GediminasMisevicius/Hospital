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

import lt.bit.hospital.recipe.Recipe;

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
	
	//TODO: DB integration for address
	@Column(name="patient_address", nullable=false)
    @NotBlank
	private PatientAddress address;

	
	public Patient() {
		
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public Patient setName(String name) {
		this.name = name;
		return this;
	}

	public String getSurname() {
		return surname;
	}

	public Patient setSurname(String surname) {
		this.surname = surname;
		return this;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public Patient setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
		return this;
	}

	public PatientAddress getAddress() {
		return address;
	}

	public void setAddress(PatientAddress address) {
		this.address = address;
	}
	
	

}