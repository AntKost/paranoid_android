package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements fragment_input.OnFragmentSendDataListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onSendData(String selectedItem) {
        fragment_output fragment = (fragment_output) getSupportFragmentManager()
                .findFragmentById(R.id.fragment_output);
        if (fragment != null)
            fragment.setTextViewResult(selectedItem);
    }
}