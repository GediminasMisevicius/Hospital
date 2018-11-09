package lt.bit.hospital.recipe;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class RecipePdfWriter {

  private final RestTemplate restTemplate;

  public RecipePdfWriter(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public void writePdf(Recipe recipe) throws IOException {

    ObjectMapper obj = new ObjectMapper();
    ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
    obj.writeValue(byteStream, recipe);

//    HttpEntity<String> request = new HttpEntity<>(byteStream.toString());
//    ByteArrayHttpMessageConverter byteArrayHttpMessageConverter = new ByteArrayHttpMessageConverter();
//
//    List<MediaType> supportedApplicationTypes = new ArrayList<MediaType>();
//    MediaType pdfApplication = new MediaType("application","pdf");
//    supportedApplicationTypes.add(pdfApplication);
//
//    byteArrayHttpMessageConverter.setSupportedMediaTypes(supportedApplicationTypes);
//    List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
//    messageConverters.add(byteArrayHttpMessageConverter);
//    restTemplate.setMessageConverters(messageConverters);
    
    HttpHeaders heads = new HttpHeaders();
    heads.add("JSON", byteStream.toString());
    ResponseEntity<byte[]> entity = restTemplate.exchange("http://localhost:8082/pdfwriter",
        HttpMethod.GET, new HttpEntity(heads), byte[].class);
    byte[] body = entity.getBody();
    MediaType contentType = entity.getHeaders().getContentType();
    HttpStatus statusCode = entity.getStatusCode();

    System.out.println("pdfed:\n" + "body : " + body + "\ncontentType : " + contentType
        + "\nstatusCode : " + statusCode);

  }
}
