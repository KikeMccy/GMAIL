package com.example.gmail.adaptador;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.gmail.R;
import com.example.gmail.modelo.ModelActivity;
import com.example.gmail.modelo.ModelWinzip;

import java.util.ArrayList;
import java.util.Random;

public class AdapterWinzip extends RecyclerView.Adapter<AdapterWinzip.ViewHolder> {

    private Context context;
    private ArrayList<ModelWinzip> listItems;

    public AdapterWinzip(Context context, ArrayList<ModelWinzip> listItems) {
        this.context = context;
        this.listItems = listItems;
    }

    @NonNull
    @Override
    public AdapterWinzip.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_view_winzip,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterWinzip.ViewHolder holder, int position) {
        ModelWinzip modelActivity = listItems.get(position);

        holder.tvcarpeta.setText(modelActivity.getCarpeta());
        holder.tvdetalle.setText(modelActivity.getDetalle());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView tvcarpeta,tvdetalle;
        public ViewHolder(View itemView) {
            super(itemView);
            tvcarpeta = (TextView)itemView.findViewById(R.id.carpeta);
            tvdetalle = (TextView)itemView.findViewById(R.id.detalleCarpeta);
        }
    }
}
