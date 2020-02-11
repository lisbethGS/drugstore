package consorcio.example.drugstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "consorcio.example"} )
public class DrugstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(DrugstoreApplication.class, args);
	}

}
