package com.example.gmail.adaptador;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gmail.R;
import com.example.gmail.modelo.ModelActivity;

import java.util.List;
import java.util.Random;

public class AdapterActivity extends RecyclerView.Adapter<AdapterActivity.ViewHolder> {
    private List<ModelActivity> modelActivityList ;
    private Context context;

    public AdapterActivity(List<ModelActivity> modelActivityList, Context applicationContext) {

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_view,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ModelActivity modelActivity = modelActivityList.get(position);

        //This will randomly color all circle
        Random mRandom = new Random();
        int color = Color.argb(255, mRandom.nextInt(256), mRandom.nextInt(256), mRandom.nextInt(256));
        ((GradientDrawable) holder.textCircle.getBackground()).setColor(color);

        holder.textCircle.setText(modelActivity.getCircleText());
        holder.textHead.setText(modelActivity.getHeadText());
        holder.textSub.setText(modelActivity.getSubText());
        holder.textDes.setText(modelActivity.getDesText());
        holder.textDate.setText(modelActivity.getDateText());
    }

    @Override
    public int getItemCount() {
        return modelActivityList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textCircle,textHead,textSub,textDes,textDate;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textCircle = (TextView)itemView.findViewById(R.id.circleText);
            textHead = (TextView)itemView.findViewById(R.id.headText);
            textSub = (TextView)itemView.findViewById(R.id.subText);
            textDes = (TextView)itemView.findViewById(R.id.desText);
            textDate = (TextView)itemView.findViewById(R.id.dateText);
        }
    }
}
