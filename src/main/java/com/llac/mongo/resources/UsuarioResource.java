package com.llac.mongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.llac.mongo.domain.entities.Usuario;
import com.llac.mongo.dto.UsuarioDTO;
import com.llac.mongo.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> listar(){
		
		List<Usuario> usuarios = usuarioService.listar();
		List<UsuarioDTO> dtos = usuarios.stream().map(usuarioDTO -> new UsuarioDTO(usuarioDTO)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(dtos);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UsuarioDTO> buscarPorId(@PathVariable String id){
		
		Usuario usuario = usuarioService.buscarPorId(id);
		
		return ResponseEntity.ok().body(new UsuarioDTO(usuario));
	}
}
