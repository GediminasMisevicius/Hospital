package lt.bit.hospital.patient;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;


@Service
@Validated
@Transactional
public class PatientServiceImpl {
	
	private PatientJpaRepository repository;
	
	public PatientServiceImpl(PatientJpaRepository repository) {
		this.repository = repository;
	}
	
	public void registerPatient(@NotNull @Valid Patient patient) {
		repository.save(patient);
	}
	
	@Transactional(readOnly=true)
	public Patient getPatientInfo(@NotEmpty String id) {
		return repository.findById(UUID.fromString(id)).orElseThrow(); //TODO: add exception
	}
	
	public void editPatientInfo(@NotEmpty String id, @NotEmpty String... info) {
		Patient editable = repository.findById(UUID.fromString(id)).orElseThrow(); //TODO: add exception
		//editing
		repository.save(editable);
	}
	
	public List<Patient> getPatientByFilter(PatientFilter patientFilter) {
		
		return repository.findAll(PatientSpecificationsBuilder.buildSpecificationByFilter(patientFilter));

		}

}
