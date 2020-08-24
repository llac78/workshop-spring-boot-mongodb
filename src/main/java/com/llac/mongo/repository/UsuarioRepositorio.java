package com.llac.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.llac.mongo.domain.entities.Usuario;

@Repository
public interface UsuarioRepositorio extends MongoRepository<Usuario, String> { //String é o tipo do id da classe Usuario

}
