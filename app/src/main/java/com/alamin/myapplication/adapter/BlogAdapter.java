package com.alamin.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alamin.myapplication.utils.FragmentCommunication;
import com.alamin.myapplication.R;
import com.alamin.myapplication.database.entity.Blogs;
import com.alamin.myapplication.viewHolder.BlogViewHolder;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BlogAdapter extends RecyclerView.Adapter<BlogViewHolder> {
    private Context context;
    private List<Blogs> blog_List;
    private FragmentCommunication communication;

    public BlogAdapter(Context context, List<Blogs> blog_List, FragmentCommunication communication) {
        this.context = context;
        this.blog_List = blog_List;
        this.communication = communication;
    }

    @NonNull
    @Override
    public BlogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.blog_layout, parent, false);
        return new BlogViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BlogViewHolder holder, int position) {
        Blogs blog = blog_List.get(position);
        Picasso.with(context).load(blog.getCoverPhoto()).into(holder.ivCover);
        holder.tvTitle.setText(blog.getTitle());
        holder.ivCover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                communication.respond(blog.getBlogId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return blog_List.size();
    }

    public void getAllDatas(List<Blogs> blog_List) {
        this.blog_List = blog_List;
    }

}
