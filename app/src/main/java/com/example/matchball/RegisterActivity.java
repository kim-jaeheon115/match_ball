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
//356

    private FirebaseAuth mFirebaseAuth;
    private DatabaseReference mDatabaseRef;
    private EditText mEtEmail , mEtPwd ,mEtpnumber; //이메일 ,비밀번호 , 폰번호 + 깃허브 마지막추가
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
        mBtnRegister =(Button) findViewById(R.id.btn_register);

        mBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                {
                    //회원가입처리 완료 깃허브 추가
                    String strEmail = mEtEmail.getText().toString();
                    String strPwd = mEtPwd.getText().toString();
                    String strpnumber = mEtpnumber.getText().toString();


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
                             account.setPhoneNumper(firebaseUser.getPhoneNumber()); //폰넘버까지 구현

                             //setValue : 데이터베이스에 삽입하는행위
                             mDatabaseRef.child("UserAccount").child(firebaseUser.getUid()).setValue(account);

                             Toast.makeText(RegisterActivity.this, "회원가입에 성공하셨습니다!", Toast.LENGTH_SHORT).show();
                         }else {
                             Toast.makeText(RegisterActivity.this, "회원가입에 실패하셨습니다!", Toast.LENGTH_SHORT).show();


                         }
                        }
                    });
                }
            }
        });

    }
}