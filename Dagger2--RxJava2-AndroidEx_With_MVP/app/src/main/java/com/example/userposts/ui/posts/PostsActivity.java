package com.example.userposts.ui.posts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.userposts.R;

/**
 * {@link PostsActivity --Activity to have detailed contents example: userFragment,PhotoFragment, CommentFragment}
 * @author fjpatil
 * */
public class PostsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//layout for adding fragment
    }
}
