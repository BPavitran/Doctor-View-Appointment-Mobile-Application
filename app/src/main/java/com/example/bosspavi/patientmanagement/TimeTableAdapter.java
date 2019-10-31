package com.example.bosspavi.patientmanagement;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class TimeTableAdapter extends RecyclerView.Adapter<TimeTableAdapter.MyViewHolder> {

    ArrayList<Time> arrayList = new ArrayList<>();

    public TimeTableAdapter(ArrayList<Time> arrayList){
        this.arrayList=arrayList;
    }

    @Override
    public TimeTableAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.timetable_item,parent,false);
        TimeTableAdapter.MyViewHolder myViewHolder = new TimeTableAdapter.MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(TimeTableAdapter.MyViewHolder holder, int position) {
        holder.Day.setText(arrayList.get(position).getDay());
        holder.Time.setText(arrayList.get(position).getTime());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class MyViewHolder extends  RecyclerView.ViewHolder{

        TextView Day,Time;

        public MyViewHolder(View itemView) {
            super(itemView);
            Day=(TextView)itemView.findViewById(R.id.txtDay);
            Time=(TextView)itemView.findViewById(R.id.txtTime);
        }
    }

}
