package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.bmi.Database.HistoryHelper;
import com.example.bmi.Object.User;

import java.util.ArrayList;

public class Home extends AppCompatActivity implements View.OnClickListener {

    ImageButton calculator;
    ImageButton history;
    ImageButton tips;
    ImageButton profile;
    HistoryHelper historyHelper;

    ArrayList<Integer> UserID,id;
    ArrayList<String> Health,Date,Time;
    ArrayList<Double> Result;

    TextView BMI;
    TextView HTH;

    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        user = getIntent().getParcelableExtra("user");
        historyHelper = new HistoryHelper(Home.this);
        id = new ArrayList<>();
        UserID = new ArrayList<>();
        Health = new ArrayList<>();
        Date = new ArrayList<>();
        Time = new ArrayList<>();
        Result = new ArrayList<>();

        calculator = findViewById(R.id.calculator_icon);
        profile = findViewById(R.id.home_profile);
        tips = findViewById(R.id.tips_icon);
        history = findViewById(R.id.history_icon);
        BMI = findViewById(R.id.last_bmi_edit);
        HTH = findViewById(R.id.bmi_health);

        history.setOnClickListener(this);
        profile.setOnClickListener(this);
        calculator.setOnClickListener(this);
        tips.setOnClickListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (readlast() == 0){
            BMI.setText("-");
            HTH.setText("-");
        }
        else{
            BMI.setText(Result.get(0).toString());
            HTH.setText(Health.get(0).toString());
        }

    }

    @Override
    public void onClick(View view) {
        if(view == calculator){
            Intent intent = new Intent(Home.this,Calculator.class);
            intent.putExtra("user",user);
            startActivity(intent);
        }
        else if(view == history){
            Intent intent = new Intent(Home.this,HistoryPage.class);
            intent.putExtra("user",user);
            startActivity(intent);
        }
        else if(view == tips){
            Intent intent = new Intent(Home.this,TipsPage.class);
            intent.putExtra("user",user);
            startActivity(intent);
        }
        else if(view == profile){
            Intent intent = new Intent(Home.this,Profile.class);
            intent.putExtra("user",user);
            startActivity(intent);
        }


    }

    private int readlast() {
        Cursor cursor = historyHelper.readlast(user.getId());
        if(cursor.getCount() == 0){
           return 0;
        }
        else{
            while(cursor.moveToNext()){
                id.add(cursor.getInt(0));
                UserID.add(cursor.getInt(1));
                Result.add(cursor.getDouble(2));
                Health.add(cursor.getString(3));
                Date.add(cursor.getString(4));
                Time.add(cursor.getString(5));
            }
        }
        return 1;
    }
}