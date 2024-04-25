package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;


import java.util.Random;

public class MenuExercise extends AppCompatActivity {
    Button btnChanger;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_exercise);

        btnChanger = findViewById(R.id.btnTransformingButton);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.choice_menu, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.btnColorChanger) {

            Random random = new Random();
            int color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
            btnChanger.setBackgroundColor(color);
        } else if (item.getItemId() == R.id.btnShapeChanger) {

            int[] shapeDrawables = {R.drawable.rounded_rectangle, R.drawable.oval_shape, R.drawable.custom_shape};
            int randomIndex = new Random().nextInt(shapeDrawables.length);
            btnChanger.setBackgroundResource(shapeDrawables[randomIndex]);
        } else if (item.getItemId() == R.id.btnTextColorChanger) {
            //para ma change iyang text color
            Random myColor = new Random();
            int textColor = Color.rgb(myColor.nextInt(156) + 100, myColor.nextInt(156) + 100, myColor.nextInt(156) + 100);
            btnChanger.setTextColor(textColor);
        }else if(item.getItemId() == R.id.btnVisibility) {
            btnChanger.setVisibility(View.INVISIBLE);
        }else if(item.getItemId() == R.id.btnUpwardMotion){
            //para ma upward iya movements hehehehe
            Animation animation = new TranslateAnimation(0, 0, 400, -400);
            animation.setDuration(1000);
            animation.setFillAfter(true);
            btnChanger.startAnimation(animation);
        }else if(item.getItemId() == R.id.btnSidewardMotion) {
            Animation animation = new TranslateAnimation(-400, 200, 0, 0);
            animation.setDuration(1000);
            animation.setFillAfter(true);
            btnChanger.startAnimation(animation);
        }else if (item.getItemId() == R.id.mItemReset) {
            Toast.makeText(this, "Reset Object item is clicked", Toast.LENGTH_SHORT).show();

        } else if (item.getItemId() == R.id.mItemExit) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}



