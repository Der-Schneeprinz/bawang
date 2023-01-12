package com.merah.bawang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }

    /**
     * TODO:    Discover Page:
     *              tabs, search bar functionality, filter logic, create organization
     *          Posts:
     *              activity_post.xml, display comments
     *          Comment:
     *              activity_comment.xml
     *          Profile:
     *              activity_profile.xml, organizations logic, edit profile
     *          Organization:
     *              members logic, posts logic, create post function
     */
}