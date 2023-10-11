package com.kennedfer.blogapidio.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.kennedfer.blogapidio.model.Post;

public interface ItemRepository extends MongoRepository<Post, String> {
    @Query("{id:'?0'}")
    Post findPostById(int id);

    @Query("{}")
    List<Post> findAll();

    public long count();
}
