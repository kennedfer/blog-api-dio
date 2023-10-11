package com.kennedfer.blogapidio.hooks;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.kennedfer.blogapidio.model.Post;
import com.kennedfer.blogapidio.repository.ItemRepository;

public class PostsHooks {
    @Autowired
    static ItemRepository postRepository;

    public static boolean postExists(String id) {
        Optional<Post> post = postRepository.findById(id);
        return post.isPresent();
    }

    public static boolean requestDataIsValid(Post requestData) {
        Optional<String> id = Optional.ofNullable(requestData.getId());
        Optional<String> title = Optional.ofNullable(requestData.getTitle());
        Optional<String> content = Optional.ofNullable(requestData.getContent());

        return id.isPresent() && title.isPresent() && content.isPresent();
    }
}
