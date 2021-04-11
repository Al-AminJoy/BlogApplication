package com.alamin.myapplication.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.alamin.myapplication.database.entity.Blogs;
import com.alamin.myapplication.model.HomeRepository;

import java.util.List;

public class HomeViewModel extends AndroidViewModel {
    private HomeRepository repository;

    public HomeViewModel(@NonNull Application application) {
        super(application);
        repository = new HomeRepository(application);
    }

    public LiveData<List<Blogs>> getAllBlog() {
        return repository.loadData();
    }
}