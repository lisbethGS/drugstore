package consorcio.example.gateway;

import java.util.List;

import consorcio.example.domain.DrugstoreApiOuput;

public interface ExternalApiGateway {
	String getLocation(int locationId);
	List<DrugstoreApiOuput> getDrugStores(int locationId);
}
