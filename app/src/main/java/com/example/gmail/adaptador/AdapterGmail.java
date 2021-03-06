package com.example.gmail.adaptador;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.gmail.R;
import com.example.gmail.modelo.ModelActivity;

import java.util.List;
import java.util.Random;

public class AdapterGmail extends RecyclerView.Adapter<AdapterGmail.ViewHolder>{
    private List<ModelActivity> modelActivityList ;
    private Context context;
    public AdapterGmail(List<ModelActivity> modelActivityList, Context context) {
        this.modelActivityList = modelActivityList;
        this.context = context;
    }

    @Override
    public AdapterGmail.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_view_gmail,parent,false);
        return new ViewHolder(v);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ModelActivity modelActivity = modelActivityList.get(position);

        //This will randomly color all circle
        Random mRandom = new Random();
        int color = Color.argb(255, mRandom.nextInt(256), mRandom.nextInt(256), mRandom.nextInt(256));
      //  ((ColorDrawable) holder.textCircle.getBackground()).setColor(color);

        holder.textCircle.setBackgroundColor(color);
        /*String currentUrl = modelActivity.getCircleText();
        Glide.with(context)
                .load(currentUrl)
                .into(Holder.ivFoto);*/

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

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textHead,textSub,textDes,textDate;
        TextView textCircle;
        public ViewHolder(View itemView) {
            super(itemView);
            //textCircle = (ImageView) itemView.findViewById(R.id.circleText);
            textCircle = (TextView)itemView.findViewById(R.id.circleText);
            textHead = (TextView)itemView.findViewById(R.id.headText);
            textSub = (TextView)itemView.findViewById(R.id.subText);
            textDes = (TextView)itemView.findViewById(R.id.desText);
            textDate = (TextView)itemView.findViewById(R.id.dateText);
        }
    }
}
