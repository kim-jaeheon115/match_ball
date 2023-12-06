package com.example.matchball;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class User_register extends AppCompatActivity {
    // 본인등록 자바 페이지

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);//하나의 xml만 연동가능

        EditText et_tname = findViewById(R.id.et_teamname);
        EditText et_nation =findViewById(R.id.et_nation);
        EditText et_location =findViewById(R.id.et_location);

        RadioGroup rg_gender = findViewById(R.id.rg_gender);
        RadioGroup rg_foot = findViewById(R.id.rg_foot);

        Button btn_next = findViewById(R.id.btn_next);
        Button btn_jump = findViewById(R.id.btn_jump);

        btn_next.setOnClickListener(new View.OnClickListener() { //다음버튼
            @Override
            public void onClick(View view) {
                //다음버튼을 누르면
                Intent intent = new Intent(User_register.this,User_register2.class);
                startActivity(intent);
            }
        });

        btn_jump.setOnClickListener(new View.OnClickListener() { //건너뛰기버튼
            @Override
            public void onClick(View view) {
                //건너뛰기
                Intent intent = new Intent(User_register.this,MainActivity.class);
                startActivity(intent);
            }
        });










    }
}
