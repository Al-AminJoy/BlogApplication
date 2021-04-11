package com.alamin.myapplication.database.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.alamin.myapplication.database.BlogDatabase;
import com.alamin.myapplication.database.dao.BlogDao;
import com.alamin.myapplication.database.entity.BlogModel;
import com.alamin.myapplication.database.entity.BlogWithAuthor;
import com.alamin.myapplication.database.entity.BlogWithCategory;
import com.alamin.myapplication.database.entity.Blogs;
import com.alamin.myapplication.database.entity.Categories;
import com.alamin.myapplication.model.Author;

import java.util.ArrayList;
import java.util.List;

public class Repository {

    public BlogDao blogDao;
    public LiveData<List<Author>> getAllAuthor;
    public LiveData<List<Blogs>> getAllBlog;
    public LiveData<List<Categories>> getAllCategories;
    private BlogDatabase database;


    public Repository(Application application) {
        database = BlogDatabase.getInstance(application);
        blogDao = database.blogDao();
        getAllAuthor = blogDao.getAllAuthor();
        getAllBlog = blogDao.getAllBlog();
        getAllCategories = blogDao.getAllCategories();

    }

    public void insertAuthor(List<Author> authors) {
        blogDao.insertAuthor(authors);
    }

    public long insertBlog(Blogs blog) {
        return blogDao.insertBlog(blog);
    }

    public void insertCategory(List<Categories> categories) {
        blogDao.insertCategories(categories);
    }

    public void deleteBlog() {
        blogDao.deleteAllBlog();
        blogDao.deleteAllAuthor();
        blogDao.deleteAllCategories();
    }

    public List<BlogWithAuthor> getAllBlogAuthor() {
        return blogDao.getBlogWithAuthor();
    }

    public List<BlogWithCategory> getAllBlogCategory() {
        return blogDao.getBlogWithCategory();
    }

    public List<BlogModel> getAllBlogs() {
        List<BlogWithAuthor> data = getAllBlogAuthor();
        List<BlogWithCategory> data1 = getAllBlogCategory();
        List<BlogModel> modelList = new ArrayList<>();
        BlogWithAuthor blogWithAuthor;
        for (int i = 0; i < data.size(); i++) {
            blogWithAuthor = data.get(i);
            Author author = blogWithAuthor.author.get(0);
            BlogModel model = new BlogModel(blogWithAuthor.getBlogs().getBlogId(), blogWithAuthor.getBlogs().getId(), blogWithAuthor.getBlogs().getTitle(), blogWithAuthor.getBlogs().getDescription(), blogWithAuthor.getBlogs().getCoverPhoto(), author, data1.get(i).categories);
            modelList.add(model);
        }
        return modelList;
    }

    public BlogModel findBlogWithAuthor(long id) {
        BlogWithAuthor blogWithAuthor = blogDao.findBlogWithAuthorById(id);
        Author author = blogWithAuthor.author.get(0);
        BlogWithCategory blogWithCategory = blogDao.findBlogWithCategoryById(id);
        BlogModel model = new BlogModel(blogWithAuthor.getBlogs().getBlogId(), blogWithAuthor.getBlogs().getId(), blogWithAuthor.getBlogs().getTitle(), blogWithAuthor.getBlogs().getDescription(), blogWithAuthor.getBlogs().getCoverPhoto(), author, blogWithCategory.categories);
        return model;
    }

    public LiveData<List<Author>> getAllAuthor() {
        return getAllAuthor;
    }

    public LiveData<List<Blogs>> getAllBlog() {
        return getAllBlog;
    }

    public LiveData<List<Categories>> getAllCategories() {
        return getAllCategories;
    }

    public void updateBlog(long id, String title, String description) {
        blogDao.updateBlog(id, title, description);
    }

}
