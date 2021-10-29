package com.example.ng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    //github push test1

    //firebase 연동 코드
    /* private Button sendbt;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference(); */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* sendbt = (Button) findViewById(R.id.button);

        sendbt.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                // 버튼 누르면 수행 할 명령, 이름에 값 출력
                databaseReference.child("message").push().setValue("2");
                databaseReference.child("message").child("gbgg").setValue("2");
            }
        }); */
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
