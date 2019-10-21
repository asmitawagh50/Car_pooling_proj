package com.example.my_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class register extends AppCompatActivity {


    private EditText Fullname;
    private EditText Email;
    private EditText Password;
    private EditText Confirm_password;
    private Button register;
    FirebaseAuth firebaseAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //getSupportActionBar().setTitle("Registration Form");

        Fullname=(EditText)findViewById(R.id.edtfname);
        Email=(EditText)findViewById(R.id.edtemail);
        Password=(EditText)findViewById(R.id.edtpassword);
        Confirm_password=(EditText)findViewById(R.id.edtconfirm_password);
        register=(Button)findViewById((R.id.btnRegister));


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = Email.getText().toString();
                String password = Password.getText().toString();
                firebaseAuth = FirebaseAuth.getInstance();

                if (email.isEmpty()) {
                    Email.setError("Please enter your Email ID");
                    Email.requestFocus();
                } else if (password.isEmpty()) {
                    Password.setError("Please enter your password");
                    Password.requestFocus();
                } else if (!email.isEmpty() && !password.isEmpty()) {
                    firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(register.this, "Already Registered!", Toast.LENGTH_SHORT).show();
                            } else {
                                startActivity(new Intent(register.this, Offer_find.class));
                            }
                        }
                    });

                }
            }
        });
    }
}