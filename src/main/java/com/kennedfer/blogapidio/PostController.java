package com.kennedfer.blogapidio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kennedfer.blogapidio.hooks.PostsHooks;
import com.kennedfer.blogapidio.model.Post;
import com.kennedfer.blogapidio.repository.ItemRepository;

@RestController
public class PostController {

    @Autowired
    ItemRepository postRepository;

    @GetMapping("/posts/{id}")
    Post one(@PathVariable int id) {
        return postRepository.findPostById(id);
    }

    @GetMapping("/posts/all")
    List<Post> all() {
        return postRepository.findAll();
    }

    @PostMapping("/new-post")
    public ResponseEntity<String> save(@RequestBody Post postData) {
        if (PostsHooks.requestDataIsValid(postData)) {
            postRepository.save(postData);
            return ResponseEntity.ok("Salvo");
        } else {
            return ResponseEntity.badRequest().body("Body invalido");
        }
    }

    @DeleteMapping("/delete-post/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        if (PostsHooks.postExists(id)) {
            postRepository.deleteById(id);
            return ResponseEntity.ok("Post deletado com sucesso");
        } else {
            return ResponseEntity.badRequest().body("Post não encontrado");
        }
    }

    @PatchMapping("/edit-post")
    public ResponseEntity<String> patch(@RequestBody Post postUpdated) {
        if (PostsHooks.postExists(postUpdated.getId()) && PostsHooks.requestDataIsValid(postUpdated)) {
            postRepository.save(postUpdated);
            return ResponseEntity.ok("Post atualizado com sucesso");
        } else {
            return ResponseEntity.badRequest().body("Post não encontrado");
        }
    }
}
