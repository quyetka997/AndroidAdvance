package com.example.androidadvanced.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.androidadvanced.R;
import com.example.androidadvanced.adapter.CarAdapter;
import com.example.androidadvanced.entities.Car;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FriendFragment  extends Fragment {

    RecyclerView recyclerView;
    CarAdapter carAdapter;
    List<Car> lCar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friend, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        loadData();
        setupRecyclerView();

        return view;
    }

    public void loadData() {
        lCar = new ArrayList<>();
        lCar.add(new Car("drawable://" + R.drawable.a1,"Some House"));
        lCar.add(new Car("drawable://" + R.drawable.a2,"Some House"));
        lCar.add(new Car("drawable://" + R.drawable.a3,"Some House"));
        lCar.add(new Car("drawable://" + R.drawable.a4,"Some House"));
        lCar.add(new Car("drawable://" + R.drawable.a5,"Some House"));
        lCar.add(new Car("drawable://" + R.drawable.a6,"Some House"));
        lCar.add(new Car("drawable://" + R.drawable.a7,"Some House"));
        lCar.add(new Car("drawable://" + R.drawable.a8,"Some House"));

        carAdapter = new CarAdapter(getContext(), lCar);

    }
    public void setupRecyclerView() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(carAdapter);


    }

}
