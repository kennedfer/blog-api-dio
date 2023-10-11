package com.kennedfer.blogapidio.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;

@Document
public class Post {

    @Id
    private String id;
    @NotNull(message = "Titulo nao pode ser nulo")
    private String title;

    @NotNull(message = "Conteudo nao pode ser nulo")
    private String content;

    public String getTitle() {
        return title;
    }

    public String getId() {
        return this.id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Post(String id, String title, String content) {
        super();

        this.id = id;
        this.content = content;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Post [id=" + id + ", title=" + title + ", content=" + content + "]";
    }
}