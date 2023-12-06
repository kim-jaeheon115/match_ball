package com.example.matchball;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

//건너뛰기 -> 메인
//완료--> 다음 특성태그랑 포지션
public class User_register3 extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register3);

        Button btn_finish = findViewById(R.id.btn_finish);

        EditText my_cha = findViewById(R.id.my_char);
        TextView tv2 = findViewById(R.id.tv2);


        tv2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // 입력 전에 호출되는 메서드
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // 입력 중에 호출되는 메서드
                // 여기에서 TextView 등에 입력 내용을 즉시 표시할 수 있습니다.
                tv2.setText(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // 입력 후에 호출되는 메서드
            }
        });

        btn_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(User_register3.this,MainActivity.class);
                startActivity(intent);
            }
        });


    }

}
