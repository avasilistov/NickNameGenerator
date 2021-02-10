package com.demo.testtrackensure;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private TextView generated_nick;
    private EditText person_name;
    private EditText person_surname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generated_nick = findViewById(R.id.textViewGeneratedNick);
        person_name = findViewById(R.id.editTextTextPersonName);
        person_surname = findViewById(R.id.editTextTextPersonSurName);
    }



    public void onClickGenerateNick(View view) {
        StringBuilder result = new StringBuilder("");
        StringBuilder nick = new StringBuilder("");
        StringBuilder vowels = new StringBuilder("");
        StringBuilder consonants = new StringBuilder("");
        Random random = new Random();
        int numberVowels = 0;
        int numberConsonants = 0;



        for (char c : person_name.getText().toString().toLowerCase().toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                numberVowels += 1;
                vowels.append(c);
            }
            else {
                numberConsonants += 1;
                consonants.append(c);
            }
        }
        for (char c : person_surname.getText().toString().toLowerCase().toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                numberVowels += 1;
            else numberConsonants += 1;
        }
        int length_name = random.nextInt(12);
        if (length_name<6) length_name=6;

        for (int i = 0; i<length_name/2;i++){
                nick.append(vowels.charAt(random.nextInt(vowels.length())));
                nick.append(consonants.charAt(random.nextInt(consonants.length())));
        }
        result.append("Your new nickname: " + nick.substring(0,1).toUpperCase()+ nick.substring(1) + "\n" );
        result.append("Number of vowels: " + numberVowels + "\n");
        result.append("Number of consonants: " + numberConsonants );


        generated_nick.setText(result);

    }
}