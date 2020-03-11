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
@ConfigurationProperties(prefix = "codes" )
public class ConstansCode {

	private String success;
	private String badRequest;
	private String dataNotFound;
	private String exception;
}