package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.bmi.Database.HistoryHelper;
import com.example.bmi.Object.History;
import com.example.bmi.Object.User;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Calculator extends AppCompatActivity implements View.OnClickListener {

    Integer weight = 0;
    Integer height = 0;
    Double result = 0.0;
    String health;

    //weight
    EditText weight_edit;
    ImageButton weight_plus;
    ImageButton weight_mines;

    //height
    EditText height_edit;
    ImageButton height_plus;
    ImageButton height_mines;

    ImageButton back;
    AppCompatButton calculate;
    HistoryHelper historyHelper;

    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        user = getIntent().getParcelableExtra("user");


        historyHelper = new HistoryHelper(this);

        weight_edit = findViewById(R.id.weight_edit);
        weight_mines = findViewById(R.id.weight_mines);
        weight_plus = findViewById(R.id.weight_plus);

        height_edit = findViewById(R.id.height_edit);
        height_mines = findViewById(R.id.height_mines);
        height_plus = findViewById(R.id.height_plus);

        back = findViewById(R.id.calculator_back_button);
        calculate = findViewById(R.id.calculate_button);

        weight_plus.setOnClickListener(this);
        weight_mines.setOnClickListener(this);

        height_plus.setOnClickListener(this);
        height_mines.setOnClickListener(this);

        calculate.setOnClickListener(this);
        back.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        if(view == weight_plus){
            weight = Integer.parseInt(weight_edit.getText().toString().trim());
            weight++;
            weight_edit.setText(""+weight);
        }
        else if(view == weight_mines){
            weight = Integer.parseInt(weight_edit.getText().toString().trim());
            if (weight == 0){
                weight = 0;
                weight_edit.setText(""+weight);
            }
            else{
                weight--;
                weight_edit.setText(""+weight);
            }
        }

        else if(view == height_plus){
            height = Integer.parseInt(height_edit.getText().toString().trim());
            height++;
            height_edit.setText(""+height);
        }
        else if(view == height_mines){
            height = Integer.parseInt(height_edit.getText().toString().trim());
            if (height == 0){
                height = 0;
                height_edit.setText(""+height);
            }
            else{
                height--;
                height_edit.setText(""+height);
            }
        }

        else if(view == calculate){
            weight = Integer.parseInt(weight_edit.getText().toString().trim());
            height = Integer.parseInt(height_edit.getText().toString().trim()); 

            result = (Double.valueOf(weight)/Double.valueOf(height)/Double.valueOf(height))*10000.0;
            if(result < 18.5){
                health = "Underweight";
            }else if(result >= 18.5 && result < 25.0){
                health = "Healthy";
            }else if(result >= 25.0 && result <30.0){
                health = "Overweight";
            }else{
                health = "Obesity";
            }

            String Date = currentDate();
            String Time = currentTime();
            String newresult = String.format("%.1f",result);
            double newresult2 = Double.parseDouble(newresult);

            History history = new History(user.getId(),newresult2,health,Date,Time);
            historyHelper.insert(history);

            Intent intent = new Intent(Calculator.this,Result.class);
            intent.putExtra("user",user);
            intent.putExtra("result",result);
            intent.putExtra("health",health);
            startActivity(intent);

        }
        else if(view == back){
            finish();
        }
    }

    private String currentTime(){
        return new SimpleDateFormat("hh:mm a",Locale.getDefault()).format(new Date());
    }

    private String currentDate(){
        return new SimpleDateFormat("dd LLL yyyy",Locale.getDefault()).format(new Date());
    }
}