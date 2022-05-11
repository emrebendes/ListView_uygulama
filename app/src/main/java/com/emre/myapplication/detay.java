package com.emre.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.emre.myapplication.databinding.ActivityDetayBinding;
import com.emre.myapplication.databinding.ActivityMainBinding;

public class detay extends AppCompatActivity {
    private ActivityDetayBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetayBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent intent = getIntent();
        University university = (University) intent.getSerializableExtra("abc");

        binding.image.setImageResource(university.getLogo());
        binding.city.setText(university.getCity());
        binding.name.setText(university.getName());
    }
}