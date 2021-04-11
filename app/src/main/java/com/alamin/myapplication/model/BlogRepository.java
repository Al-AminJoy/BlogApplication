package com.alamin.myapplication.model;

import android.app.Application;

import com.alamin.myapplication.network.APIInterface;
import com.alamin.myapplication.database.entity.Blogs;
import com.alamin.myapplication.database.entity.Categories;
import com.alamin.myapplication.database.repository.Repository;
import com.alamin.myapplication.utils.APIClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BlogRepository {
    private APIInterface apiInterface;
    private Repository repository;
    private Application application;

    public BlogRepository(Application application) {
        this.application = application;
        repository = new Repository(application);
    }

    public void loadData() {
        apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<Blog> call = apiInterface.getAllResources();
        call.enqueue(new Callback<Blog>() {
            @Override
            public void onResponse(Call<Blog> call, Response<Blog> response) {
                Blog resource = response.body();
                repository.deleteBlog();
                Author author;

                List<Author> authors = new ArrayList<>();
                List<Categories> categoriesList = new ArrayList<>();
                for (int i = 0; i < resource.getBlogs().size(); i++) {

                    Blog__1 blog__1 = resource.getBlogs().get(i);
                    Blogs blog = new Blogs();
                    blog.setId(blog__1.getId());
                    blog.setTitle(blog__1.getTitle());
                    blog.setCoverPhoto(blog__1.getCoverPhoto());
                    blog.setDescription(blog__1.getDescription());
                    long id = repository.insertBlog(blog);
                    author = blog__1.getAuthor();
                    author.setBlog_id(id);
                    authors.add(author);
                    for (int j = 0; j < blog__1.getCategories().size(); j++) {
                        String cat = blog__1.getCategories().get(j);
                        Categories category = new Categories(id, cat);
                        categoriesList.add(category);
                    }
                }
                repository.insertCategory(categoriesList);
                repository.insertAuthor(authors);
            }

            @Override
            public void onFailure(Call<Blog> call, Throwable t) {
                call.cancel();
            }
        });
    }
}
