package com.alamin.myapplication.view.fragement;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.alamin.myapplication.R;
import com.alamin.myapplication.database.entity.Blogs;
import com.alamin.myapplication.database.entity.Categories;
import com.alamin.myapplication.databinding.FragmentCreateBinding;
import com.alamin.myapplication.model.Author;
import com.alamin.myapplication.viewModel.CreateViewModel;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class CreateFragment extends Fragment implements View.OnClickListener {
    private FragmentCreateBinding binding;
    private CreateViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_create, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(getActivity()).get(CreateViewModel.class);
        binding.btCreate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        List<Categories> categories = new ArrayList<>();
        List<Author> authorList = new ArrayList<>();
        String title = binding.etTitle.getText().toString();
        String description = binding.etDescription.getText().toString();
        Blogs blog = new Blogs(null, title, description, "https://i.picsum.photos/id/608/200/300.jpg?hmac=b-eDmVyhr3rI_4k3z2J_PNwOxEwSKa5EDC9uFH4jERU");
        long id = viewModel.insertBlog(blog);
        if (binding.cbBusiness.isChecked()) {
            categories.add(new Categories(id, "Business"));
        }
        if (binding.cbEntertainment.isChecked()) {
            categories.add(new Categories(id, "Entertainment"));
        }
        if (binding.cbLifestyle.isChecked()) {
            categories.add(new Categories(id, "Lifestyle"));
        }
        if (binding.cbProductivity.isChecked()) {
            categories.add(new Categories(id, "Productivity"));
        }
        viewModel.insertCategory(categories);
        authorList.add(new Author(id, 1, "John Doe", "https://i.pravatar.cc/250", "Content Writer"));
        viewModel.insertAuthor(authorList);
        Toast.makeText(getContext(), R.string.success_message, Toast.LENGTH_SHORT).show();
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_panel, new HomeFragment()).commit();
    }
}