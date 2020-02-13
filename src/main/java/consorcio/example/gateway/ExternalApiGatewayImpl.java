package consorcio.example.gateway;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import consorcio.example.domain.DrugstoreApiOuput;
import consorcio.example.excepton.GatewayException;

@Component
public class ExternalApiGatewayImpl implements ExternalApiGateway {

	@Autowired
	private RestTemplate restTemplate;
	@Value("${drugstores}")
	private String url;

	@Override
	public List<DrugstoreApiOuput> getDrugStores() {
		try {
			// support for all mediatypes response
			List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
			MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
			converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
			messageConverters.add(converter);
			restTemplate.setMessageConverters(messageConverters);

			ResponseEntity<DrugstoreApiOuput[]> entityResp = restTemplate.getForEntity(url, DrugstoreApiOuput[].class);
			return Arrays.asList(entityResp.getBody());
		} catch (Exception e) {
			throw new GatewayException();
		}
	}
}
