package com.example.matchball;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {
    private static final String TAG = "CustomAdapter";
//리사이클링자바
    private ArrayList<UserAccount> arrayList;
    private Context context;

    public CustomAdapter(ArrayList<UserAccount> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { //실제 리스트뷰가 어뎁에 연결된후 뷰홀더를 만들어냄
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        CustomViewHolder holder = new CustomViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) { //실제적으로 매칭을 시켜줌 값 받아옴

        UserAccount userAccount = arrayList.get(position);

        holder.tv_id.setText(arrayList.get(position).getEmailId());
        holder.tv_un.setText(arrayList.get(position).getNickname());
        holder.tv_age.setText(arrayList.get(position).getAge());
        holder.tv_pn.setText(arrayList.get(position).getPhonenumber());

        Log.d(TAG, "userName : " + holder.tv_un.getText().toString());

        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() { //추가한내용
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,MainActivity.class);
                context.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return (arrayList !=null ? arrayList.size():0);//삼항연산자
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        // ImageView iv_profile;
        TextView tv_id,tv_un,tv_age,tv_pn; //id,유저네임,나이,전화번호

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tv_id = itemView.findViewById(R.id.tv_id);
            this.tv_un = itemView.findViewById(R.id.tv_userName);
            this.tv_age = itemView.findViewById(R.id.tv_age);
            this.tv_pn = itemView.findViewById(R.id.tv_phoneNumbers);
        }
    }
}






