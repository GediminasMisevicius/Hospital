package lt.bit.hospital.recipe;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import lt.bit.hospital.patient.PatientAddress;

public class Recipe implements Serializable {
	
	private UUID recipeId;
	private UUID patientId;
	private String patientName;
	private String patientLastName;
	private PatientAddress patientAddress;
	private LocalDateTime patientBirthday;
	private String drugName;
	private float drugDose;
	
	public UUID getRecipeId() {
		return recipeId;
	}
	public void setRecipeId(UUID recipeId) {
		this.recipeId = recipeId;
	}
	public UUID getPatientId() {
		return patientId;
	}
	public void setPatientId(UUID patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getPatientLastName() {
		return patientLastName;
	}
	public void setPatientLastName(String patientLastName) {
		this.patientLastName = patientLastName;
	}
	public PatientAddress getPatientAddress() {
		return patientAddress;
	}
	public void setPatientAddress(PatientAddress patientAddress) {
		this.patientAddress = patientAddress;
	}
	public LocalDateTime getPatientBirthday() {
		return patientBirthday;
	}
	public void setPatientBirthday(LocalDateTime patientBirthday) {
		this.patientBirthday = patientBirthday;
	}
	public String getDrugName() {
		return drugName;
	}
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	public float getDrugDose() {
		return drugDose;
	}
	public void setDrugDose(float drugDose) {
		this.drugDose = drugDose;
	}

}
