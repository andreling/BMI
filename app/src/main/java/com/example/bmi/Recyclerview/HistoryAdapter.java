package com.example.bmi.Recyclerview;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bmi.R;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryViewHolder> {
    @NonNull
    Context _context;
    ArrayList id, UserID, Result,Health, Date, Time;

    public HistoryAdapter(@NonNull Context _context, ArrayList id, ArrayList userID, ArrayList result, ArrayList health, ArrayList date, ArrayList time) {
        this._context = _context;
        this.id = id;
        this.UserID = userID;
        this.Result = result;
        this.Health = health;
        this.Date = date;
        this.Time = time;
    }

    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(_context).inflate(R.layout.rv_layout, parent, false);
        HistoryViewHolder ViewHolder = new HistoryViewHolder(itemView);
        return ViewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {

        holder.BMI.setText(String.valueOf(Result.get(position))+ " BMI");
        holder.Health.setText(String.valueOf(Health.get(position)));
        holder.Date.setText(String.valueOf(Date.get(position)));
        holder.Time.setText(String.valueOf(Time.get(position)));

    }

    @Override
    public int getItemCount() {
        return id.size();
    }
}
