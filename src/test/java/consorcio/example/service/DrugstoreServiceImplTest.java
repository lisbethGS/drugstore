package consorcio.example.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import consorcio.example.config.AppConfig;
import consorcio.example.domain.DrugstoreApiOuput;
import consorcio.example.domain.TestObj;
import consorcio.example.gateway.ExternalApiGateway;

@SpringBootTest
@ContextConfiguration(classes = AppConfig.class)
class DrugstoreServiceImplTest {

	@InjectMocks
	private DrugstoreServiceImpl service;

	@Mock
	private ExternalApiGateway gateway;
	

	@Test
	void testDrugstoreServiceImplHappyPath() {
		when(gateway.getDrugStores())
				.thenReturn(TestObj.getDrugtoreApiOutputList());
		assertEquals(1, service.getDrugstoreByLocation("BUIN","AHUMADA").size());
	}
	@Test
	void testDrugstoreServiceImplDoesntIncludeEmpty() {
		when(gateway.getDrugStores())
				.thenReturn(TestObj.getDrugtoreApiOutputList());
		assertEquals(1, service.getDrugstoreByLocation("PIRQUE","").size());
	}
	@Test
	void testDrugstoreServiceImplDoesntIncludeListNull() {
		when(gateway.getDrugStores())
				.thenReturn(null);
		assertEquals(0, service.getDrugstoreByLocation("BUIN","AHUMADA").size());
	}
	@Test
	void testDrugstoreServiceImplDoesntIncludeEmptyList() {
		when(gateway.getDrugStores())
				.thenReturn(new ArrayList<DrugstoreApiOuput>());
		assertEquals(0, service.getDrugstoreByLocation("PIRQUE","").size());
	}

}
