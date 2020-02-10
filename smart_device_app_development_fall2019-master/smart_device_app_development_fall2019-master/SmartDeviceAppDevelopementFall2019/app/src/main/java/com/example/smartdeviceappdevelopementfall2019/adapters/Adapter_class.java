package com.example.smartdeviceappdevelopementfall2019.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartdeviceappdevelopementfall2019.R;
import com.example.smartdeviceappdevelopementfall2019.entity.Employee;
import com.example.smartdeviceappdevelopementfall2019.models.Adapter_data_models;

import java.util.ArrayList;

public class Adapter_class  extends RecyclerView.Adapter<Adapter_class.UserInfoViewHolder>{
    ArrayList<Employee> myList;
    Context context;

    public Adapter_class(ArrayList<Employee> myList, Context context) {
        this.myList = myList;
        this.context = context;
    }

    @NonNull
    @Override
    public UserInfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_view,null);
        return new UserInfoViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull UserInfoViewHolder holder, int position) {
        Employee adapter_data_models = this.myList.get(position);

        holder.name.setText("name:"+ adapter_data_models.name);
        holder.contact.setText("Age:"+adapter_data_models.age);
        holder.status.setText("Salary:"+adapter_data_models.salary);
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    class UserInfoViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView contact;
        TextView status;

        public   UserInfoViewHolder(@NonNull View itemView) {
            super(itemView);


            name = itemView.findViewById(R.id.nameId);
            contact = itemView.findViewById(R.id.contactNumberID);
            status = itemView.findViewById(R.id.status);
        }
    }
}
