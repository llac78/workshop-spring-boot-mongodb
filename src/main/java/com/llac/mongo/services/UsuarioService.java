package com.llac.mongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.llac.mongo.domain.entities.Usuario;
import com.llac.mongo.repository.UsuarioRepositorio;
import com.llac.mongo.services.exceptions.ObjetoNaoEncontradoException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	public List<Usuario> listar(){
		
		List<Usuario> lista = usuarioRepositorio.findAll();
		
		return lista;
	}
	
	public Usuario buscarPorId(String id) {
		Optional<Usuario> usuario = usuarioRepositorio.findById(id);
		
		return usuario.orElseThrow(() -> new ObjetoNaoEncontradoException("Objeto não encontrado no DB"));
	}

}
