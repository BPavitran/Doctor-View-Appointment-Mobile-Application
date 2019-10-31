package com.example.bosspavi.patientmanagement;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AppointmentAdapter extends RecyclerView.Adapter <AppointmentAdapter.MyViewHolder>{

    ArrayList<Appointment> arrayList = new ArrayList<>();

    public AppointmentAdapter(ArrayList<Appointment> arrayList){
        this.arrayList=arrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.Name.setText(arrayList.get(position).getName());
        holder.Surname.setText(arrayList.get(position).getSurname());
        holder.Phone.setText(arrayList.get(position).getPhone());
        holder.Date.setText(arrayList.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class MyViewHolder extends  RecyclerView.ViewHolder{

        TextView Name,Surname,Phone,Date;

        public MyViewHolder(View itemView) {
            super(itemView);
            Name=(TextView)itemView.findViewById(R.id.txtName);
            Surname=(TextView)itemView.findViewById(R.id.txtSurname);
            Phone=(TextView)itemView.findViewById(R.id.txtPhone);
            Date=(TextView)itemView.findViewById(R.id.txtDate);
        }
    }
}
