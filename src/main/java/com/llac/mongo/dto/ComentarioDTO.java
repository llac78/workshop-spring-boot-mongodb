package com.llac.mongo.dto;

import java.io.Serializable;
import java.util.Date;

public class ComentarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String texto;
	private Date date;
	private AutorDTO autorDTO;
	
	public ComentarioDTO() {
	}

	public ComentarioDTO(String texto, Date date, AutorDTO autorDTO) {
		super();
		this.texto = texto;
		this.date = date;
		this.autorDTO = autorDTO;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public AutorDTO getAutorDTO() {
		return autorDTO;
	}

	public void setAutorDTO(AutorDTO autorDTO) {
		this.autorDTO = autorDTO;
	}
	
	
}
