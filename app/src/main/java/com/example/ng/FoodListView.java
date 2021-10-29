package com.example.ng;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class FoodListView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_lst);
    }
    public void plusFood(View view) {
        Intent myIntent = new Intent(getApplicationContext(), StuffFood.class);
        startActivity(myIntent);
    }
}