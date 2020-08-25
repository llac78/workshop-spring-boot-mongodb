package com.llac.mongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.llac.mongo.domain.entities.Post;
import com.llac.mongo.domain.entities.Usuario;
import com.llac.mongo.dto.AutorDTO;
import com.llac.mongo.dto.ComentarioDTO;
import com.llac.mongo.repository.PostRepositorio;
import com.llac.mongo.repository.UsuarioRepositorio;

@Configuration
public class Configuracao implements CommandLineRunner {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	@Autowired
	private PostRepositorio postRepositorio;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		usuarioRepositorio.deleteAll();
		postRepositorio.deleteAll();
		
		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com");
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com");
		Usuario u3 = new Usuario(null, "Bob Grey", "bob@gmail.com");
		
		usuarioRepositorio.saveAll(Arrays.asList(u1, u2, u3));
		
		Post p1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Indo visitar a Europa", new AutorDTO(u1));
		Post p2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Estou na Europa",  new AutorDTO(u1));
		
		ComentarioDTO c1 = new ComentarioDTO("Boa viagem, mano!", sdf.parse("21/03/2018"), new AutorDTO(u2));
		ComentarioDTO c2 = new ComentarioDTO("Aproveite", sdf.parse("22/03/2018"), new AutorDTO(u3));
		ComentarioDTO c3 = new ComentarioDTO("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AutorDTO(u2));
		
		p1.getComentarios().addAll(Arrays.asList(c1, c2));
		p2.getComentarios().addAll(Arrays.asList(c3));
		
		postRepositorio.saveAll(Arrays.asList(p1, p2));
		
		u1.getPosts().addAll(Arrays.asList(p1, p2));
		usuarioRepositorio.save(u1);
	}
}
