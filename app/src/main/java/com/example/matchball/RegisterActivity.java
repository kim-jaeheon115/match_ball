package com.example.matchball;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {
//3

    private FirebaseAuth mFirebaseAuth;
    private DatabaseReference mDatabaseRef;
    private EditText mEtEmail , mEtPwd ,mEtpnumber, mEtNickname,mEtname , mEtage; //이메일 ,비밀번호 , 폰번호 ,닉네임 ,이름 ,나이
    private Button mBtnRegister;

//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("matchball");

        mEtEmail = (EditText) findViewById(R.id.et_email);
        mEtPwd = (EditText) findViewById(R.id.et_pwd);
        mEtpnumber = (EditText) findViewById(R.id.et_pnumber);
        mEtNickname = (EditText) findViewById(R.id.et_Nickname);
        mBtnRegister =(Button) findViewById(R.id.btn_register);
        mEtname = (EditText) findViewById(R.id.et_name);
        mEtage = (EditText) findViewById(R.id.et_age);


        mBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                {
                    //회원가입처리 완료 깃허브 추가
                    String strEmail = mEtEmail.getText().toString();
                    String strPwd = mEtPwd.getText().toString();
                    String strpnumber = mEtpnumber.getText().toString();
                    String strNickname = mEtNickname.getText().toString();
                    String strname = mEtname.getText().toString();
                    String strage = mEtage.getText().toString();


                    //firebase auth 진행
                    mFirebaseAuth.createUserWithEmailAndPassword(strEmail,strPwd).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task)
                        {
                         //회원가입 성공시
                         if(task.isSuccessful()) {
                             FirebaseUser firebaseUser = mFirebaseAuth.getCurrentUser();
                             UserAccount account = new UserAccount();
                             account.setIdToken(firebaseUser.getUid());
                             account.setEmailId(firebaseUser.getEmail());
                             account.setPassword(strPwd);
                             account.setPhonenumber(strpnumber); //폰넘버까지 구현
                             account.setNickname(strNickname);
                             account.setName(firebaseUser.getDisplayName());
                             account.setAge(strage);



                             //setValue : 데이터베이스에 삽입하는행위
                             mDatabaseRef.child("UserAccount").child(firebaseUser.getUid()).setValue(account);

                             Toast.makeText(RegisterActivity.this, "회원가입에 성공했어요!", Toast.LENGTH_SHORT).show();
                         }else {
                             Toast.makeText(RegisterActivity.this, "회원가입에 실패 , 이메일형식으로  다시 생성해주세요!", Toast.LENGTH_SHORT).show();


                         }
                        }
                    });
                }
            }
        });

    }
}