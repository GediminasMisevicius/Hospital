package lt.bit.hospital.patient;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.jpa.domain.Specification;

public class PatientSpecificationsBuilderTest {

  private PatientFilter filter;
  
  @Before
  public void setUp() {
    this.filter = SpecificationTestFixture.giveFilter();
  }

  
  @Test
  public void givenPatientFIlter_whenPatientSpecificationBuilding_thenSpecificationIsBuilt() {
    //given and when
    Specification<Patient> specS = PatientSpecificationsBuilder.buildSpecificationByFilter(filter);
    Specification<Patient> specN = PatientSpecificationsBuilder.buildSpecificationByFilter(new PatientFilter());
    //then
    assertThat(specS).isNotNull();
    assertThat(specN).isNull();
  }
  
  @Test
  public void givenPatientFilter_whenPatientNameBuilding_thenNewSpecificationIsReturned() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    //given and when
    Specification<Patient> spec = SpecificationTestFixture.getAddrSpec();
    Specification<Patient> specN = PatientSpecificationsBuilder.patientName(null, filter);
    Specification<Patient> specS = PatientSpecificationsBuilder.patientName(spec, filter);
    //then
    assertThat(specN).isNotNull();
    assertThat(specS).isNotNull();
    assertThat(specS).isNotEqualTo(spec);
  }
  
  @Test
  public void givenPatientFilter_whenPatientDiagnosisBuilding_thenNewSpecificationIsReturned() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    //given and when
    Specification<Patient> spec = SpecificationTestFixture.getAddrSpec();
    Specification<Patient> specN = PatientSpecificationsBuilder.patientDiagnosis(null, filter);
    Specification<Patient> specS = PatientSpecificationsBuilder.patientDiagnosis(spec, filter);
    //then
    assertThat(specN).isNotNull();
    assertThat(specS).isNotNull();
    assertThat(specS).isNotEqualTo(spec);
  }
  
  @Test
  public void givenPatientFilter_whenPatientAddressBuilding_thenNewSpecificationIsReturned() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    //given and when
    Specification<Patient> spec = SpecificationTestFixture.getAddrSpec();
    Specification<Patient> specN = PatientSpecificationsBuilder.patientAddress(null, filter);
    Specification<Patient> specS = PatientSpecificationsBuilder.patientAddress(spec, filter);
    //then
    assertThat(specN).isNotNull();
    assertThat(specS).isNotNull();
    assertThat(specS).isNotEqualTo(spec);
  }
  
  @Test
  public void givenPatientFilter_whenCreatingNameSpecification_newPatientSpecificationIsReturned() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    // given
    Method method = PatientSpecificationsBuilder.class.getDeclaredMethod("createSpecificationName", PatientFilter.class);
    method.setAccessible(true);
    //when
    Specification<Patient> addrSpec = (Specification<Patient>) method.invoke(null, filter);
    //then
    assertThat(addrSpec).isNotNull();
    assertThat(addrSpec).isInstanceOf(Specification.class);
  }
  
  @Test
  public void givenPatientFilter_whenCreatingDiagnosisSpecification_newPatientSpecificationIsReturned() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    // given
    Method method = PatientSpecificationsBuilder.class.getDeclaredMethod("createSpecificationDiagnosis", PatientFilter.class);
    method.setAccessible(true);
    //when
    Specification<Patient> addrSpec = (Specification<Patient>) method.invoke(null, filter);
    //then
    assertThat(addrSpec).isNotNull();
    assertThat(addrSpec).isInstanceOf(Specification.class);
  }
  
  @Test
  public void givenPatientFilter_whenCreatingAddressSpecification_newPatientSpecificationIsReturned() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    // given
    Method method = PatientSpecificationsBuilder.class.getDeclaredMethod("createSpecificationAddress", PatientFilter.class);
    method.setAccessible(true);
    //when
    Specification<Patient> addrSpec = (Specification<Patient>) method.invoke(null, filter);
    //then
    assertThat(addrSpec).isNotNull();
    assertThat(addrSpec).isInstanceOf(Specification.class);
  }

}
