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
    EditText et_teamname,et_nation,et_location ;
    RadioGroup rg_gender , rg_foot;
    Button btn_finish;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);//하나의 xml만 연동가능

        EditText et_tname = findViewById(R.id.et_teamname);
        EditText et_nation =findViewById(R.id.et_nation);
        EditText et_location =findViewById(R.id.et_location);

        RadioGroup rg_gender = findViewById(R.id.rg_gender);
        RadioGroup rg_foot = findViewById(R.id.rg_foot);

        Button btn_finish = findViewById(R.id.btn_finish);
        Button btn_jump = findViewById(R.id.btn_jump);

        btn_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //완료버튼을 누르면
                Intent intent = new Intent(User_register.this,MainActivity.class);
                startActivity(intent);
            }
        });

        btn_jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //건너뛰기
                Intent intent = new Intent(User_register.this,MainActivity.class);
                startActivity(intent);
            }
        });










    }
}
