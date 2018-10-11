package lt.bit.hospital.patient;

public class PatientFilter {

	private String name;
	private String diagnosis;
	private PatientAddress address;
	
	public String getName() {
		return name;
	}
	public PatientFilter setName(String name) {
		this.name = name;
		return this;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public PatientFilter  setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
		return this;
	}
	public PatientAddress getAddress() {
		return address;
	}
	public PatientFilter  setAddress(PatientAddress address) {
		this.address = address;
		return this;
	}
	
	
	
}
