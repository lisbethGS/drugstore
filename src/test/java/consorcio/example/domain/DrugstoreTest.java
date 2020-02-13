package consorcio.example.domain;



import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import consorcio.example.config.AppConfig;


@SpringBootTest
@ContextConfiguration(classes = AppConfig.class)
class DrugstoreTest {

	@Test
	void test() {
		Drugstore drugstore =  TestObj.getDrugtore();
		
		assertEquals("address",drugstore.getAddress());
		assertEquals("latitude",drugstore.getLatitude());
		assertEquals("longitude",drugstore.getLongitude());
		assertEquals("name",drugstore.getName());
		assertEquals("phone",drugstore.getPhone());
	}

}
