package com.example.userposts;

import com.example.userposts.model.User;
import com.example.userposts.networking.services.UsersServiceAPI;

import java.util.ArrayList;
import java.util.List;

/**
 *Class to show mock user data on UI
 * @author fjpatil
 */

public class MockUserServiceAPIImp implements UsersServiceAPI {

    @Override
    public void getUsers(UsersServiceCallBack<List<User>> usersCallBack) {
        List<User> usersList=new ArrayList<>();
        User user=new User();
        user.setPhone("+4917675274248");
        user.setWebsite("https://www.linkedin.com/in/fjpatil/");
        user.setEmail("fjpatil@gmail.com");
        user.setName("FJPATIL");
        user.setUsername("FJ");
        usersList.add(user);
        usersCallBack.onUsersLoaded(usersList);
    }
}
