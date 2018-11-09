package lt.bit.hospital.patient;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PatientServiceImplTest {

  private PatientServiceImpl service;
  @Mock
  private PatientJpaRepository rep;

  @Before
  public void setUp() {
    this.service = new PatientServiceImpl(rep);
  }


  @Test
  public void givenPatientExists_whenRegisteringPatient_thenPatientIsSavedToRepository() {
    // given
    Patient patient = new Patient();
    patient.setAddress(
        new PatientAddress().setBuildingNumber("1").setFlatNumber(1).setStreetName("g"));
    patient.setDiagnosis("gyvenimas");
    patient.setId(UUID.randomUUID());
    patient.setName("vardenis");
    patient.setSurname("pavardenis");
    // when
    service.registerPatient(patient);
    // then
    verify(rep).save(patient);
  }

  @Test
  public void givenPatientExists_whenFindingPatient_thenPatientIsReturned() {
    // given
    Patient patient = new Patient();
    patient.setAddress(
        new PatientAddress().setBuildingNumber("1").setFlatNumber(1).setStreetName("g"));
    patient.setDiagnosis("gyvenimas");
    patient.setId(UUID.fromString("c430e147-5b06-48cd-8219-fb1164379f1c"));
    patient.setName("vardenis");
    patient.setSurname("pavardenis");

    rep.save(patient);
    when(rep.findById(patient.getId())).thenReturn(Optional.of(patient));
    // when
    Patient pfind = service.getPatientInfo(patient.getId().toString());
    // then
    assertThat(pfind).isEqualToComparingFieldByField(patient);
  }

  @Test
  public void givenPatientFilter_whenGettingPatientsByFilter_thenPatientListIsReturned() {
    // given and when
    List<Patient> list = service.getPatientByFilter(SpecificationTestFixture.giveFilter());
    // then
    assertThat(list).isNotNull();

  }

}
