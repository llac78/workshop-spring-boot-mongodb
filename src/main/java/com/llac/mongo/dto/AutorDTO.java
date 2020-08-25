package com.llac.mongo.dto;

import java.io.Serializable;

import com.llac.mongo.domain.entities.Usuario;

public class AutorDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String id;
	private String nome;

	public AutorDTO() {
	}

	public AutorDTO(Usuario usuario) {
		id = usuario.getId();
		nome = usuario.getNome();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	

}
