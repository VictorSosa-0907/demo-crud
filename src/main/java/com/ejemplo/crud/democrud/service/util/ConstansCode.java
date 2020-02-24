package com.ejemplo.crud.democrud.service.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
/**
 * 
 * @author Victor.Sosa
 *
 */
@Component
@ConfigurationProperties(prefix = "codes")
public class ConstansCode {

	private String success;
	private String badRequest;
	private String dataNotFound;
	private String exception;

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getBadRequest() {
		return badRequest;
	}

	public void setBadRequest(String badRequest) {
		this.badRequest = badRequest;
	}

	public String getDataNotFound() {
		return dataNotFound;
	}

	public void setDataNotFound(String dataNotFound) {
		this.dataNotFound = dataNotFound;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}
}
