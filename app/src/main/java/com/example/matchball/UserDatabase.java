package com.example.matchball;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class UserDatabase extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<User> arrayList;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userdb);

        recyclerView = findViewById(R.id.recyclerView); //아이디 연결
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        arrayList = new ArrayList<>();// user 객체를 담을 arraylist  *adapter쪽으로

        database = FirebaseDatabase.getInstance(); //파이어베이스 데이터베이스연동


//        databaseReference = database.getReference("matchball");
//        databaseReference = database.getReference("UserAccount");
        databaseReference = database.getReference("User");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //파이어베이스 데이터베이스의 데이터를 받아오는곳
                arrayList.clear();//기존 배열리스트 초기화.
                for(DataSnapshot snapshot1 : snapshot.getChildren()){ //옛날버전이라 스냅샷1로 ㄱㄱ
                    User user = snapshot.getValue(User.class);//만들어둔 User객체에 데이터를 담는다
                    arrayList.add(user);//담은 데이터들을 배열리스트에 넣고 리사이클러뷰로 보낼준비
                }
                adapter.notifyDataSetChanged(); //리스트 저장 및 새로고침
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //db 가져오던중 에러 발생시
                DatabaseError databaseError = null;
                Log.e("UserDatabase",String.valueOf(databaseError.toException())); //tag에는 현재 액티비티  / 에러문 출력

            }
        });


        adapter = new CustomAdapter(arrayList,this); //넘겨받음
        recyclerView.setAdapter(adapter);









    }
}