package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class ButtonExerciseActivity extends AppCompatActivity {
    Button btnClose;
    Button btnToast;
    Button btnChangeBG;
    Button btnChangePageBG;
    Button btnDisappear;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button_exercise);

        btnClose = findViewById(R.id.btn_close);
        btnToast = findViewById(R.id.btn_toast);
        btnChangeBG = findViewById(R.id.btn_changeBG);
        btnChangePageBG = findViewById(R.id.changeButtonBG_id);
        btnDisappear = findViewById(R.id.disappear_id);

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(ButtonExerciseActivity.this, Return.class);
                startActivity(intent3);
            }
        });

        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("Hello, this is a Toast!");
            }
        });

        btnChangeBG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeButtonColor();
            }
        });

        btnChangePageBG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changePageBackgroundColor();
            }
        });

        btnDisappear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeButtonInvisible();
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    private void changeButtonColor() {
        Random random = new Random();
        int color = android.graphics.Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
        btnChangeBG.setBackgroundColor(color);
    }

    private void changePageBackgroundColor() {
        Random random = new Random();
        int color = android.graphics.Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
        ConstraintLayout constraintLayout = findViewById(R.id.button_exercise);
        constraintLayout.setBackgroundColor(color);
    }


    private void makeButtonInvisible() {

        btnDisappear.setVisibility(View.INVISIBLE);

    }
}
