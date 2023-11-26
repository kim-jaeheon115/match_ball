package com.example.matchball;


import android.content.Context;
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

    private ArrayList<User> arrayList;
    private Context context;

    public CustomAdapter(ArrayList<User> arrayList, Context context) {
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
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) { //실제적으로 매칭을 시켜줌
        Glide.with(holder.itemView)
                .load(arrayList.get(position).getProfile())
                .into(holder.iv_profile);
        holder.tv_id.setText(arrayList.get(position).getId());
        holder.tv_pw.setText(String.valueOf(arrayList.get(position).getPw()));
        holder.tv_un.setText(arrayList.get(position).getUserName());
        holder.tv_age.setText(arrayList.get(position).getAge());
        holder.tv_pn.setText(arrayList.get(position).getpNumber());

    }

    @Override
    public int getItemCount() {
        return (arrayList !=null ? arrayList.size():0);//삼항연산자
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_profile;
        TextView tv_id,tv_pw,tv_un,tv_age,tv_pn; //id,비밀번호,유저네임,나이,전화번호

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.iv_profile = itemView.findViewById(R.id.iv_profile);
            this.tv_id = itemView.findViewById(R.id.tv_id);
            this.tv_pw = itemView.findViewById(R.id.tv_pw);
            this.tv_un = itemView.findViewById(R.id.tv_userName);
            this.tv_age = itemView.findViewById(R.id.tv_age);
            this.tv_pn = itemView.findViewById(R.id.tv_phoneNumbers);
        }
    }
}
