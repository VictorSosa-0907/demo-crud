package com.ejemplo.crud.democrud.service.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * 
 * @author Victor.Sosa
 *
 */
@Data
@Component
@ConfigurationProperties(prefix = "message")
public class ConstansMsg {

	private String ok;
	private String succes;
	private String delete;
	private String update;
	private String error;
	private String empty;
	private String exist;
}