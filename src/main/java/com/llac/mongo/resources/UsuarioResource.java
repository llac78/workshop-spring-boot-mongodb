package com.llac.mongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping
	public ResponseEntity<Void> inserir(@RequestBody UsuarioDTO usuarioDTO){
		
		Usuario usuario = usuarioService.fromDTO(usuarioDTO);
		usuario = usuarioService.inserir(usuario);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId()).toUri();
		
		return ResponseEntity.created(uri).build(); //created retorna o código 201 (quando um novo recurso é criado)
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletar(@PathVariable String id){
		
		usuarioService.deletar(id);;
		
		return ResponseEntity.noContent().build(); // quando a operação não tem que retornar nada, a resposta é com o código 204
	}

}
