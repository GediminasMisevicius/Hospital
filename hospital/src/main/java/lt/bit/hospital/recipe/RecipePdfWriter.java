package lt.bit.hospital.recipe;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDTrueTypeFont;


public class RecipePdfWriter {
	
	public static void writePdf(Recipe recipe) throws IOException {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		PDDocument document = new PDDocument();
		PDPage page = new PDPage();
		
		document.addPage(page);
		
		AccessPermission accessPermission = new AccessPermission();
		accessPermission.setCanPrint(true);
		accessPermission.setCanModify(false);
		
		File fontFile = new File("src/main/resources/fonts/NovaMono.ttf");
		PDPageContentStream contentStream = new PDPageContentStream(document, page);
		PDFont font = PDTrueTypeFont.loadTTF(document, fontFile);
		contentStream.setFont(font, 12);
		contentStream.setNonStrokingColor(Color.BLACK);
		contentStream.addRect(98, 696, ( recipe.getPatientName().length() * 7f + 12.5f + recipe.getPatientLastName().length() * 7f), 14);
		contentStream.addRect(98, 672, recipe.getPatientBirthday().format(formatter).length() * 7f, 14);
		contentStream.addRect(98, 648, recipe.getPatientAddress().toString().length() * 7f, 14);
		contentStream.addRect(98, 548, 400, 65);
		contentStream.stroke();
		contentStream.beginText();
		contentStream.newLineAtOffset(100, 700);
		contentStream.showText(recipe.getPatientName());
		contentStream.newLineAtOffset(recipe.getPatientName().length() * 7f + 12.5f, 0);
		contentStream.showText(recipe.getPatientLastName());
		contentStream.newLineAtOffset(-(recipe.getPatientName().length() * 7f + 12.5f), -25);
		contentStream.showText(recipe.getPatientBirthday().format(formatter));
		contentStream.newLineAtOffset(0, -25);
		contentStream.showText(recipe.getPatientAddress().toString());
		contentStream.newLineAtOffset(0, -50);
		contentStream.showText(recipe.getDrugName());
		contentStream.newLineAtOffset(0, -50);
		contentStream.showText(String.valueOf(recipe.getDrugDose()) + " mg");
		contentStream.endText();
		contentStream.close();
		
		
		 
		StandardProtectionPolicy standardProtectionPolicy 
		  = new StandardProtectionPolicy("dogtor", "", accessPermission);
		document.protect(standardProtectionPolicy);
		 
		document.save("pdfBoxHelloWorld.pdf");
		System.out.println("PDF--------------------");
		document.close();
		
	}
}