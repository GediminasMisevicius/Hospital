package lt.bit.hospitalPDF.writer;

import static org.assertj.core.api.Assertions.assertThat;
import javax.servlet.http.HttpServletResponse;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class WriterControllerTest {
  
  private WriterController cont;
  private HttpServletResponse response;
  
  @Before
  public void setUp() {
      cont = new WriterController();
  }
  
  @Test
  public void givenJsonHeaderAndHttpServletResponse_whenRequesting_thenResponseEntityIsReturned() {
    //given
    String json = new String("{\"name\":\"John\",\"age\":30,\"city\":\"New York\"}");
    //when
    ResponseEntity<byte[]> resp = cont.writeToPdf(json, response);
    //then
    assertThat(resp).isNotNull();
    assertThat(resp.getBody()).isInstanceOf(byte[].class);
    assertThat(resp.getStatusCode()).isEqualTo(HttpStatus.OK);
  }

}
