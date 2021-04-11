package com.alamin.myapplication.database.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Blogs {
    @PrimaryKey(autoGenerate = true)
    private int blogId;
    private Integer id;
    private String title;
    private String description;
    private String coverPhoto;

    public Blogs() {
    }

    public Blogs(Integer id, String title, String description, String coverPhoto) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.coverPhoto = coverPhoto;
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

    @Override
    public String toString() {
        return "Blogs{" +
                "blogId=" + blogId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", coverPhoto='" + coverPhoto + '\'' +
                '}';
    }
}
