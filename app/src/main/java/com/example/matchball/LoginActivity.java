package com.example.matchball;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {
//로그인자바


    private FirebaseAuth mFirebaseAuth;  //파이어베이스 인증
    private DatabaseReference mDatabaseRef;  //실시간 데이터베이스
    private EditText mEtEmail , mEtPwd; //로그인 입력필드

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);//하나의 xml만 연동가능


        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("matchball");

        mEtEmail = (EditText) findViewById(R.id.et_email);
        mEtPwd = (EditText) findViewById(R.id.et_pwd);

        Button btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //로그인요청
                String strEmail = mEtEmail.getText().toString();
                String strPwd = mEtPwd.getText().toString();

                mFirebaseAuth.signInWithEmailAndPassword(strEmail,strPwd).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            //로그인성공
                            Toast.makeText(LoginActivity.this,"환영합니다",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this, Register_complete.class);
                            startActivity(intent);
                            finish(); //현재액티비티 ㅊ파괴
                        }else{
                            //로그인 실패
                            Toast.makeText(LoginActivity.this,"로그인 실패!!",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });

        Button btn_register = findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //회원가입 화면으로 이동
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);

            }
        });
    }
}
