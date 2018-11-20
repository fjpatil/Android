package com.example.userposts.data;

import android.support.annotation.NonNull;

import com.example.userposts.model.User;

import java.util.List;

/**
 * Interface to get callback in Users manager to load data
 * @author fjpatil
 * {@link UsersRepository}
 */
@FunctionalInterface
public interface UsersRepository {
    @FunctionalInterface
    interface LoadUsersCallBack{
        void onUsersLoaded(List<User> users);
    }
    void getUsers(@NonNull LoadUsersCallBack usersCallBack);
}
