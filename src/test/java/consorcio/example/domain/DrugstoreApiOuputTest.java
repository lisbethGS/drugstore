package consorcio.example.domain;





import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import consorcio.example.config.AppConfig;

@SpringBootTest
@ContextConfiguration(classes = AppConfig.class)
class DrugstoreApiOuputTest {

	@Test
	void test() {
		DrugstoreApiOuput drugstoreApi =  TestObj.getDrugtoreApiOutput("BUIN","AHUMADA");
	
		assertEquals("BUIN",drugstoreApi.getComuna_nombre());
		assertEquals("local_direccion",drugstoreApi.getLocal_direccion());
		assertEquals("local_lat",drugstoreApi.getLocal_lat());
		assertEquals("local_lng",drugstoreApi.getLocal_lng());
		assertEquals("fecha",drugstoreApi.getFecha());
		assertEquals("fk_comuna",drugstoreApi.getFk_comuna());
		assertEquals("fk_region",drugstoreApi.getFk_region());
		assertEquals("funcionamiento_dia",drugstoreApi.getFuncionamiento_dia());
		assertEquals("funcionamiento_hora_apertura",drugstoreApi.getFuncionamiento_hora_apertura());
		assertEquals("funcionamiento_hora_cierre",drugstoreApi.getFuncionamiento_hora_cierre());
		assertEquals("local_id",drugstoreApi.getLocal_id());
		assertEquals("AHUMADA",drugstoreApi.getLocal_nombre());
		assertEquals("local_telefono",drugstoreApi.getLocal_telefono());
		assertEquals("localidad_nombre",drugstoreApi.getLocalidad_nombre());
		
	}

}
