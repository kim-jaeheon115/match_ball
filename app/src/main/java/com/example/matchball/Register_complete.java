package com.example.matchball;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Register_complete extends AppCompatActivity {
    //로그인 후 가입 완료창
    //아래 두개버튼으로 본인등록,메인페이지 이동가능

    ImageView iv;
    TextView tv1,tv2;
    Button btn_self,btn_jump;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_complete);
        //새로운 활동에 대한 설정

        Button btn_self= findViewById(R.id.btn_register_yourself);
        Button btn_jump = findViewById(R.id.btn_jump);

        btn_self.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //본인등록버튼 누르면~>
                Intent intent =new Intent(Register_complete.this,User_register.class);
                startActivity(intent);
            }
        });


        btn_jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //건너뛰기버튼 누르면 ~>
                Intent intent =new Intent(Register_complete.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
