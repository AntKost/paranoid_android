package com.example.lab1;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class fragment_input extends Fragment {

    private EditText editTextQuestion;
    private RadioButton radioButton;
    private RadioGroup radioGroup;
    private Button buttonResult;
    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_input, container, false);
        return rootView;
    }

    interface OnFragmentSendDataListener {
        void onSendData(String data);
    }
    private OnFragmentSendDataListener fragmentSendDataListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            fragmentSendDataListener = (OnFragmentSendDataListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " should implement interface OnFragmentInteractionListener");
        }
    }

    @Override
    public void onViewCreated(@NonNull View rootView, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(rootView, savedInstanceState);
        editTextQuestion = rootView.findViewById(R.id.editTextQuestion);
        radioGroup = rootView.findViewById(R.id.radioGroup);
        buttonResult = rootView.findViewById(R.id.buttonResult);
        radioButton = null;

        buttonResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextQuestion.getText().toString().trim().equals("")) {
                    Toast.makeText(getActivity(), R.string.no_input, Toast.LENGTH_SHORT).show();
                } else {
                    int selectedId = radioGroup.getCheckedRadioButtonId();
                    radioButton = (RadioButton) rootView.findViewById(selectedId);
                    String data = String.format("Input question: %s; \nAnswer: %s", editTextQuestion.getText(), radioButton.getText());
                    fragmentSendDataListener.onSendData(data);
                }
            }
        });
    }
}
