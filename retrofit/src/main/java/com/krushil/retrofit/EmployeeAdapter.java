package com.krushil.retrofit;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.krushil.retrofit.domain.DataItem;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeHolder> {

    public EmployeeAdapter(Context context, List<DataItem> list) {
        this.context = context;
        this.list = list;
    }

    private Context context;
    private List<DataItem> list;

    @NonNull
    @Override
    public EmployeeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.single_card,parent,false);
        return new EmployeeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeHolder holder, int position) {
        holder.getEmployeeName().setText(list.get(position).getEmployeeName());
        holder.getEmployeeAge().setText(list.get(position).getEmployeeAge());
        holder.getEmployeeSalary().setText(list.get(position).getEmployeeSalary());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class EmployeeHolder extends RecyclerView.ViewHolder{

        public EmployeeHolder(@NonNull View itemView) {
            super(itemView);
        }

        TextView getEmployeeName(){
            return itemView.findViewById(R.id.employee_name);
        }
        TextView getEmployeeAge(){
            return itemView.findViewById(R.id.employee_age);
        }
        TextView getEmployeeSalary(){
            return itemView.findViewById(R.id.employee_salary);
        }
    }
}
