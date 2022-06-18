package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.bmi.Object.User;

public class Result extends AppCompatActivity implements View.OnClickListener {

    Double result;
    String health;

    TextView BMI;
    TextView BMI_Health;

    AppCompatButton close;
    AppCompatButton recalculate;

    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        user = getIntent().getParcelableExtra("user");
        Bundle extras = getIntent().getExtras();
        result = getIntent().getDoubleExtra("result",0);
        health = extras.getString("health");

        close = findViewById(R.id.result_close_button);
        recalculate = findViewById(R.id.recalculate_button);
        BMI = findViewById(R.id.result_bmi_edit);
        BMI_Health =findViewById(R.id.result_health_edit);

        BMI.setText(String.format("%.1f",result) + " BMI");
        BMI_Health.setText(health);

        close.setOnClickListener(this);
        recalculate.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view == close){
            Intent intent = new Intent(Result.this,Home.class);
            intent.putExtra("user",user);
            startActivity(intent);
        }
        else if(view == recalculate){
            finish();
        }
    }
}