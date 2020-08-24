package com.llac.mongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.llac.mongo.domain.entities.Usuario;
import com.llac.mongo.repository.UsuarioRepositorio;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	public List<Usuario> listar(){
		
		List<Usuario> lista = usuarioRepositorio.findAll();
		
		return lista;
	}

}
