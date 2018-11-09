package lt.bit.hospital.patient;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.springframework.data.jpa.domain.Specification;

public class SpecificationTestFixture {

  private PatientFilter filter;

  public SpecificationTestFixture() {
    this.filter = new PatientFilter().setName("vardenis").setDiagnosis("gyvenimas").setAddress(
        new PatientAddress().setBuildingNumber("70").setFlatNumber(0).setStreetName("Zirmunu"));
  }
  

  public static Specification<Patient> getAddrSpec() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
  Method method = PatientSpecificationsBuilder.class.getDeclaredMethod("createSpecificationAddress", PatientFilter.class);
  method.setAccessible(true);
  Specification<Patient> addrSpec = (Specification<Patient>) method.invoke(null, giveFilter());
  return addrSpec;
  }


  public PatientFilter getPatientFilter() {
    return this.filter;
  }
  
  public static PatientFilter giveFilter() {
    return new SpecificationTestFixture().getPatientFilter();
  }
}
