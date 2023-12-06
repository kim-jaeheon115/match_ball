package com.example.matchball;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Register_complete2 extends AppCompatActivity {
    //로그인 후 가입 완료창
    //아래 두개버튼으로 본인등록,메인페이지 이동가능


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_complete2);
        //새로운 활동에 대한 설정

        Button btn_jump2 = findViewById(R.id.btn_jump2);




        btn_jump2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //확인버튼 누르면 ~>
                Intent intent =new Intent(Register_complete2.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
