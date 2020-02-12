package consorcio.example.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import consorcio.example.domain.Drugstore;
import consorcio.example.domain.DrugstoreApiOuput;
import consorcio.example.gateway.ExternalApiGateway;
@Service
public class DrugstoreServiceImpl implements DrugstoreService {
	
	public static int REG_METROPOLITANA_ID = 7;
	
	@Autowired
	ExternalApiGateway gateway;

	@Override
	public List<Drugstore> getDrugstoreByLocation(String locationName, String drugstoreName) {
		List<DrugstoreApiOuput> apiResponse = gateway.getDrugStores(REG_METROPOLITANA_ID);

		List<Drugstore> result = apiResponse.stream()
				.filter(x -> !StringUtils.isEmpty(x.getComuna_nombre()) && !StringUtils.isEmpty(x.getLocal_nombre())
						&& (x.getComuna_nombre()).equalsIgnoreCase(locationName)
						&& x.getLocal_nombre().toUpperCase().contains(drugstoreName.toUpperCase()))
				.map(temp -> {
					Drugstore obj = new Drugstore();
					obj.setName(temp.getLocal_nombre());
					obj.setAddress(temp.getLocal_direccion());
					obj.setPhone(temp.getLocal_telefono());
					obj.setLatitude(temp.getLocal_lat());
					obj.setLongitude(temp.getLocal_lng());
					return obj;
				}).collect(Collectors.toList());

		return result;
	}

}
