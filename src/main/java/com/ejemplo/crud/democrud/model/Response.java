package com.ejemplo.crud.democrud.model;
/**
 * 
 * @author Victor.Sosa
 *
 * @param <T>
 */
public class Response<T> {
	private String code;
	private String detailMessage;
	private T data;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDetailMessage() {
		return detailMessage;
	}

	public void setDetailMessage(String detailMessage) {
		this.detailMessage = detailMessage;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
