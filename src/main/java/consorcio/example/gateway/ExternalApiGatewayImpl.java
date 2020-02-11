package consorcio.example.gateway;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import consorcio.example.config.YAMLConfig;
import consorcio.example.domain.DrugstoreApiOuput;

@Component
public class ExternalApiGatewayImpl implements ExternalApiGateway {
	
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	YAMLConfig properties;

	@Override
	public String getLocation(int locationId) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.MULTIPART_FORM_DATA));
		headers.add("Content-Type", "multipart/form-data");
		MultiValueMap<String, Object> multipartRequest = new LinkedMultiValueMap<>();
		multipartRequest.add("reg_id", locationId);
		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(multipartRequest, headers);
		
		ResponseEntity<String> entityResp=restTemplate.exchange(properties.getLocation(), HttpMethod.POST, requestEntity, String.class);
		return entityResp.getBody();
	}

	@Override
	public List<DrugstoreApiOuput> getDrugStores(int locationId) {
		//support for all mediatypes response
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();        
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));        
		messageConverters.add(converter);  
		restTemplate.setMessageConverters(messageConverters); 
		
		ResponseEntity<DrugstoreApiOuput[]> entityResp=restTemplate.getForEntity(properties.getDrugstores(),DrugstoreApiOuput[].class);
		return Arrays.asList(entityResp.getBody());
	}


}
