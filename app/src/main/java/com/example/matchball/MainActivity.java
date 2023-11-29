package com.example.matchball;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mFirebaseAuth = FirebaseAuth.getInstance();

        Button btn_logout = findViewById(R.id.btn_logout);
        Button btn_customset = findViewById(R.id.btn_customset);

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //로그아웃하기
                mFirebaseAuth.signOut();
                Intent intent = new Intent(MainActivity.this , LoginActivity.class);
                startActivity(intent);

                finish();
                // 팩트
            }
        });

        btn_customset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),UserDatabase.class); //누르면 이동할곳 =>Userdatabase.java로 간다
                startActivity(intent);//인텐트시작
            }
        });

//        mFirebaseAuth.getCurrentUser().delete(); //탈퇴처리 주의



    }
}