package com.alamin.myapplication.view.fragement;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.alamin.myapplication.R;
import com.alamin.myapplication.database.entity.BlogModel;
import com.alamin.myapplication.databinding.FragmentBlogDetailsBinding;
import com.alamin.myapplication.databinding.UpdateDialogBinding;
import com.alamin.myapplication.viewModel.DetailsViewModel;
import com.squareup.picasso.Picasso;

public class BlogDetailsFragment extends Fragment {
    private long id;
    private FragmentBlogDetailsBinding binding;
    private BlogModel data;
    private DetailsViewModel viewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        id = getArguments().getLong("ID");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_blog_details, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(getActivity()).get(DetailsViewModel.class);
        data = viewModel.findBlogById(id);
        binding.tvDetailsTitle.setText(data.getTitle());
        binding.tvDetailsDescription.setText(data.getDescription());
        binding.tvDetailsAuthor.setText(data.getAuthor().getName());
        binding.tvDetailsProfession.setText(data.getAuthor().getProfession());
        Picasso.with(getContext()).load(data.getCoverPhoto()).into(binding.ivDetailsCover);
        Picasso.with(getContext()).load(data.getAuthor().getAvatar()).into(binding.ivDetailsAuthor);
        StringBuilder result = new StringBuilder();
        result.append("Category : ");
        for (int i = 0; i < data.getCategories().size(); i++) {
            if (i == 0) {
                result.append(data.getCategories().get(i).getCategoryName());
            } else {
                result.append("," + data.getCategories().get(i).getCategoryName());
            }
        }
        binding.tvDetailsCategory.setText(result);
        binding.btEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }

    private void showDialog() {
        UpdateDialogBinding updateDialogBinding;
        updateDialogBinding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.update_dialog, null, false);
        final androidx.appcompat.app.AlertDialog alertDialog = new AlertDialog.Builder(getContext())
                .setView(updateDialogBinding.getRoot()).setCancelable(true).create();
        updateDialogBinding.etEditTitle.setText(binding.tvDetailsTitle.getText().toString());
        updateDialogBinding.etEditDescription.setText(binding.tvDetailsDescription.getText().toString());
        updateDialogBinding.btEditSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = updateDialogBinding.etEditTitle.getText().toString();
                String description = updateDialogBinding.etEditDescription.getText().toString();
                viewModel.updateBlog(id, title, description);
                binding.tvDetailsTitle.setText(title);
                binding.tvDetailsDescription.setText(description);
                Toast.makeText(getContext(), R.string.success_message, Toast.LENGTH_LONG).show();
                alertDialog.dismiss();
            }
        });
        alertDialog.show();
    }
}