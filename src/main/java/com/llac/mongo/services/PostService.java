package com.llac.mongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.llac.mongo.domain.entities.Post;
import com.llac.mongo.repository.PostRepositorio;
import com.llac.mongo.services.exceptions.ObjetoNaoEncontradoException;

@Service
public class PostService {
	
	@Autowired
	private PostRepositorio postRepositorio;
	
	public Post buscarPorId(String id) {
		
		Optional<Post> post = postRepositorio.findById(id);
		
		return post.orElseThrow(() -> new ObjetoNaoEncontradoException("Objeto não encontrado no DB"));
	}
	
	public List<Post> findByTitle(String texto){
		return postRepositorio.findByTitle(texto);
	}
	
	public List<Post> fullSearch(String texto, Date minDate, Date maxDate) {
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return postRepositorio.fullSearch(texto, minDate, maxDate);
	}
}
