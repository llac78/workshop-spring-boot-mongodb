package com.llac.mongo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.llac.mongo.domain.entities.Post;

@Repository
public interface PostRepositorio extends MongoRepository<Post, String> { 

	List<Post> findByTitleContainingIgnoreCase(String texto);
	
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> findByTitle(String texto);
	
	@Query("{ $and: [ { date: {$gte: ?1} }, { date: { $lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comentarios.texto': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Post> fullSearch(String text, Date minDate, Date maxDate);
	
}
