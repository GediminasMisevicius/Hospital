package lt.bit.hospitalPDF.writer;

import static org.assertj.core.api.Assertions.assertThat;
import java.io.IOException;
import org.junit.Test;

public class PdfWriterTest {

  @Test
  public void givenJsonStringExists_whenWritingPdf_thenByteArrayIsReturned() throws IOException {
    // given
    String json = new String("{\"name\":\"John\",\"age\":30,\"city\":\"New York\"}");
    // when
    byte[] bytes = PdfWriter.writePdf(json);
    // then
    assertThat(bytes).isNotNull();
  }

}
