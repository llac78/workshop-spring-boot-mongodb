package com.llac.mongo.services;

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
	
	
}
