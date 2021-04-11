package com.alamin.myapplication.database.entity;

import androidx.room.PrimaryKey;

import com.alamin.myapplication.model.Author;

import java.util.List;

public class BlogModel {
    @PrimaryKey(autoGenerate = true)
    private int blog_model_id;
    private int blogId;
    private Integer id;
    private String title;
    private String description;
    private String coverPhoto;
    private Author author;
    private List<Categories> categories;

    public BlogModel(int blogId, Integer id, String title, String description, String coverPhoto, Author author, List<Categories> categories) {
        this.blogId = blogId;
        this.id = id;
        this.title = title;
        this.description = description;
        this.coverPhoto = coverPhoto;
        this.author = author;
        this.categories = categories;
    }

    public int getBlog_model_id() {
        return blog_model_id;
    }

    public void setBlog_model_id(int blog_model_id) {
        this.blog_model_id = blog_model_id;
    }

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(String coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Categories> getCategories() {
        return categories;
    }

    public void setCategories(List<Categories> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "BlogModel{" +
                "blog_model_id=" + blog_model_id +
                ", blogId=" + blogId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", coverPhoto='" + coverPhoto + '\'' +
                ", author=" + author +
                ", categories=" + categories +
                '}';
    }
}
