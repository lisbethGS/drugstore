package consorcio.example.gateway;

import java.util.List;

import consorcio.example.domain.DrugstoreApiOuput;

public interface ExternalApiGateway {
	List<DrugstoreApiOuput> getDrugStores();
}
