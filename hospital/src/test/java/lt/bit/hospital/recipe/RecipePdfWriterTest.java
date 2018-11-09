package lt.bit.hospital.recipe;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;
import lt.bit.hospital.patient.PatientAddress;

@RunWith(MockitoJUnitRunner.class)
public class RecipePdfWriterTest {

	private Recipe recipe;
	RecipePdfWriter writer = spy(new RecipePdfWriter(new RestTemplate()));
//	@Mock
//	private RecipePdfWriter writer;
	
	@Before
	public void setUp() {
		recipe = new Recipe();
		recipe.setDrugDose(55f);
		recipe.setDrugName("apelsinas");
		PatientAddress address = new PatientAddress();
		address.setFlatNumber(1).setStreetName("Zirmunu").setBuildingNumber("5B");
		recipe.setPatientAddress(address);
		recipe.setPatientBirthday(LocalDateTime.now());
		recipe.setPatientId(UUID.randomUUID());
		recipe.setPatientLastName("pavardenis pavardenis pavardenis");
		recipe.setPatientName("vardenis");
		recipe.setRecipeId(UUID.randomUUID());
	}
	
	@Test
	public void givenRecipeExists_whenWritingPdf_thenMethodWasSuccessful() throws IOException {
		//given, when and then
			verify(writer).writePdf(recipe);
		
	}

}
