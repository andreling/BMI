package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.bmi.Object.User;
import com.example.bmi.Recyclerview.RecycleInterface;
import com.example.bmi.Recyclerview.TipsAdapter;

public class TipsPage extends AppCompatActivity implements RecycleInterface, View.OnClickListener {
    RecyclerView recyclerView;
    ImageButton back;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips_page);

        user = getIntent().getParcelableExtra("user");
        recyclerView = findViewById(R.id.recycleritem);
        back = findViewById(R.id.tips_back_button);

        TipsAdapter tipsAdapter = new TipsAdapter(this, this, MainActivity.tips);
        recyclerView.setAdapter(tipsAdapter);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        back.setOnClickListener(this);
    }

    @Override
    public void onClickItem(int position) {
        Intent intent = new Intent(this, Tips_detail_page.class);
        intent.putExtra("productData", position);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        finish();
    }
}