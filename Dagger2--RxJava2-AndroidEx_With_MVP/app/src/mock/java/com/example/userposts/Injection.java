package com.example.userposts;

import com.example.userposts.data.CommentsRepository;
import com.example.userposts.data.MainRepositories;
import com.example.userposts.data.PhotosRepository;
import com.example.userposts.data.PostRepository;
import com.example.userposts.data.UsersRepository;
import com.example.userposts.networking.services.CommentsServiceAPIImp;
import com.example.userposts.networking.services.PhotosServiceAPIImp;
import com.example.userposts.networking.services.PostServiceAPIImp;
import com.example.userposts.networking.services.UsersServiceAPIImp;

/**
 * Class to inject whether online or offline mocked data
 * @author fjpatil
 */
public class Injection {

   public static PostRepository providePostsRepository() {
      return MainRepositories.getPostManager(new PostServiceAPIImp());
   }
   public static PhotosRepository providePhotosRepository(){
      return MainRepositories.getPostsDetailManager(new PhotosServiceAPIImp());
   }
   public static UsersRepository provideUsersRepository(){
      return MainRepositories.getUsersManager(new UsersServiceAPIImp());
   }
   public static CommentsRepository provideCommentsRepository(){
      return MainRepositories.getCommentsManager(new CommentsServiceAPIImp());
   }

}
