package com.example.springct_coding;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.WindowDecorActionBar;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EmployeeAdpater extends RecyclerView.Adapter<EmployeeAdpater.EmployeeViewHolder> {

    private Context context;
    private List<EmployeeAdpater> employeeList;

    public EmployeeAdpater(Context context,List<EmployeeAdpater> employeeList){
        this.context =context;
        this.employeeList=employeeList;
    }
    @NonNull
    public RecyclerView.ViewHolder EmployeeViewHolder(@NonNull ViewGroup parent, int viewType){
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_employee,parent,false);
        return new EmployeeViewHolder(view);
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_employee, parent, false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        EmployeeAdpater employee = employeeList.get(position);

        // Bind data to ViewHolder
        holder.nameTextView.setText(employee.getName());
        holder.ageTextView.setText(String.valueOf(employee.getAge()));
        holder.addressTextView.setText(employee.getAddress());
        holder.cityTextView.setText(employee.getCity());
    }

    private char getCity() {
        return 0;
    }

    private char getAddress() {
        return 0;
    }

    private int getAge() {
        return 0;
    }

    private int getName() {
    }


    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    public class EmployeeViewHolder extends RecyclerView.ViewHolder {
        public WindowDecorActionBar.TabImpl addressTextView;
        TextView nameTextView,ageTextView,addresssTextView,cityTextView;

        public EmployeeViewHolder(@NonNull View itemView){
            super(itemView);

            nameTextView=itemView.findViewById(R.id.nameEditText);
            ageTextView=itemView.findViewById(R.id.ageEditText);
            addresssTextView=itemView.findViewById(R.id.addressEditText);
            cityTextView=itemView.findViewById(R.id.cityEditText);
        }
    }
}
