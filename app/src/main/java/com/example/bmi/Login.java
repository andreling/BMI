package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bmi.Database.UserHelper;
import com.example.bmi.Object.User;

public class Login extends AppCompatActivity implements View.OnClickListener {

    EditText email;
    EditText password;
    AppCompatButton login;
    TextView register;

    UserHelper userHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userHelper = new UserHelper(this);
        email = findViewById(R.id.login_email_edit);
        password = findViewById(R.id.login_password_edit);
        login = findViewById(R.id.login_button);
        register = findViewById(R.id.login_regis_button);

        login.setOnClickListener(this);
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == login){
            if(email.length() == 0 && password.length() == 0){
                email.requestFocus();
                email.setError("Email is required");
                password.requestFocus();
                password.setError("Password is required");
            }
            else{
                String emailtxt = email.getText().toString();
                String passwordtxt = password.getText().toString();

                User user = userHelper.auth(emailtxt,passwordtxt);

                if(user != null){
                    Intent intent = new Intent(Login.this,Home.class);
                    intent.putExtra("user",user);
                    startActivity(intent);
                }else{
                    Toast.makeText(view.getContext(),"Invalid Email or Password" , Toast.LENGTH_LONG).show();
                }
            }

        }
        else if(view == register){
            Intent intent = new Intent(Login.this,Register.class);
            startActivity(intent);
        }

    }
}