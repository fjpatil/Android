package com.example.userposts.networking.services;

import com.example.userposts.model.Photos;

import java.util.List;

/**
 * {@link PhotosServiceAPI --Interface to get the photos data from API}.
 * @author fjpatil
 */
@FunctionalInterface
public interface PhotosServiceAPI {
    @FunctionalInterface
    interface PhotosServiceCallBack<T>{
        void onPhotosLoaded(T photos);
    }
    void getPhotos(PhotosServiceCallBack<List<Photos>> photosCallBack);

}
