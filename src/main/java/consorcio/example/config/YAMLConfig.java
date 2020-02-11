package consorcio.example.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class YAMLConfig {
  
    private String location;
    private String drugstores;
    
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDrugstores() {
		return drugstores;
	}
	public void setDrugstores(String drugstores) {
		this.drugstores = drugstores;
	}
 
}
