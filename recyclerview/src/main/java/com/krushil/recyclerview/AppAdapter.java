package com.krushil.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AppAdapter extends RecyclerView.Adapter<AppAdapter.AppHolder> {

    public AppAdapter(Context context, List<AppAndroid> list) {
        this.context = context;
        this.list = list;
    }

    private Context context;
    private List<AppAndroid> list;

    @NonNull
    @Override
    public AppHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.single_card,parent,false);
        return new AppHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AppHolder holder, final int position) {
        holder.getName().setText(list.get(position).getName());
        holder.getImage().setImageResource(list.get(position).getImage());

        holder.getName().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle=new Bundle();
                bundle.putString("info",list.get(position).getName());

                Intent intent=new Intent(context,AppInfo.class);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class AppHolder extends RecyclerView.ViewHolder{

        public AppHolder(@NonNull View itemView) {
            super(itemView);
        }

        TextView getName(){
            return itemView.findViewById(R.id.card_txt);
        }

        ImageView getImage(){
            return itemView.findViewById(R.id.card_img);
        }
    }
}
