package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.BreakIterator;

public class PassingIntents extends AppCompatActivity {
    Button Clear, Submit;
    TextView Registration, CompleteName, Gender, BirthText, PhoneNum, Email, Hobbies;
    EditText Name, Surname, Birthdate, PhoneNumInput, EmailAddInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_intents);

        // Buttons
        Clear = findViewById(R.id.btnClear);
        Submit = findViewById(R.id.btnSubmit);

        // TextViews
        Registration = findViewById(R.id.registration);
        CompleteName = findViewById(R.id.completeName);
        Gender = findViewById(R.id.textGender);
        BirthText = findViewById(R.id.BdayText);
        PhoneNum = findViewById(R.id.textPhoneNumber);
        Email = findViewById(R.id.textEmail);
        Hobbies = findViewById(R.id.textHobbies);

        Name = findViewById(R.id.textName);
        Surname = findViewById(R.id.textSurname);
        Birthdate = findViewById(R.id.textBirthdate);
        PhoneNumInput = findViewById(R.id.inputPhoneNum);
        EmailAddInput = findViewById(R.id.TextEmailAddress);

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //String fName = textName.getText().toString();




            Intent intent1 = new Intent(PassingIntents.this, PassingIntents2.class);

                startActivity(intent1);
            }
        });
    }
}
