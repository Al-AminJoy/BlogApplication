package com.alamin.myapplication.model;

import android.app.Application;

import com.alamin.myapplication.database.entity.Blogs;
import com.alamin.myapplication.database.entity.Categories;
import com.alamin.myapplication.database.repository.Repository;

import java.util.List;

public class CreateRepository {
    private Repository repository;
    private Application application;

    public CreateRepository(Application application) {
        this.application = application;
        repository = new Repository(application);
    }

    public long createBlog(Blogs blogs) {
        long id = repository.insertBlog(blogs);
        return id;
    }

    public void createCategory(List<Categories> categories) {
        repository.insertCategory(categories);
    }

    public void createAuthor(List<Author> authors) {
        repository.insertAuthor(authors);
    }
}
