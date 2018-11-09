package lt.bit.hospitalPDF.writer;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class PdfWriter {

  private static ObjectMapper objM = new ObjectMapper();

  public PdfWriter(ObjectMapper objM) {
    this.objM = objM;
  }


  public static byte[] writePdf(String json) throws IOException {

    Map<String, String> jsonMap = objM.readValue(json, Map.class);

    PDDocument document = new PDDocument();
    PDPage page = new PDPage();

    document.addPage(page);

    // TODO: use resources instead of File
    File fontFile = new File("src/main/resources/fonts/NovaMono.ttf");
    PDPageContentStream contentStream = new PDPageContentStream(document, page);
    PDFont font = PDType0Font.load(document, fontFile);
    contentStream.setFont(font, 12);

    ArrayList<Entry<String, String>> ent = new ArrayList<>();
    for (Entry<String, String> entry : jsonMap.entrySet()) {
      ent.add(entry);
    }


    for (int i = 0; i < jsonMap.size(); i++) {
      if (i == 0) {
        contentStream.beginText();
        contentStream.newLineAtOffset(100, 700);
      }
      contentStream.newLineAtOffset(0, -25);
      contentStream.showText(
          String.valueOf(ent.get(i).getKey()) + " : " + String.valueOf(ent.get(i).getValue()));
      if (i == jsonMap.size() - 1) {
        contentStream.endText();
        contentStream.close();
      }
    }
    ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
    document.save(byteStream);
    byte[] bytes = byteStream.toByteArray();
    byteStream.close();
    document.close();
    return bytes;
  }
}
