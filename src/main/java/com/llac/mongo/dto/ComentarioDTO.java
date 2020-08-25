package com.llac.mongo.dto;

import java.io.Serializable;
import java.util.Date;

public class ComentarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String texto;
	private Date data;
	private AutorDTO autorDTO;
	
	public ComentarioDTO() {
	}

	public ComentarioDTO(String texto, Date data, AutorDTO autorDTO) {
		super();
		this.texto = texto;
		this.data = data;
		this.autorDTO = autorDTO;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public AutorDTO getAutorDTO() {
		return autorDTO;
	}

	public void setAutorDTO(AutorDTO autorDTO) {
		this.autorDTO = autorDTO;
	}
	
	
}
