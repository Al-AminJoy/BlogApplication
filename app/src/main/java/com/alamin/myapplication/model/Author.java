
package com.alamin.myapplication.model;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class Author {
    @PrimaryKey(autoGenerate = true)
    private int authorId;
    private long blog_id;
    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("avatar")
    @Expose
    private String avatar;
    @SerializedName("profession")
    @Expose
    private String profession;

    public Author(long blog_id, Integer id, String name, String avatar, String profession) {
        this.blog_id = blog_id;
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.profession = profession;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public long getBlog_id() {
        return blog_id;
    }

    public void setBlog_id(long blog_id) {
        this.blog_id = blog_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", blog_id=" + blog_id +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", avatar='" + avatar + '\'' +
                ", profession='" + profession + '\'' +
                '}';
    }
}
