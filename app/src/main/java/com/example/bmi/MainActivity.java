package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.bmi.Object.Tips;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    /*
    2440012094 - Andrew Sterling Reinhart Wijaya
    2440084950 - Khresna Deva Wibawa
    2440076293 - Hafizh Al Kauny

    Recommended Device = Pixel 4 XL
    App ini menggunakan SQLite
    email = admin@binus.ac.id
    password = admin123
    */

    public static ArrayList<Tips> tips = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tips.add(new Tips("Memasak sendiri",R.drawable.image1,"Memasak makanan sendiri akan lebih sehat dibandingkan membelinya dari luar. Selain itu, memasak sendiri dapat memastikan kalori yang diperoleh dan kandungan gizi di dalam makanan tersebut. Saat memasak sendiri, seseorang juga dapat memiliki kendali penuh terhadap resep makanan yang dibuat."));
        tips.add(new Tips("Olahraga jogging",R.drawable.image2,"Jam jogging yang baik adalah sore hari karena pada saat itu kondisi tubuh lebih optimal untuk berolahraga. Meski demikian, hal yang paling penting adalah menyempatkan berlari atau olahraga lain secara rutin dalam seminggu."));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,Login.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }
}