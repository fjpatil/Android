package com.example.userposts.data;

import android.support.annotation.NonNull;

import com.example.userposts.model.Photos;
import com.example.userposts.networking.services.PhotosServiceAPI;

import java.util.ArrayList;
import java.util.List;
/**
 * {@link PhotosManager --To get the photos from service API and adding to list}
 * @author fjpatil
 */

public class PhotosManager implements PhotosRepository {

    private PhotosServiceAPI mPhotosServiceAPI;//Interface to get the data from service API
    private List<Photos> mPhotos = new ArrayList<>();//List to add photos

    /**
     * Constructor called From Repositories
     *
     * @param photosServiceAPI interface to get callbacks
     */
    public PhotosManager(@NonNull PhotosServiceAPI photosServiceAPI){
        this.mPhotosServiceAPI = photosServiceAPI;

    }

    @Override
    public void getPhotos(@NonNull final LoadPhotosCallback photosCallBack) {
        mPhotos.clear();
        mPhotosServiceAPI.getPhotos(new PhotosServiceAPI.PhotosServiceCallBack<List<Photos>>() {
            @Override
            public void onPhotosLoaded(List<Photos> photos) {
                mPhotos.addAll(new ArrayList<>(photos));//adding data to array list
                photosCallBack.onPhotosLoaded(mPhotos); //passing list data to repository
            }
        });

    }

}
