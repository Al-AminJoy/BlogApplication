package com.alamin.myapplication.view.fragement;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alamin.myapplication.databinding.UpdateDialogBinding;
import com.alamin.myapplication.utils.FragmentCommunication;
import com.alamin.myapplication.database.entity.Blogs;
import com.alamin.myapplication.R;
import com.alamin.myapplication.adapter.BlogAdapter;
import com.alamin.myapplication.databinding.FragmentHomeBinding;
import com.alamin.myapplication.viewModel.HomeViewModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements View.OnClickListener {
    private FragmentHomeBinding binding;
    private HomeViewModel homeViewModel;
    private List<Blogs> getBlogList = new ArrayList<>();
    private BlogAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRecyclerView();
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        adapter = new BlogAdapter(getContext(), getBlogList, communication);
        homeViewModel.getAllBlog().observe(getActivity(), new Observer<List<Blogs>>() {
            @Override
            public void onChanged(List<Blogs> blog) {
                binding.recyclerView.setAdapter(adapter);
                adapter.getAllDatas(blog);
            }
        });
        binding.floatingButton.setOnClickListener(this);
    }

    private void initRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        binding.recyclerView.setLayoutManager(linearLayoutManager);
        binding.recyclerView.setHasFixedSize(true);
    }

    FragmentCommunication communication = new FragmentCommunication() {
        @Override
        public void respond(long id) {
            BlogDetailsFragment fragment = new BlogDetailsFragment();
            Bundle bundle = new Bundle();
            bundle.putLong("ID", id);
            fragment.setArguments(bundle);
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_panel, fragment).addToBackStack(null).commit();
        }
    };

    @Override
    public void onClick(View v) {
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_panel, new CreateFragment()).commit();
    }
}