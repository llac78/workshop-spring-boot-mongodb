package com.llac.mongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.llac.mongo.domain.entities.Post;
import com.llac.mongo.domain.entities.Usuario;
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
		
		
		Post p1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Indo visitar a Europa", u1);
		Post p2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Estou na Europa", u1);
		
		usuarioRepositorio.saveAll(Arrays.asList(u1, u2, u3));
		postRepositorio.saveAll(Arrays.asList(p1, p2));
	}
}
