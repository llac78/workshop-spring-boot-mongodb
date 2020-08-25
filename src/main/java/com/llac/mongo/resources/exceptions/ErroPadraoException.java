package com.llac.mongo.resources.exceptions;

import java.io.Serializable;

public class ErroPadraoException implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long timestamp;
	private Integer status;
	private String erro;
	private String msg;
	private String path;

	public ErroPadraoException() {
	}

	public ErroPadraoException(Long timestamp, Integer status, String erro, String msg, String path) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.erro = erro;
		this.msg = msg;
		this.path = path;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	

}
