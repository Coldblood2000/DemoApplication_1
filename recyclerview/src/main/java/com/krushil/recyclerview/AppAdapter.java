package com.krushil.recyclerview;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

public class AppAdapter extends RecyclerView.Adapter<AppAdapter.AppHolder> {

    public AppAdapter(Context context, List<AppAndroid> list, Activity activity) {
        this.context = context;
        this.list = list;
        this.activity=activity;
    }

    private Context context;
    private List<AppAndroid> list;
    private AlertDialog.Builder builder;
    private  Activity activity;

    @NonNull
    @Override
    public AppHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.single_card,parent,false);
        return new AppHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final AppHolder holder, final int position) {
        holder.getName().setText(list.get(position).getName());
        holder.getImage().setImageResource(list.get(position).getImage());

        holder.getName().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Bundle bundle=new Bundle();
                bundle.putString("info",list.get(position).getName());

                Intent intent=new Intent(context,AppInfo.class);
                intent.putExtras(bundle);
                context.startActivity(intent);*/
                /*Snackbar snackbar = Snackbar
                        .make(holder.getLayout() , ""+list.get(position).getName(), Snackbar.LENGTH_LONG);

                snackbar.show();*/

                /*builder=new AlertDialog.Builder(context);
                builder.setTitle("Logout");
                builder.setCancelable(false);
                builder.setMessage("Are you sure?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        activity.finish();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                AlertDialog alertDialog=builder.create();
                alertDialog.show();*/

                showDialog();
            }
        });
    }

    private void showDialog(){
        final Dialog dialog=new Dialog(context);
        dialog.setContentView(R.layout.dialog_layout);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);

        Button yes_btn=dialog.findViewById(R.id.yes_btn);
        Button no_btn=dialog.findViewById(R.id.no_btn);

        yes_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.finish();
            }
        });

        no_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
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

        ConstraintLayout getLayout(){
            return itemView.findViewById(R.id.singleCardConstraint);
        }
    }
}
