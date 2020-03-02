package com.krushil.appedia;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AppAdapter extends RecyclerView.Adapter<AppAdapter.AppHolder> {
    public AppAdapter(Context context, List<AndroidApp> list, Activity activity) {
        this.context = context;
        this.list = list;
        this.activity=activity;
    }

    private Context context;
    private List<AndroidApp> list;
    private AlertDialog.Builder builder;
    private  Activity activity;

    @NonNull
    @Override
    public AppHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.single_card,parent,false);
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
            return itemView.findViewById(R.id.app_name_txt);
        }

        ImageView getImage(){
            return itemView.findViewById(R.id.card_img);
        }

        ConstraintLayout getLayout(){
            return itemView.findViewById(R.id.singleCardConstraint);
        }
    }
}
