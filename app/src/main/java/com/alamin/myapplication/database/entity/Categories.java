package com.alamin.myapplication.database.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Categories {
    @PrimaryKey(autoGenerate = true)
    private int category_id;
    private long blog_id;
    private String categoryName;

    public Categories() {
    }

    public Categories(long blog_id, String categoryName) {
        this.blog_id = blog_id;
        this.categoryName = categoryName;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public long getBlog_id() {
        return blog_id;
    }

    public void setBlog_id(long blog_id) {
        this.blog_id = blog_id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Categories{" +
                "category_id=" + category_id +
                ", blog_id=" + blog_id +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
