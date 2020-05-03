package com.example.androidadvanced.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.androidadvanced.R;
import com.example.androidadvanced.entities.Car;
import com.example.androidadvanced.entities.Children;
import com.example.androidadvanced.entities.Feed;
import com.example.androidadvanced.helpers.BottomNavigationViewHelper;
import com.example.androidadvanced.restapi.RedditAPI;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String TAG = "QuyetKa";
    public static String BASE_URL = "https://www.reddit.com";
    private ImageView imgView;

    BottomNavigationView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgView = findViewById(R.id.imgView);
        view = findViewById(R.id.bnBottom);

        //BottomNavigationViewHelper.disableShiftMode(view);

        Menu menu = view.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);

        setEvent();

        restAPI();

        setupImageLoader();
    }

    private void restAPI() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RedditAPI redditAPI = retrofit.create(RedditAPI.class);

        Call<Feed> feedCall = redditAPI.getData();

        feedCall.enqueue(new Callback<Feed>() {
            @Override
            public void onResponse(Call<Feed> call, Response<Feed> response) {
                if (response.isSuccessful()) {
                    List<Children> children = response.body().getData().getChildren();
                    for (Children c : children) {
                        Log.d(TAG, c.getKind() + "\n" +
                                c.getData().getDomain() + "\n" +
                                c.getData().getScore() + "\n" +
                                c.getData().getTitle() + "\n");
                    }
                }
            }

            @Override
            public void onFailure(Call<Feed> call, Throwable t) {
                Log.d("", "Load Data Failed");
            }
        });

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

    private void setupImageLoader() {
        // UNIVERSAL IMAGE LOADER SETUP
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheOnDisc(true).cacheInMemory(true)
                .imageScaleType(ImageScaleType.EXACTLY)
                .displayer(new FadeInBitmapDisplayer(300)).build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                getApplicationContext())
                .defaultDisplayImageOptions(defaultOptions)
                .memoryCache(new WeakMemoryCache())
                .discCacheSize(100 * 1024 * 1024).build();

        ImageLoader.getInstance().init(config);
        // END - UNIVERSAL IMAGE LOADER SETUP
        //create the imageloader object
        ImageLoader imageLoader = ImageLoader.getInstance();
        ;
        int defaultImage = getApplicationContext().getResources().getIdentifier("@drawable/fail", null, getApplicationContext().getPackageName());

        DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true)
                    .cacheOnDisc(true).resetViewBeforeLoading(true)
                    .showImageForEmptyUri(defaultImage)
                    .showImageOnFail(defaultImage)
                    .showImageOnLoading(defaultImage).build();

        //download and display image from url
        imageLoader.displayImage("https://i.redd.it/award_images/t5_22cerq/0o2j782f00e41_WholesomeSuperpro.png", imgView, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {

            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {

            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {

            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {

            }
        });
    }
}
