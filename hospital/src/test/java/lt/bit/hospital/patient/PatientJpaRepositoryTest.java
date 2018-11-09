package lt.bit.hospital.patient;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import java.util.Optional;
import java.util.UUID;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PatientJpaRepositoryTest {

  @Autowired
  private PatientJpaRepository rep;
  private UUID id;

  @Before
  public void setUp() {
    Patient patient = new Patient();
    patient.setAddress(
        new PatientAddress().setBuildingNumber("1").setFlatNumber(1).setStreetName("g"));
    patient.setDiagnosis("gyvenimas");
    patient.setId(UUID.randomUUID());
    patient.setName("vardenis");
    patient.setSurname("pavardenis");
    id = patient.getId();
    rep.saveAndFlush(patient);
  }

  @Test
  public void givenPatientIsPresent_whenFIndingPatientById_thenSamePatientIsReturned() {
    // given
    Patient patient = new Patient();
    patient.setAddress(
        new PatientAddress().setBuildingNumber("1").setFlatNumber(1).setStreetName("g"));
    patient.setDiagnosis("gyvenimas");
    patient.setId(UUID.randomUUID());
    patient.setName("vardenis");
    patient.setSurname("pavardenis");
    UUID id = patient.getId();
    rep.saveAndFlush(patient);
    // when
    Optional<Patient> actual = rep.findById(id);
    // then
    assertThat(actual.get()).isEqualToComparingFieldByField(patient);
  }

}
