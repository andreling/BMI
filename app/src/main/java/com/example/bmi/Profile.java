package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.bmi.Object.User;

public class Profile extends AppCompatActivity implements View.OnClickListener {

    AppCompatButton logout;
    ImageButton back;
    TextView name;
    TextView email;
    TextView age;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        user = getIntent().getParcelableExtra("user");
        logout = findViewById(R.id.logout_button);
        back = findViewById(R.id.profile_back_button);
        name = findViewById(R.id.tv_profile_name);
        email = findViewById(R.id.tv_profile_email);
        age = findViewById(R.id.tv_profile_age);

        name.setText(user.getName());
        email.setText(user.getEmail());
        age.setText(user.getAge().toString());

        logout.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == logout){
            Intent intent = new Intent(Profile.this,Login.class);
            startActivity(intent);
        }
        else if(view == back){
            finish();
        }
    }
}