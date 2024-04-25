package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    Button btn2;
    Button btn3;

    Button btn4;

    Button btn5;
    Button btn8;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    btn1 = (Button)findViewById(R.id.btnLayoutExercise);

    btn1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent1 = new Intent(MainActivity.this, LayoutExercise.class);
            startActivity(intent1);

        }
    });

        btn2 = (Button)findViewById(R.id.btnButtonExerciseActivity);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this, ButtonExerciseActivity.class);
                startActivity(intent2);
            }
        });

        btn3 = (Button)findViewById(R.id.myCalculatorActivity);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(MainActivity.this, Calculator.class);
                startActivity(intent3);
            }
        });
        btn4 = (Button)findViewById(R.id.btnSwapColors);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(MainActivity.this, SwapColors.class);
                startActivity(intent4);
            }
        });
        btn5 = (Button)findViewById(R.id.btnPassingIntents);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(MainActivity.this, PassingIntents.class);
                startActivity(intent5);
            }
        });
        btn8 = (Button)findViewById(R.id.btnMenuExercise);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent8 = new Intent(MainActivity.this, MenuExercise.class);
                startActivity(intent8);
            }
        });
    }


}

