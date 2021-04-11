
package com.alamin.myapplication.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Blog {

    @SerializedName("blogs")
    @Expose
    private List<Blog__1> blogs = null;

    public List<Blog__1> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog__1> blogs) {
        this.blogs = blogs;
    }

}
