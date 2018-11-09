package lt.bit.hospitalPDF.writer;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WriterController {

  @GetMapping(value="/pdfwriter", produces = MediaType.APPLICATION_PDF_VALUE)
  public ResponseEntity<byte[]> writeToPdf(@RequestHeader("JSON") String json, HttpServletResponse response) {
    byte[] pdf = null;
    try {
    pdf = PdfWriter.writePdf(json);
    } catch (IOException e) {
      e.printStackTrace();
    }
    HttpHeaders headers = new HttpHeaders();
//    headers.setContentType(MediaType.parseMediaType("application/pdf"));
    headers.setContentType(MediaType.parseMediaType("application/octet-stream"));
//    String filename = "output.pdf";
//    headers.setContentDispositionFormData(filename, filename);
    headers.setContentDisposition(ContentDisposition.parse("attachment"));
    headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
    
    return new ResponseEntity<>(pdf, headers, HttpStatus.OK);
  }

}
