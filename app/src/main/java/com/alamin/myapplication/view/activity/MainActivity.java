package com.alamin.myapplication.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.alamin.myapplication.R;
import com.alamin.myapplication.databinding.ActivityMainBinding;
import com.alamin.myapplication.view.fragement.BlogDetailsFragment;
import com.alamin.myapplication.view.fragement.CreateFragment;
import com.alamin.myapplication.view.fragement.HomeFragment;
import com.alamin.myapplication.viewModel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    private MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.main_panel, new HomeFragment()).addToBackStack(null).commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        mainActivityViewModel.loadData();
    }

    @Override
    public void onBackPressed() {
        Fragment frag = getSupportFragmentManager().findFragmentById(R.id.main_panel);
        if (frag instanceof CreateFragment) {
            getSupportFragmentManager().beginTransaction().replace(R.id.main_panel, new HomeFragment()).commit();
        } else if (frag instanceof BlogDetailsFragment) {
            getSupportFragmentManager().beginTransaction().replace(R.id.main_panel, new HomeFragment()).commit();
        } else {
            finish();
        }

    }
}