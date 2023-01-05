package com.example.testexam;

import static android.widget.Toast.LENGTH_LONG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button add,save;
    private EditText book,author,page;
    private TextView header,available;
    private ListView lv;
    ArrayList<books> newBook = new ArrayList<>();
    ArrayList<String> arr = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        load();
        add = findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newBook.add(new books(book.getText().toString(), author.getText().toString(), page.getText().toString()));
                Toast t = Toast.makeText(getApplicationContext(),"Book Added", LENGTH_LONG);
                t.show();
            }
        });
        //ArrayAdapter<books> arr = new ArrayAdapter<books>(this, android.R.layout.simple_selectable_list_item, newBook);
        save = findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save();
                Intent intent = new Intent(MainActivity.this, second.class);
                intent.putExtra("list", newBook);
                startActivity(intent);

            }
        });

        book = findViewById(R.id.BookName);
        author = findViewById(R.id.authorName);
        page = findViewById(R.id.pages);
        header = findViewById(R.id.header);
        available = findViewById(R.id.available);


    }

    void save(){

        for(int i=0;i<newBook.size();i++){
            arr.add(newBook.get(i).toString());
        }
        SharedPreferences sharedPreferences = getSharedPreferences("shared prefs" , MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        Gson gson = new Gson();
        String json =gson.toJson(arr);
        edit.putString("list", json);
        edit.commit();
    }
    void load(){
        SharedPreferences loading =getSharedPreferences("list", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = loading.getString("list", null);
        Type t = new TypeToken<ArrayList<String>>(){}.getType();
        arr =gson.fromJson(json, t);
        if(arr == null){
            arr = new ArrayList<>();
        }
    }
}