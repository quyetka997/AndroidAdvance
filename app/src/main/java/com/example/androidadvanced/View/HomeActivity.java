package com.example.androidadvanced.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.androidadvanced.R;
import com.example.androidadvanced.helpers.BottomNavigationViewHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        view = findViewById(R.id.bnBottom);

        BottomNavigationViewHelper.disableShiftMode(view);

        Menu menu = view.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);

        setEvent();


    }

    private void setEvent() {
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Intent intent;
                switch (menuItem.getItemId()) {
                    case R.id.idBack:
                        intent= new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.idFriend:
                        intent = new Intent(getApplicationContext(), FriendActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.idHome:
                        break;
                    case R.id.idNotify:
                        intent = new Intent(getApplicationContext(), NotificationActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.idContact:
                        intent = new Intent(getApplicationContext(), ContactActivity.class);
                        startActivity(intent);
                    default:
                        break;
                }
                return false;
            }
        });
    }
}
