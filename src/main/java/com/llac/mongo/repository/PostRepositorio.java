package com.llac.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.llac.mongo.domain.entities.Post;

@Repository
public interface PostRepositorio extends MongoRepository<Post, String> { 

}
