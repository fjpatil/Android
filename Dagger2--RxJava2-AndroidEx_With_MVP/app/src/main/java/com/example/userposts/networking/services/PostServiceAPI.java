package com.example.userposts.networking.services;

import com.example.userposts.model.Post;

import java.util.List;

/**
 * {@link PostServiceAPI --Interface to get the posts data from API}.
 * @author fjpatil
 */
@FunctionalInterface
public interface PostServiceAPI {
    @FunctionalInterface
    interface PostServiceCallback<T> {
        void onPostsLoaded(T posts);
    }
    void getPosts(PostServiceCallback<List<Post>> callback, int offset);


}
