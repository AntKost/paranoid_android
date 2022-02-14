package com.example.lab1;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListDataActivity extends AppCompatActivity {
    DatabaseHelper mDBhelper;
    private ListView mListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);
        mListView = (ListView) findViewById(R.id.list_view);
        mDBhelper = new DatabaseHelper(this);

        populateListView();
    }

    private void populateListView() {
        Cursor data = mDBhelper.getData();
        Boolean rowExists = data.moveToFirst();

        if (rowExists) {
            ArrayList<String> listData = new ArrayList<>();
            while (data.moveToNext()) {
                listData.add(data.getString(1));
            }
            ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
            mListView.setAdapter(adapter);
        }
        else {
            Toast.makeText(this, "The list is empty, please add data!", Toast.LENGTH_LONG).show();
        }
    }
}
