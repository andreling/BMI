package com.example.bmi.Recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bmi.Object.Tips;
import com.example.bmi.R;

import java.util.ArrayList;

public class TipsAdapter extends RecyclerView.Adapter<TipsAdapter.TipsViewHolder> {
    @NonNull
    private final RecycleInterface _recycleInterface;
    Context _context;
    ArrayList<Tips> _tips;

    public TipsAdapter(@NonNull RecycleInterface recycleInterface, Context context, ArrayList<Tips> tips) {
        _recycleInterface = recycleInterface;
        _context = context;
        _tips = tips;
    }

    @Override
    public TipsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(_context).inflate(R.layout.tips_layout, parent, false);
        TipsViewHolder ViewHolder = new TipsViewHolder(itemView, _recycleInterface);
        return ViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TipsViewHolder holder, int position) {
        holder.tips_title_txt.setText(_tips.get(position).getTitle());
        holder.tips_image_txt.setImageResource(_tips.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return _tips.size();
    }

    public class TipsViewHolder extends RecyclerView.ViewHolder{
        public TextView tips_title_txt;
        public ImageView tips_image_txt;

        public TipsViewHolder(View itemView, RecycleInterface recycleInterface) {
            super(itemView);
            tips_image_txt = itemView.findViewById(R.id.tips_image);
            tips_title_txt = itemView.findViewById(R.id.tips_title);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (_recycleInterface != null){
                        int pos = getAdapterPosition();
                        if(pos!= RecyclerView.NO_POSITION){
                            _recycleInterface.onClickItem(pos);
                        }
                    }
                }
            });
        }


    }
}

