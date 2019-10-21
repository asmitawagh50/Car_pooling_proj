package com.example.my_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class login_form extends AppCompatActivity {

    private EditText txtemail;
    private EditText txtpassword;
    private TextView Forgot;
    private Button login;
    private Button register;
    FirebaseAuth firebaseAuth;

    String email;
    String password;
    String code;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);
        //getSupportActionBar().setTitle("Login Form");


        txtemail = (EditText) findViewById(R.id.txtemail);
        txtpassword = (EditText) findViewById(R.id.txtpassword);
        login = (Button) findViewById(R.id.btnlogin);
        register =(Button)findViewById(R.id.btnregister);
        Forgot = (TextView)findViewById(R.id.txtforgot);

         email=txtemail.getText().toString();
         password=txtpassword.getText().toString();


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                firebaseAuth=FirebaseAuth.getInstance();

                if (email.isEmpty()){
                    txtemail.setError("Please enter your Email ID");
                    txtemail.requestFocus();
                }else if (password.isEmpty()){
                    txtpassword.setError("Please enter your password");
                    txtpassword.requestFocus();
                }else if (!email.isEmpty() && !password.isEmpty()){
                    firebaseAuth.signInWithEmailAndPassword(email,password);
                    Toast.makeText(login_form.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(login_form.this, Offer_find.class));
                }

            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(login_form.this,register.class));
            }
        });

       /* Forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth = FirebaseAuth.getInstance();

                firebaseAuth.
                firebaseAuth.sendPasswordResetEmail(email);
                //firebaseAuth.confirmPasswordReset(code, password);
                Toast.makeText(login_form.this, "Password reset successful", Toast.LENGTH_SHORT).show();
            }
        });
*/
    }
}