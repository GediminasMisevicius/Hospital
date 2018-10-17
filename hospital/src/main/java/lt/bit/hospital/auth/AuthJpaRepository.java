package lt.bit.hospital.auth;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.bit.hospital.patient.Patient;

@Repository
public interface AuthJpaRepository extends JpaRepository<Patient, Long> {

	Optional<Patient> findByNameAndSurname(String name, String surname);
	Optional<Patient> findByName(String name);
}
