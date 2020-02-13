package consorcio.example.domain;

import java.util.ArrayList;
import java.util.List;

public class TestObj {

	public static Drugstore getDrugtore() {
		Drugstore drugstore =  new Drugstore();
		drugstore.setAddress("address");
		drugstore.setLatitude("latitude");
		drugstore.setLongitude("longitude");
		drugstore.setName("name");
		drugstore.setPhone("phone");
		return drugstore;
	}
	public static DrugstoreApiOuput getDrugtoreApiOutput(String nombreComuna,String localNombre ) {
		DrugstoreApiOuput drugstoreApi = new DrugstoreApiOuput();
		drugstoreApi.setComuna_nombre(nombreComuna);
		drugstoreApi.setLocal_direccion("local_direccion");
		drugstoreApi.setLocal_lat("local_lat");
		drugstoreApi.setLocal_lng("local_lng");
		drugstoreApi.setFecha("fecha");
		drugstoreApi.setFecha("fecha");
		drugstoreApi.setFk_comuna("fk_comuna");
		drugstoreApi.setFk_region("fk_region");
		drugstoreApi.setFuncionamiento_dia("funcionamiento_dia");
		drugstoreApi.setFuncionamiento_hora_apertura("funcionamiento_hora_apertura");
		drugstoreApi.setFuncionamiento_hora_cierre("funcionamiento_hora_cierre");
		drugstoreApi.setLocal_id("local_id");
		drugstoreApi.setLocal_nombre(localNombre);
		drugstoreApi.setLocal_telefono("local_telefono");
		drugstoreApi.setLocalidad_nombre("localidad_nombre");
		return drugstoreApi;
	}
	public static List<DrugstoreApiOuput> getDrugtoreApiOutputList() {

		List<DrugstoreApiOuput> list = new ArrayList<DrugstoreApiOuput>();
		list.add(getDrugtoreApiOutput("BUIN","AHUMADA"));
		list.add(getDrugtoreApiOutput("BUIN","CRUZ VERDE"));
		list.add(getDrugtoreApiOutput("RECOLETA","CRUZ VERDE"));
		list.add(getDrugtoreApiOutput("RECOLETA","AHUMADA"));
		list.add(getDrugtoreApiOutput("PIRQUE","AHUMADA"));
		list.add(getDrugtoreApiOutput("PIRQUE",""));
		list.add(getDrugtoreApiOutput("PIRQUE",""));
		list.add(getDrugtoreApiOutput("BUIN",null));
		list.add(null);
		return list;
	}
	public static DrugstoreApiOuput[] getDrugtoreApiOutputArray() {

		DrugstoreApiOuput[] array = new DrugstoreApiOuput[10];
		array[0]=getDrugtoreApiOutput("BUIN","AHUMADA");
		array[1]=getDrugtoreApiOutput("BUIN","AHUMADA");
		array[2]=getDrugtoreApiOutput("BUIN","CRUZ VERDE");
		array[3]=getDrugtoreApiOutput("RECOLETA","CRUZ VERDE");
		array[4]=getDrugtoreApiOutput("RECOLETA","AHUMADA");
		array[5]=getDrugtoreApiOutput("PIRQUE","AHUMADA");
		array[6]=getDrugtoreApiOutput("PIRQUE","");
		array[7]=getDrugtoreApiOutput("PIRQUE","");
		array[8]=getDrugtoreApiOutput("BUIN",null);
		array[9]=null;
		return array;
	}
}
