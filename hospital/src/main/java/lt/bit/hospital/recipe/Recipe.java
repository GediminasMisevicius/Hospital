package lt.bit.hospital.recipe;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import lt.bit.hospital.patient.Patient;
import lt.bit.hospital.patient.PatientAddress;

public class Recipe implements Serializable {
	
	private UUID recipeId;
	private UUID patientId;
	private String patientName;
	private String patientLastName;
	private PatientAddress patientAddress;
	private LocalDate patientBirthday;
	private String drugName;
	private float drugDose;

}
