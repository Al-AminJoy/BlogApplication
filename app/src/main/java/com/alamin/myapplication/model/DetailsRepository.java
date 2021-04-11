package com.alamin.myapplication.model;

import android.app.Application;

import com.alamin.myapplication.database.entity.BlogModel;
import com.alamin.myapplication.database.repository.Repository;

public class DetailsRepository {
    private Repository repository;
    private Application application;

    public DetailsRepository(Application application) {
        this.application = application;
        repository = new Repository(application);
    }

    public void updateBlog(long id, String title, String description) {
        repository.updateBlog(id, title, description);
    }

    public BlogModel findBlogById(long id) {
        return repository.findBlogWithAuthor(id);
    }
}
