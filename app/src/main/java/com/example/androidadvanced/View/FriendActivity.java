package com.example.androidadvanced.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.androidadvanced.R;
import com.example.androidadvanced.adapter.FragmentStateAdapter;
import com.example.androidadvanced.fragments.AddFriendFragment;
import com.example.androidadvanced.fragments.FriendFragment;
import com.example.androidadvanced.helpers.BottomNavigationViewHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class FriendActivity extends AppCompatActivity {

    BottomNavigationView view;
    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        view = findViewById(R.id.bnBottom);



        setNavigationBottom();

        setupTabLayout();

        setEvent();


    }

    FragmentStateAdapter adapter;
    private void setupTabLayout() {
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.container);
        adapter = new FragmentStateAdapter(getSupportFragmentManager());
        adapter.addFragment(new FriendFragment(),"Friends");
        adapter.addFragment(new AddFriendFragment(),"Add Friend");

        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home_black_24dp);
        tabLayout.getTabAt(0).setText("Friend");
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_contacts_black_24dp);
        tabLayout.getTabAt(1).setText("Add Friend");

    }

    private void setNavigationBottom() {
        BottomNavigationViewHelper.disableShiftMode(view);
        Menu menu = view.getMenu();
        MenuItem menuItem = menu.getItem(4);
        menuItem.setChecked(true);
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
