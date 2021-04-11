package com.alamin.myapplication.database.entity;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class BlogWithCategory {
    @Embedded
    public Blogs blogs;
    @Relation(parentColumn = "blogId", entityColumn = "blog_id")
    public List<Categories> categories;

    public Blogs getBlog() {
        return blogs;
    }

    public void setBlog(Blogs blogs) {
        this.blogs = blogs;
    }

    @Override
    public String toString() {
        return "BlogWithCategory{" +
                "blogs=" + blogs.toString() +
                ", author=" + categories.toString() +
                '}';
    }
}
