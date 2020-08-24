package com.llac.mongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.llac.mongo.domain.entities.Usuario;
import com.llac.mongo.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService usuarioServico;

	@GetMapping
	public ResponseEntity<List<Usuario>> listar(){
		
		return ResponseEntity.ok().body(usuarioServico.listar());
	}
}
