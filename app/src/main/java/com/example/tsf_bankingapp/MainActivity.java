package com.example.tsf_bankingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tsf_bankingapp.adapters.MainAdapter;
import com.example.tsf_bankingapp.database.DBHelper;
import com.example.tsf_bankingapp.models.Model;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DBHelper myDB;
    LinearLayoutManager linearLayoutManager;
    RecyclerView recyclerView;
    MainAdapter adapter;
    Button viewTransaction;
    List<Model> dataList = new ArrayList<>();
    SharedPreferenceManager preferenceManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        viewTransaction = findViewById(R.id.buttonview);

        myDB = new DBHelper(MainActivity.this);
        preferenceManager = new SharedPreferenceManager(MainActivity.this);

        if(preferenceManager.isFirstTimeLaunch()){
            addUserData();
            viewAll();
        }

        viewTransaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ViewTransaction.class));
                overridePendingTransition(R.anim.toptonormal, R.anim.fixed);
            }
        });

        linearLayoutManager = new LinearLayoutManager(this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new MainAdapter(this,dataList);
        recyclerView.setAdapter(adapter);

    }

    public void addUserData(){

        myDB.insertUserData("Ajita Bhagat","ajitabhagat94@gmail.com", 10000,"XXXX XXXX XXXX 6795");
        myDB.insertUserData("Kaustav Sarda","iamkaustav4@gmail.com", 10000,"XXXX XXXX XXXX 2935");
        myDB.insertUserData("Priya Johar","priyajohar854@gmail.com", 10000,"XXXX XXXX XXXX 7252" );
        myDB.insertUserData("Soumita Basu","soumita.basu.99@gmail.com", 10000 ,"XXXX XXXX XXXX 3355");
        myDB.insertUserData("Ritaja Mondal","iamrits@gmail.com", 10000,"XXXX XXXX XXXX 9261");
        myDB.insertUserData("Anupama Johar","anupama8johar@gmail.com", 10000,"XXXX XXXX XXXX 3529");
        myDB.insertUserData("Ankita Chopra","ankitachopra529@gmail.com", 10000,"XXXX XXXX XXXX 6825" );
        myDB.insertUserData("Raj Bose","raj123@gmail.com", 10000,"XXXX XXXX XXXX 8263");
        myDB.insertUserData("Pramit De","pramitde89@yahoo.com", 10000,"XXXX XXXX XXXX 4271");
        myDB.insertUserData("Saumya Gupta","itsmesaumya969@gmail.com", 10000, "XXXX XXXX XXXX 0037");

    }

    public void viewAll(){

        Cursor cursor = myDB.getUserData();

        if(cursor.getCount() == 0)
            return;

        while (cursor.moveToNext()) {
            String name = cursor.getString(0);
            String email = cursor.getString(1);
            int balance = cursor.getInt(2);
            String accnumber = cursor.getString(3);

            Model model = new Model(name, email, balance, accnumber);
            dataList.add(model);
        }
    }

}