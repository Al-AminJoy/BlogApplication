package com.alamin.myapplication.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.alamin.myapplication.database.dao.BlogDao;
import com.alamin.myapplication.database.entity.Blogs;
import com.alamin.myapplication.database.entity.Categories;
import com.alamin.myapplication.model.Author;

@Database(entities = {Author.class, Blogs.class, Categories.class}, version = 7)
public abstract class BlogDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "blog";

    public abstract BlogDao blogDao();

    public static volatile BlogDatabase INSTANCE = null;

    public static BlogDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (BlogDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, BlogDatabase.class, DATABASE_NAME)
                            .addCallback(callback)
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }

        }
        return INSTANCE;
    }

    public static Callback callback = new Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulateDbAsyn(INSTANCE);

        }
    };

    static class PopulateDbAsyn extends AsyncTask<Void, Void, Void> {
        private BlogDao blogDao;

        public PopulateDbAsyn(BlogDatabase blogDatabase) {
            blogDao = blogDatabase.blogDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            blogDao.deleteAllAuthor();
            blogDao.deleteAllBlog();
            blogDao.deleteAllCategories();

            return null;
        }
    }

}