package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextQuestion;
    private RadioButton radioButton;
    private RadioGroup radioGroup;
    private Button buttonResult;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextQuestion = findViewById(R.id.editTextQuestion);
        radioGroup = findViewById(R.id.radioGroup);
        buttonResult = findViewById(R.id.buttonResult);
        textViewResult = findViewById(R.id.textViewResult);

        buttonResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editTextQuestion.getText().toString().trim().equals("") ){
                    Toast.makeText(MainActivity.this, R.string.no_input, Toast.LENGTH_SHORT).show();
                }
                else{
                    checkButton(view);
                    textViewResult.setText("");
                    textViewResult.setText(String.format("Input question: %s; \nAnswer: %s", editTextQuestion.getText(), radioButton.getText()));
                }
            }
        });
    }

    public void checkButton(View view){
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);
//        Toast.makeText(this, "Selected radio button " + radioButton.getText() , Toast.LENGTH_SHORT).show();

    }
}