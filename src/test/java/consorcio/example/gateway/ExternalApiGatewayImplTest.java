package consorcio.example.gateway;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;

import consorcio.example.config.AppConfig;
import consorcio.example.domain.DrugstoreApiOuput;
import consorcio.example.domain.TestObj;
import consorcio.example.excepton.GatewayException;

@SpringBootTest
@ContextConfiguration(classes = AppConfig.class)
class ExternalApiGatewayImplTest {
	@InjectMocks
	private ExternalApiGatewayImpl gateway;

	@Mock
	private RestTemplate restTemplate;
	
	String url;
	
	@Before
	void before() {
		org.springframework.test.util.ReflectionTestUtils.setField(gateway, url, "value");
	}

	@Test
	void testDrugstoreServiceImplHappyPath() {
		when(restTemplate.getForEntity(url, DrugstoreApiOuput[].class))
				.thenReturn(ResponseEntity.ok().body(TestObj.getDrugtoreApiOutputArray()));
		assertEquals(10, gateway.getDrugStores().size());
	}
	@Test
	void testDrugstoreServiceImplHappyPathNull() {	
		Assertions.assertThrows(GatewayException.class, () -> {
			when(restTemplate.getForEntity(url, DrugstoreApiOuput[].class))
			.thenReturn(null);
			gateway.getDrugStores();
		});
	}

}
