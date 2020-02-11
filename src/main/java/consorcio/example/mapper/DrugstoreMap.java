package consorcio.example.mapper;

import org.modelmapper.ModelMapper;

import consorcio.example.domain.Drugstore;
import consorcio.example.domain.DrugstoreApiOuput;

public class DrugstoreMap {

	public static Drugstore map(DrugstoreApiOuput outputApi) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(outputApi, Drugstore.class);
	}
}
