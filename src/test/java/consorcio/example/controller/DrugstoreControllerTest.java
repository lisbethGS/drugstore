package consorcio.example.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import consorcio.example.config.AppConfig;

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = AppConfig.class)
class DrugstoreControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void noParamdDrugstoreShouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(get("/drugstore")).andExpect(status().isBadRequest());
	}
	@Test
	public void paramDrugstoreHappyPath() throws Exception {
		this.mockMvc.perform(get("/drugstore").param("locationName", "Spring Community").param("drugstoreName", "Spring Community")).andExpect(status().isOk());
	}
}