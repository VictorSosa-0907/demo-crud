package com.ejemplo.crud.democrud.service.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * 
 * @author Victor.Sosa Constantes de rutas de pruebas de test
 */
@Data
@Component
@ConfigurationProperties(prefix = "tets")
public class ConstantsRutes {

	private String all;
	private String save;
	private String update;
	private String delete;
}