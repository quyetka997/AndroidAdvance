package com.example.androidadvanced.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.androidadvanced.R;
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

        Menu menu = view.getMenu();
        MenuItem menuItem = menu.getItem(0);
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
                        break;
                    case R.id.idFriend:
                        intent = new Intent(getApplicationContext(), FriendActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.idHome:
                        intent = new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(intent);
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
