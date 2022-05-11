package com.emre.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.emre.myapplication.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    ArrayList<University> uni;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);*/
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        University nevu = new University("Nevşehir Üniversitesi","Nevşehir",R.drawable.nevu);
        University eru = new University("Erciyes Üniversitesi","Kayseri",R.drawable.eru);
        University itu = new University("İstenbul Teknik Üniversitesi","İstanbul",R.drawable.itu);
        University metu = new University("Ortadoğu Teknik Üniversitesi","Ankara",R.drawable.metu);
        uni = new ArrayList<>();
        uni.add(eru);
        uni.add(nevu);
        uni.add(metu);
        uni.add(itu);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,
                uni.stream().map(University->University.getName()).collect(Collectors.toList())
        );
        binding.liste.setAdapter(adapter);

        binding.liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,detay.class);
                intent.putExtra("abc",uni.get(i));
                startActivity(intent);
            }
        });

    }
}