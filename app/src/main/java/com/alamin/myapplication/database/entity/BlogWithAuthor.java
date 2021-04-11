package com.alamin.myapplication.database.entity;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.alamin.myapplication.model.Author;

import java.util.List;

public class BlogWithAuthor {
    @Embedded
    Blogs blogs;
    @Relation(parentColumn = "blogId", entityColumn = "blog_id")
    public List<Author> author;

    public Blogs getBlogs() {
        return blogs;
    }

    public void setBlogs(Blogs blogs) {
        this.blogs = blogs;
    }

    public List<Author> getAuthor() {
        return author;
    }

    public void setAuthor(List<Author> author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "BlogWithAuthor{" +
                "blogs=" + blogs.toString() +
                ", author=" + author.toString() +
                '}';
    }
}
