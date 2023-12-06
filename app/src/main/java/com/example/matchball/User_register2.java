package com.example.matchball;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

//건너뛰기 -> 메인
//완료--> 다음 특성태그랑 포지션
public class User_register2 extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register2);

        Button btn_next = findViewById(R.id.btn_next2);
        Button btn_jump = findViewById(R.id.btn_jump2);

        EditText pre_po = findViewById(R.id.prefer_position);


        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("User_register2", "Next button clicked");
                Intent intent = new Intent(User_register2.this,User_register3.class);
                startActivity(intent);
            }
        });

        btn_jump.setOnClickListener(new View.OnClickListener() { //건너뛰기버튼
            @Override
            public void onClick(View view) {
                //건너뛰기
                Intent intent = new Intent(User_register2.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
