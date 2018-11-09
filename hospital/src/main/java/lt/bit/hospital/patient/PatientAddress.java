package lt.bit.hospital.patient;

import java.io.Serializable;

public class PatientAddress implements Serializable {

	private String streetName;
	private String buildingNumber;
	private int flatNumber;
	
	
	public String getStreetName() {
		return streetName;
	}
	public PatientAddress setStreetName(String streetName) {
		this.streetName = streetName;
		return this;
	}
	public String getBuildingNumber() {
		return buildingNumber;
	}
	public PatientAddress setBuildingNumber(String buildingNumber) {
		this.buildingNumber = buildingNumber;
		return this;
	}
	public int getFlatNumber() {
		return flatNumber;
	}
	public PatientAddress setFlatNumber(int flatNumber) {
		this.flatNumber = flatNumber;
		return this;
	}
	@Override
	public String toString() {
		return "" + streetName + " g. " + buildingNumber + "-"
				+ flatNumber;
	}
	
	
	
}
