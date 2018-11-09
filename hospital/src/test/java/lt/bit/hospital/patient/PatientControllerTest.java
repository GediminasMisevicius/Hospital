package lt.bit.hospital.patient;

import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PatientControllerTest {
  
  private PatientController controller;
  @Mock
  private PatientServiceImpl service;
  
  @Before
  public void setUp() {
    this.controller = new PatientController(service);
  }

  @Test
  public void test() {
    fail("Not yet implemented");
  }

}
