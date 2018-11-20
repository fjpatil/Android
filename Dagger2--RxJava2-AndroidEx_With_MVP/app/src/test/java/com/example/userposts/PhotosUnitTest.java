package com.example.userposts;

import com.example.userposts.data.PhotosRepository;
import com.example.userposts.model.Photos;
import com.example.userposts.presenter.PhotoPresenter;
import com.example.userposts.ui.postdetail.PostsDetailsContractor;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;

/**
 * Created by fjpatil on 01-07-2017.
 */

public class PhotosUnitTest {
    @Mock
    private PhotosRepository mPhotosRepository;

    @Mock
    private PostsDetailsContractor.PhotosView mPhotosView;

    @Captor
    ArgumentCaptor<PhotosRepository.LoadPhotosCallback> mLoadPhotosCallBackCaptor;

    private PhotoPresenter mPhotosPresenter;

    private static List<Photos> mPhotosList=new ArrayList<>();

    @Before
    public void setupPhotosPresenter(){
        MockitoAnnotations.initMocks(this);
        mPhotosPresenter=new PhotoPresenter(mPhotosRepository);
        mPhotosPresenter.attachView(mPhotosView);
        Photos mPhotos=new Photos();
        mPhotos.setTitle("Blue Sky");
        mPhotos.setAlbumId(10);
        mPhotos.setId(1);
        mPhotos.setUrl("http://placehold.it/600/9c184f");
        mPhotos.setThumbnailUrl("http://placehold.it/150/9c184f");
        mPhotosList.add(mPhotos);

    }

    @Test
    public void loadPhotosFromRepositoryAndLoadToView(){
        mPhotosPresenter.loadPhotos();

        verify(mPhotosRepository).getPhotos(mLoadPhotosCallBackCaptor.capture());
        mLoadPhotosCallBackCaptor.getValue().onPhotosLoaded(mPhotosList);

        verify(mPhotosView).showPhotos(mPhotosList);
        Assert.assertEquals(mPhotosList.get(0).getTitle(),"Blue Sky");
        Assert.assertEquals(mPhotosList.get(0).getId(),1);
        Assert.assertEquals(mPhotosList.get(0).getAlbumId(),10);
        Assert.assertEquals(mPhotosList.get(0).getUrl(),"http://placehold.it/600/9c184f");
        Assert.assertEquals(mPhotosList.get(0).getThumbnailUrl(),"http://placehold.it/150/9c184f");

    }

}
