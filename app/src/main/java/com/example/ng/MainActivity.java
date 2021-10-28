package com.example.ng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    //github push test1

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void goFoodList(View view) {
        Intent myIntent = new Intent(getApplicationContext(), FoodListView.class);
        startActivity(myIntent);
    }

    public void goPillList(View view) {
        Intent myIntent = new Intent(getApplicationContext(), PillListView.class);
        startActivity(myIntent);
    }
}
