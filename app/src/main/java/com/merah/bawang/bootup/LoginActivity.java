package com.merah.bawang.bootup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.merah.bawang.HomeActivity;
import com.merah.bawang.R;

public class LoginActivity extends AppCompatActivity {

    private TextView toSignup;
    private TextView toForgotPass;
    private Button btnLogin;

    // Log in credentials
    private EditText email;
    private EditText password;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        toSignup = findViewById(R.id.btnSignUp);
        toForgotPass = findViewById(R.id.tvForgotPassword);
        // TODO: forgot password
        /*toForgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                startActivity(intent);
            }
        });*/

        toSignup.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        mAuth = FirebaseAuth.getInstance();

        // Log in credentials
        email = findViewById(R.id.etEmail);
        password = findViewById(R.id.etPassword);
        // TODO: Build a password show/hide

        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String memail = email.getText().toString().trim();
                String mpassword = password.getText().toString().trim();

                if(!Patterns.EMAIL_ADDRESS.matcher(memail).matches()) {
                    email.setError("Invalid email format.");
                    email.setFocusable(true);
                } else {
                    loginUser(memail, mpassword, mAuth);
                }

            }
        });
    }

    private void loginUser(String email, String password, @NonNull FirebaseAuth mAuth) {
        FirebaseUser user = mAuth.getCurrentUser();
        Log.d("LoginActivity", ""+user);
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("LoginActivity", "signInWithCustomToken:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            //updateUI(user);
                            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                            finish();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("LoginActivity", "signInWithCustomToken:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(LoginActivity.this, e.getMessage(),
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }
}