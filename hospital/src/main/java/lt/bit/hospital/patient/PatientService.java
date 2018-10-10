package lt.bit.hospital.patient;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class PatientService {
	
	@Autowired
	private PatientJpaRepository repository;
	
	public void registerPatient(@NotNull @Valid Patient patient) {
		repository.save(patient);
	}
	
	public String getPatientInfo(@NotEmpty String id) {
		repository.getById(id).toString();
	}
	
	public void editPatientInfo(@NotEmpty String id, @NotEmpty String... info) {
		Patient editable = repository.getById(id);
		//editing
		repository.save(editable);
	}

}
