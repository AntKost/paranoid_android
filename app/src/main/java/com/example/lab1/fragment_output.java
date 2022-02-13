package com.example.lab1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class fragment_output extends Fragment {

    private TextView textViewResult;

    public fragment_output(){
        super(R.layout.fragment_output);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textViewResult = view.findViewById(R.id.textViewResult);
    }
    public void setTextViewResult(String data){
        textViewResult.setText(data);
    }
}
