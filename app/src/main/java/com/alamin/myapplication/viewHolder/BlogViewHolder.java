package com.alamin.myapplication.viewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alamin.myapplication.R;

public class BlogViewHolder extends RecyclerView.ViewHolder {
    public TextView tvTitle;
    public ImageView ivCover;

    public BlogViewHolder(@NonNull View itemView) {
        super(itemView);
        tvTitle = itemView.findViewById(R.id.tv_blog_lay_title);
        ivCover = itemView.findViewById(R.id.iv_blog_lay_cover);
    }
}
