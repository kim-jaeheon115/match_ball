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










/*
package net.flow9.dcjt.firebase.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import net.flow9.dcjt.firebase.Find_Object_detail;
import net.flow9.dcjt.firebase.R;
import net.flow9.dcjt.firebase.model.Post;

import java.util.ArrayList;

public class find_PostAdapter extends RecyclerView.Adapter<find_PostAdapter.CustomViewHolder> {

        private ArrayList<Post> arrayList;
        private Context context;

        public find_PostAdapter(ArrayList<Post> arrayList, Context context){
            this.arrayList = arrayList;
            this.context = context;
        }
    @NonNull
    @Override
    public find_PostAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);
        find_PostAdapter.CustomViewHolder holder = new CustomViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

        Post post = arrayList.get(position);

        holder.item_post_ObjNum.setText(arrayList.get(position).getItem_post_ObjNum());
        Glide.with(holder.item_post_image).load(arrayList.get(position).getItem_post_image()).into(holder.item_post_image);
        holder.L_category.setText(arrayList.get(position).getL_category());
        holder.M_category.setText(arrayList.get(position).getM_category());
        holder.item_post_title.setText(arrayList.get(position).getItem_post_title());
        holder.item_post_date.setText(arrayList.get(position).getItem_post_date());

        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int mPosition = holder.getAdapterPosition();
                Intent intent = new Intent(context, Find_Object_detail.class);
                intent.putExtra("ObjNum", arrayList.get(mPosition).getItem_post_ObjNum());
                context.startActivity(intent);
            }
        });
    }


        @Override
        public int getItemCount() {
            return (null != arrayList ? arrayList.size() : 0);
        }
        public class CustomViewHolder extends RecyclerView.ViewHolder {
            protected ImageView item_post_image;
            protected TextView L_category;
            protected TextView M_category;
            protected TextView item_post_title;
            protected TextView item_post_date;
            protected TextView item_post_ObjNum;

            public CustomViewHolder(@NonNull View itemView) {
                super(itemView);

                this.item_post_ObjNum = itemView.findViewById(R.id.item_post_ObjNum);
                this.item_post_image = (ImageView) itemView.findViewById(R.id.item_post_image);
                this.L_category = (TextView) itemView.findViewById(R.id.L_category);
                this.M_category = (TextView) itemView.findViewById(R.id.M_category);
                this.item_post_title = (TextView) itemView.findViewById(R.id.item_post_title);
                this.item_post_date = (TextView) itemView.findViewById(R.id.item_post_date);
            }
        }
    }




 */