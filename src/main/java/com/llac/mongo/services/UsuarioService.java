package com.llac.mongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.llac.mongo.domain.entities.Usuario;
import com.llac.mongo.dto.UsuarioDTO;
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
	
	public Usuario inserir(Usuario usuario) {
		return usuarioRepositorio.insert(usuario);
	}
	
	public void deletar(String id) {
		buscarPorId(id);
		usuarioRepositorio.deleteById(id);
	}

	public Usuario fromDTO(UsuarioDTO usuarioDTO) {
		return new Usuario(usuarioDTO.getId(), usuarioDTO.getNome(), usuarioDTO.getEmail());
	}

}
