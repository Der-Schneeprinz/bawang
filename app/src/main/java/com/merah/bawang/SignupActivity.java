package com.merah.bawang;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignupActivity extends AppCompatActivity {

    private Spinner spinner;
    private TextView toLogin;
    private Button btnSignUp;

    // Signup credentials
    private EditText fName;
    private EditText mName;
    private EditText lName;
    private EditText email;
    private EditText password;
    private EditText studentNo;

    private FirebaseAuth mAuth;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        toLogin = findViewById(R.id.tvLogin);
        btnSignUp = findViewById(R.id.btnSignUp);

        // Signup credentials
        fName = findViewById(R.id.etFirstName);
        mName = findViewById(R.id.etMidName);
        lName = findViewById(R.id.etLastName);
        email = findViewById(R.id.etEmail);
        password = findViewById(R.id.etPassword);
        studentNo = findViewById(R.id.etStudentNo);

        mAuth = FirebaseAuth.getInstance();

        // Sets up spinner for sex
        spinner = (Spinner) findViewById(R.id.spSex);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(SignupActivity.this,
                android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.spSex));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        toLogin.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mfName = fName.getText().toString().trim();
                String mmName = mName.getText().toString().trim();
                String mlName = lName.getText().toString().trim();
                String memail = email.getText().toString().trim();
                String mpassword = password.getText().toString().trim();
                String mstudentNo = studentNo.getText().toString().trim();

                // empty field if statements
                if(mfName.isEmpty()) {
                    fName.setError("Empty First Name field.");
                    fName.setFocusable(true);
                }
                if(mlName.isEmpty()) {
                    lName.setError("Empty Last Name field.");
                    lName.setFocusable(true);
                }
                if(memail.isEmpty()) {
                    email.setError("Empty Email field.");
                    email.setFocusable(true);
                }
                if(mpassword.isEmpty()) {
                    password.setError("Empty Password field");
                    password.setFocusable(true);
                }

                if(!Patterns.EMAIL_ADDRESS.matcher(memail).matches()) {
                    email.setError("Invalid email format.");
                    email.setFocusable(true);
                }
                if(password.length() < 6) {
                    password.setError("Password must be at a length >6.");
                    password.setFocusable(true);
                }
                if(Patterns.EMAIL_ADDRESS.matcher(memail).matches() && password.length() < 6)
                    registerUser(memail, mpassword);
            }
        });
    }

    private void registerUser(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                        } else {
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(SignupActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(SignupActivity.this, "Authentication failed..", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}