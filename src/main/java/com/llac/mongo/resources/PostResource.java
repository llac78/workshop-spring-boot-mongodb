package com.llac.mongo.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.llac.mongo.domain.entities.Post;
import com.llac.mongo.resources.util.URL;
import com.llac.mongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
	
	@Autowired
	private PostService postService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> buscarPorId(@PathVariable String id){
		
		Post post = postService.buscarPorId(id);
		
		return ResponseEntity.ok().body(post);
	}
	
	@GetMapping(value = "/buscatitulo")
	public ResponseEntity<List<Post>> findByTitle(
										@RequestParam(value="text", defaultValue = "") 
										String texto){
		
		texto = URL.decodeParametro(texto);
		
		List<Post> lista = postService.findByTitle(texto);
		
		return ResponseEntity.ok().body(lista);
	}

	@GetMapping(value="/fullsearch")
 	public ResponseEntity<List<Post>> fullSearch(
 			@RequestParam(value="text", defaultValue="") String text,
 			@RequestParam(value="minDate", defaultValue="") String minDate,
 			@RequestParam(value="maxDate", defaultValue="") String maxDate) {
		text = URL.decodeParametro(text);
		Date min = URL.convertDate(minDate, new Date(0L)); //01-01-1970
		Date max = URL.convertDate(maxDate, new Date());
		List<Post> list = postService.fullSearch(text, min, max);
		return ResponseEntity.ok().body(list);
	}
	
}
