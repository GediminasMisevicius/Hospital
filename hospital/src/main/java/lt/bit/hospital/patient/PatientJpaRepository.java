package lt.bit.hospital.patient;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientJpaRepository extends JpaRepository<Patient, UUID>, JpaSpecificationExecutor<Patient> {

}
