package com.alamin.myapplication.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.alamin.myapplication.database.entity.BlogModel;
import com.alamin.myapplication.model.DetailsRepository;


public class DetailsViewModel extends AndroidViewModel {
    private DetailsRepository repository;

    public DetailsViewModel(@NonNull Application application) {
        super(application);
        repository = new DetailsRepository(application);
    }

    public void updateBlog(long id, String title, String description) {
        repository.updateBlog(id, title, description);
    }

    public BlogModel findBlogById(long id) {
        return repository.findBlogById(id);
    }

}
