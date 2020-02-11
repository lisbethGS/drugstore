package consorcio.example.service;

import java.util.List;

import consorcio.example.domain.Drugstore;

public interface DrugstoreService {
	List<Drugstore> getDrugstoreByLocation(String locationName, String drugstoreName);
}
