package com.example.bmi.Recyclerview;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bmi.R;

public class HistoryViewHolder extends RecyclerView.ViewHolder {
    public TextView BMI,Health,Date,Time;
    public HistoryViewHolder(@NonNull View itemview){
        super(itemview);

        BMI = itemview.findViewById(R.id.history_ibm_edit);
        Health = itemview.findViewById(R.id.history_health_edit);
        Date = itemview.findViewById(R.id.history_date_edit);
        Time = itemview.findViewById(R.id.history_time_edit);
    }
}
