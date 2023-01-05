package com.example.testexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class second extends AppCompatActivity {
    private ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lv = findViewById(R.id.lv);
        ArrayList<books> arr = getIntent().getParcelableArrayListExtra("list");
       ArrayList<String> arr2 = new ArrayList<String>();
       for(int i=0;i<arr.size();i++){
           arr2.add(arr.get(i).toString());
       }
        ArrayAdapter<String> arr1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr2);

        lv.setAdapter(arr1);
    }
}