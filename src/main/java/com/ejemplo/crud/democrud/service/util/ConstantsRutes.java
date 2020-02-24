package com.ejemplo.crud.democrud.service.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Victor.Sosa
 * Constantes de rutas de pruebas de test
 */
@Component
@ConfigurationProperties(prefix = "tets")
public class ConstantsRutes {
	private String all;
	private String save;
	private String update;
	private String delete;
	
	
	public String getAll() {
		return all;
	}
	public void setAll(String all) {
		this.all = all;
	}
	public String getSave() {
		return save;
	}
	public void setSave(String save) {
		this.save = save;
	}
	public String getUpdate() {
		return update;
	}
	public void setUpdate(String update) {
		this.update = update;
	}
	public String getDelete() {
		return delete;
	}
	public void setDelete(String delete) {
		this.delete = delete;
	}
}
