package com.example.androidadvanced;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.androidadvanced.helpers.BottomNavigationViewHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = findViewById(R.id.bnBottom);

        BottomNavigationViewHelper.disableShiftMode(view);

    }
}
