package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Tips_detail_page extends AppCompatActivity {

    Integer position;
    TextView title;
    ImageView image;
    TextView desc;

    ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips_detail_page);
        position = getIntent().getIntExtra("productData",0);

        title = findViewById(R.id.tips_detail_title_edit);
        image = findViewById(R.id.tips_detail_image_edit);
        desc = findViewById(R.id.tips_detail_body_edit);
        back = findViewById(R.id.tips_detail_back_button);

        title.setText(MainActivity.tips.get(position).getTitle());
        image.setImageResource(MainActivity.tips.get(position).getImage());
        desc.setText(MainActivity.tips.get(position).getDecs());

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}