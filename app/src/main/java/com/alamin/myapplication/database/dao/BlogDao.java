package com.alamin.myapplication.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import com.alamin.myapplication.database.entity.BlogWithAuthor;
import com.alamin.myapplication.database.entity.BlogWithCategory;
import com.alamin.myapplication.database.entity.Blogs;
import com.alamin.myapplication.database.entity.Categories;
import com.alamin.myapplication.model.Author;

import java.util.List;

@Dao
public interface BlogDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAuthor(List<Author> authors);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertBlog(Blogs blogs);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCategories(List<Categories> categories);

    @Query("SELECT DISTINCT * FROM Author")
    LiveData<List<Author>> getAllAuthor();

    @Query("SELECT DISTINCT * FROM Blogs")
    LiveData<List<Blogs>> getAllBlog();

    @Query("UPDATE Blogs SET title = :title, description= :description WHERE blogId =:id")
    void updateBlog(long id, String title, String description);

    @Query("SELECT DISTINCT * FROM Categories")
    LiveData<List<Categories>> getAllCategories();

    @Transaction
    @Query("SELECT DISTINCT * FROM Blogs")
    List<BlogWithAuthor> getBlogWithAuthor();

    @Transaction
    @Query("SELECT DISTINCT * FROM Blogs WHERE blogId=:id")
    BlogWithAuthor findBlogWithAuthorById(long id);

    @Transaction
    @Query("SELECT DISTINCT * FROM Blogs")
    List<BlogWithCategory> getBlogWithCategory();

    @Transaction
    @Query("SELECT DISTINCT * FROM Blogs WHERE blogId=:id")
    BlogWithCategory findBlogWithCategoryById(long id);


    @Query("DELETE FROM Author")
    void deleteAllAuthor();

    @Query("DELETE FROM Blogs")
    void deleteAllBlog();

    @Query("DELETE FROM Categories")
    void deleteAllCategories();
}
