package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.bmi.Database.HistoryHelper;
import com.example.bmi.Object.User;
import com.example.bmi.Recyclerview.HistoryAdapter;

import java.util.ArrayList;

public class HistoryPage extends AppCompatActivity {

    RecyclerView recyclerView;
    ImageButton back;
    HistoryHelper historyHelper;

    ArrayList<Integer> UserID,id;
    ArrayList<String> Health,Date,Time;
    ArrayList<Double> Result;

    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_page);
        user = getIntent().getParcelableExtra("user");
        back = findViewById(R.id.history_back_button);
        recyclerView = findViewById(R.id.rv_history);

        historyHelper = new HistoryHelper(HistoryPage.this);
        id = new ArrayList<>();
        UserID = new ArrayList<>();
        Health = new ArrayList<>();
        Date = new ArrayList<>();
        Time = new ArrayList<>();
        Result = new ArrayList<>();

        HistoryAdapter historyAdapter = new HistoryAdapter(this,id,UserID,Result,Health,Date,Time);
        recyclerView.setAdapter(historyAdapter);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        displaydata();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    void displaydata(){
        Cursor cursor = historyHelper.readAllData(user.getId());
        if(cursor.getCount() == 0){
            Toast.makeText(this,"No Data",Toast.LENGTH_SHORT).show();
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
    }

}