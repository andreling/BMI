package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.bmi.Database.UserHelper;
import com.example.bmi.Object.User;

public class Register extends AppCompatActivity implements View.OnClickListener {

    EditText email;
    EditText password;
    EditText name;
    EditText age;
    RadioGroup gender;
    RadioButton selected_gender;
    TextView signin;

    Button submit;
    ImageButton back;
    UserHelper userHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userHelper = new UserHelper(this);
        email = findViewById(R.id.regis_email_edit);
        password = findViewById(R.id.regis_password_edit);
        name = findViewById(R.id.regis_name_edit);
        back = findViewById(R.id.regis_back_button);
        age = findViewById(R.id.regis_age_edit);
        gender = findViewById(R.id.regis_gender_edit);
        signin = findViewById(R.id.signin_textview);

        submit = findViewById(R.id.regis_submit_button);

        submit.setOnClickListener(this);
        back.setOnClickListener(this);
        signin.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view == submit){
            int radioID = gender.getCheckedRadioButtonId();
            selected_gender = findViewById(radioID);

            String email_txt = email.getText().toString();
            String password_txt = password.getText().toString();
            String name_txt = name.getText().toString();
            Integer age_txt = Integer.valueOf(age.getText().toString());
            String gender_txt = selected_gender.getText().toString();

            User user =new User(name_txt,email_txt,password_txt,age_txt,gender_txt);
            userHelper.insert(user);

            finish();
        } else if(view == back){
            finish();
        }
        else if(view == signin){
            finish();
        }

    }


}