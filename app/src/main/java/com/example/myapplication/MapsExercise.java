package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MapsExercise extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_exercise);


        Button simalaButton = findViewById(R.id.simala_button);
        Button magellanButton = findViewById(R.id.magellan_button);
        Button tenKRosesButton = findViewById(R.id.roses_button);
        Button safariButton = findViewById(R.id.safari_button);
        Button oslobButton = findViewById(R.id.oslob_button);

        simalaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("geo: 9.979194, 123.599917"));
                startActivity(intent1);
            }
        });
        magellanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("geo: 10.293699819839702, 123.9020299982094"));
                startActivity(intent2);
            }
        });
        tenKRosesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse("geo: 10.25685865526354, 123.93231987817411"));
                startActivity(intent3);
            }
        });
        safariButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:10.588813481654057, 123.96141179636297"));
                startActivity(intent4);
            }
        });
        oslobButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(Intent.ACTION_VIEW, Uri.parse("geo: 9.463655185463534, 123.37983033566933"));
                startActivity(intent5);
            }
        });

    }



    }

