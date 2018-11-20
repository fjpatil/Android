package com.example.userposts;

import com.example.userposts.data.UsersRepository;
import com.example.userposts.model.User;
import com.example.userposts.ui.postdetail.PostsDetailsContractor;
import com.example.userposts.presenter.UserPresenter;

import org.junit.After;
import org.junit.Assert;
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

public class UsersUnitTest {

    @Mock
    private UsersRepository mUsersRepository;

    @Mock
    private PostsDetailsContractor.UsersView mUsersView;

    @Captor
    ArgumentCaptor<UsersRepository.LoadUsersCallBack> mLoadUsersCallBackCaptor;

    private UserPresenter mUsersPresenter;

    private static List<User> mUsersList=new ArrayList<>();

    @Before
    public void setupPhotosPresenter(){
        MockitoAnnotations.initMocks(this);
        mUsersPresenter=new UserPresenter(mUsersRepository);
        mUsersPresenter.attachView(mUsersView);
        User user=new User();
        user.setId(1);
        user.setUsername("fjpatil");
        user.setName("fjpatil");
        user.setEmail("fjpatil@gmail.com");
        user.setPhone("+4917675274248");
        user.setWebsite("https://www.linkedin.com/in/fjpatil/");
        mUsersList.add(user);
    }

    @Test
    public void loadUsersFromRepositoryAndLoadToView(){
        mUsersPresenter.loadUsers();
        verify(mUsersRepository).getUsers(mLoadUsersCallBackCaptor.capture());
        mLoadUsersCallBackCaptor.getValue().onUsersLoaded(mUsersList);
        verify(mUsersView).showUsers(mUsersList);
        Assert.assertEquals(mUsersList.get(0).getUsername(),"fjpatil");
        Assert.assertEquals(mUsersList.get(0).getName(),"fjpatil");
        Assert.assertEquals(mUsersList.get(0).getId(),1);
        Assert.assertEquals(mUsersList.get(0).getPhone(),"+4917675274248");
        Assert.assertEquals(mUsersList.get(0).getWebsite(),"https://www.linkedin.com/in/fjpatil/");
        Assert.assertEquals(mUsersList.get(0).getEmail(),"fjpatil@gmail.com");
    }

    @After
    public void testDetachView(){
        mUsersPresenter.detachView();
    }

}
