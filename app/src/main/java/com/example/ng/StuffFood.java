package com.example.ng;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class StuffFood extends AppCompatActivity {

    Button btn_date;
    DatePickerDialog datePickerDialog;
    Spinner spinner;

    //firebase 연동
    private Button sendbt;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    //firebase 데이터 저장
    private EditText editdt, editdt2;
    public String a, b, c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plus_food);

        btn_date = findViewById(R.id.btn_date); //캘린더
        spinner = findViewById(R.id.spinner);   //카테고리

        //카테고리 선택
        ArrayAdapter monthAdapter = ArrayAdapter.createFromResource(this, R.array.category, android.R.layout.simple_spinner_dropdown_item);
        //R.array.category는 저희가 정의해놓은 카테고리 / android.R.layout.simple_spinner_dropdown_item은 기본으로 제공해주는 형식입니다.
        monthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(monthAdapter); //어댑터에 연결해줍니다.

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            } //이 오버라이드 메소드에서 position은 몇번째 값이 클릭됬는지 알 수 있습니다.

            //getItemAtPosition(position)를 통해서 해당 값을 받아올수있습니다.
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        sendbt = (Button) findViewById(R.id.button2);
        editdt = (EditText) findViewById(R.id.editText);
        editdt2 = (EditText) findViewById(R.id.editText2);
        spinner = (Spinner)findViewById(R.id.spinner);

        //firebase 식품명 저장
        sendbt.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                // 버튼 누르면 수행 할 명령, 이름에 값 출력
                a = editdt.getText().toString();
                b = editdt2.getText().toString();
                c = spinner.getSelectedItem().toString();
                databaseReference.child("식품명").push().setValue(a);
                databaseReference.child("구매일자").push().setValue(b);
                databaseReference.child("카테고리").push().setValue(c);
            }
        });
    }



    // 유통기한 날짜 선택하기
    public void clickDate(View view){
       if(view == btn_date){
            final Calendar c = Calendar.getInstance();
            int mYear = c.get(Calendar.YEAR);
            int mMonth = c.get(Calendar.MONTH);
            int mDay = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    btn_date.setText(year+" / "+(month+1)+" / "+dayOfMonth);
                }
            },mYear,mMonth,mDay);
            datePickerDialog.show();
        }
    }

}
