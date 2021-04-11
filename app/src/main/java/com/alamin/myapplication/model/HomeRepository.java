package com.alamin.myapplication.model;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.alamin.myapplication.database.entity.Blogs;
import com.alamin.myapplication.database.repository.Repository;

import java.util.List;

public class HomeRepository {
    private Repository repository;
    private Application application;
    public LiveData<List<Blogs>> getAllBlog;

    public HomeRepository(Application application) {
        this.application = application;
        repository = new Repository(application);
    }

    public LiveData<List<Blogs>> loadData() {
        getAllBlog = repository.getAllBlog();
        return getAllBlog;
    }
}
