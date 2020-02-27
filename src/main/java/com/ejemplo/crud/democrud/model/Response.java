package com.ejemplo.crud.democrud.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

/**
 * 
 * @author Victor.Sosa
 *
 * @param <T>
 */
@Data
@JsonInclude(value = Include.NON_EMPTY, content = Include.NON_NULL)
public class Response<T> {
	private String code;
	private String detailMessage;
	/**
	 * un generico puede recibir lo que sea una lista o un objeto o un parametro por
	 * referencia
	 */
	private T data;
}
