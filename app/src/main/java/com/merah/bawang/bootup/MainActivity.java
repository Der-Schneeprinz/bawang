package com.merah.bawang.bootup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.merah.bawang.R;
import com.merah.bawang.homescreen.MainFragmentHandlerActivity;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loggedInStatus();
            }
        }, 3000);
        super.onStart();

    }

    private void loggedInStatus() {
        mAuth = FirebaseAuth.getInstance();
        // Checks if user is logged in
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Toast.makeText(MainActivity.this,"LOGGED IN SOMEHOW",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, MainFragmentHandlerActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(MainActivity.this,"PLEASE LOG IN",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
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