package consorcio.example.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Drugstore {

	private String name;
	private String address;
	private String phone;
	private String latitude;
	private String longitude;
	@JsonProperty("NombreLocal")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@JsonProperty("Direccion")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@JsonProperty("Telefono")
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@JsonProperty("Latitud")
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	@JsonProperty("Longitud")
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

}
