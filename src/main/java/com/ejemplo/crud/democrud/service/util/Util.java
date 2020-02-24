package com.ejemplo.crud.democrud.service.util;

import org.springframework.stereotype.Component;

/**
 * 
 * @author Victor.Sosa Clase de utilieria para operaciones extra se la capa de
 *         servicio
 */
@Component
public class Util {
	static final String RUTE = "/api/v1/person";

	/**
	 * Gets the url. este metodo lo ocupamos en el momento de hacer test para mapear
	 * la ruta de cada metodo contenido en el controlador
	 * 
	 * @param opc the opc
	 * @return the url
	 */
	public String getUrl(String opc) {
		String method = null;
		switch (opc) {
		case "allPerson":
			method = "/getAllPerson";
			break;
		case "savePerson":
			method = "/savePerson";
			break;
		case "updatePerson":
			method = "/updatePerson";
			break;
		case "deletePerson":
			method = "/deletePerson/";
			break;
		default:
			break;
		}
		return RUTE.concat(method);
	}

}
