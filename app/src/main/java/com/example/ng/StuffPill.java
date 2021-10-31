package com.example.ng;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.util.Calendar;
import java.util.HashMap;
import java.util.UUID;

<<<<<<< HEAD
//test12
=======
//test
>>>>>>> aelim

public class StuffPill extends AppCompatActivity {

    ImageView imageView;
    private Bitmap image;
    private StorageReference mStorageRef;

<<<<<<< HEAD
    Button btn_date;
    DatePickerDialog datePickerDialog;
    Spinner spinner;

    //firebase 연동
    private Button sendbt;
=======
    Button btn_date2;
    DatePickerDialog datePickerDialog;
    Spinner spinner2;

    //firebase 연동
    private Button send;
>>>>>>> aelim
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    //firebase 데이터 저장
<<<<<<< HEAD
    private EditText editdt, editdt2;
    public String e, f, g, h;
=======
    private EditText edit, edit2;
    public String a, b, c, d;
>>>>>>> aelim

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plus_pill);

        mStorageRef = FirebaseStorage.getInstance().getReference();

<<<<<<< HEAD
        btn_date = findViewById(R.id.btn_pillDate2); //캘린더
        spinner = findViewById(R.id.spinner_pillCategory);   //카테고리
=======
        btn_date2 = findViewById(R.id.btn_pillDate2); //캘린더
        spinner2 = findViewById(R.id.spinner_pillCategory);   //카테고리
>>>>>>> aelim

        //카테고리 선택
        ArrayAdapter monthAdapter = ArrayAdapter.createFromResource(this, R.array.pillCategory, android.R.layout.simple_spinner_dropdown_item);
        //R.array.category는 저희가 정의해놓은 카테고리 / android.R.layout.simple_spinner_dropdown_item은 기본으로 제공해주는 형식입니다.
        monthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
<<<<<<< HEAD
        spinner.setAdapter(monthAdapter); //어댑터에 연결해줍니다.

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
=======
        spinner2.setAdapter(monthAdapter); //어댑터에 연결해줍니다.

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
>>>>>>> aelim
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            } //이 오버라이드 메소드에서 position은 몇번째 값이 클릭됬는지 알 수 있습니다.

            //getItemAtPosition(position)를 통해서 해당 값을 받아올수있습니다.
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        //카메라 실행
        imageView = (ImageView) findViewById(R.id.imageView_pill);
        imageView.setOnClickListener(this::onClick);

<<<<<<< HEAD
        //firebase 식품명 저장
        sendbt = (Button) findViewById(R.id.btn_savepill);
        editdt = (EditText) findViewById(R.id.text_pillName);
        editdt2 = (EditText) findViewById(R.id.btn_pillDate);
        btn_date = (Button) findViewById(R.id.btn_pillDate2);
        spinner = (Spinner)findViewById(R.id.spinner_pillCategory);

        sendbt.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                // 버튼 누르면 수행 할 명령, 이름에 값 출력
                e = editdt.getText().toString();
                f = editdt2.getText().toString();
                g = spinner.getSelectedItem().toString();
                h = btn_date.getText().toString();

                HashMap result = new HashMap<>();
                result.put("식품명", e);
                result.put("구매일자", f);
                result.put("유통기한", g);
                result.put("카테고리", h);
                databaseReference.child("pill").push().setValue(result);
=======

        //firebase 식품명 저장
        send = (Button) findViewById(R.id.btn_savepill);
        edit = (EditText) findViewById(R.id.text_pillName);
        edit2 = (EditText) findViewById(R.id.btn_pillDate);
        btn_date2 = (Button) findViewById(R.id.btn_pillDate2);
        spinner2 = (Spinner)findViewById(R.id.spinner_pillCategory);

        send.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                // 버튼 누르면 수행 할 명령, 이름에 값 출력
                a = edit.getText().toString();
                b = edit2.getText().toString();
                c = btn_date2.getText().toString();
                d = spinner2.getSelectedItem().toString();

                HashMap result2 = new HashMap<>();
                result2.put("약품명", a);
                result2.put("구매일자", b);
                result2.put("유통기한", c);
                result2.put("카테고리", d);

                databaseReference.child("pill").push().setValue(result2);
>>>>>>> aelim

                upload();

                Intent myIntent = new Intent(getApplicationContext(), PillListView.class);
                startActivity(myIntent);
            }
        });
<<<<<<< HEAD
=======

>>>>>>> aelim
    }

    public void onClick(View view) {
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i,0);
    }

<<<<<<< HEAD
=======

>>>>>>> aelim
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 0 && resultCode == RESULT_OK) {
            image = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(image);
        }
    }

    private void upload() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 100, stream);

<<<<<<< HEAD

        final String random = UUID.randomUUID().toString();
        StorageReference imageRef = mStorageRef.child("image/" + random);
=======
        final String random = UUID.randomUUID().toString();
        StorageReference imageRef = mStorageRef.child("pill/" + random);
>>>>>>> aelim

        byte[] b = stream.toByteArray();
        imageRef.putBytes(b)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

                        taskSnapshot.getMetadata().getReference().getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                Uri downloadUri = uri;
                            }
                        });

                        Toast.makeText(StuffPill.this, "Photo Uploaded", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

                        Toast.makeText(StuffPill.this, "Upload Failed", Toast.LENGTH_SHORT).show();
                    }
                });
    }


    // 유통기한 날짜 선택하기
    public void clickDate(View view){
<<<<<<< HEAD
        if(view == btn_date){
=======
        if(view == btn_date2){
>>>>>>> aelim
            final Calendar c = Calendar.getInstance();
            int mYear = c.get(Calendar.YEAR);
            int mMonth = c.get(Calendar.MONTH);
            int mDay = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
<<<<<<< HEAD
                    btn_date.setText(year+" / "+(month+1)+" / "+dayOfMonth);
=======
                    btn_date2.setText(year+" / "+(month+1)+" / "+dayOfMonth);
>>>>>>> aelim
                }
            },mYear,mMonth,mDay);
            datePickerDialog.show();
        }
    }

}