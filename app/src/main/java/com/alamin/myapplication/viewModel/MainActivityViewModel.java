package com.alamin.myapplication.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.alamin.myapplication.model.BlogRepository;

public class MainActivityViewModel extends AndroidViewModel {
    private BlogRepository repository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        repository = new BlogRepository(application);
    }

    public void loadData() {
        repository.loadData();
    }
}
