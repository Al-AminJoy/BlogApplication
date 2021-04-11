package com.alamin.myapplication.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.alamin.myapplication.database.entity.Blogs;
import com.alamin.myapplication.database.entity.Categories;
import com.alamin.myapplication.model.Author;
import com.alamin.myapplication.model.CreateRepository;

import java.util.List;

public class CreateViewModel extends AndroidViewModel {
    private CreateRepository repository;
    public CreateViewModel(@NonNull Application application) {
        super(application);
        repository=new CreateRepository(application);
    }
    public long insertBlog(Blogs blogs){
        return  repository.createBlog(blogs);
    }
    public void insertAuthor(List<Author> authors){
        repository.createAuthor(authors);
    }
    public void insertCategory(List<Categories> categories){
        repository.createCategory(categories);
    }
}
