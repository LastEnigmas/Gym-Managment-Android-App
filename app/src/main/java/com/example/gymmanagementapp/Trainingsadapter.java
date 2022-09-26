package com.example.gymmanagementapp;

import static com.example.gymmanagementapp.TrainingActivity.Training_key;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class Trainingsadapter extends RecyclerView.Adapter<Trainingsadapter.Viewholder> {
    private static final String TAG = "Trainingsadapter";

    private ArrayList<Training> trainings=new ArrayList<>();
    private Context context;

    public Trainingsadapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.training_item,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        Log.d(TAG,"onBindViewHolder: Started");
        holder.Activityname.setText(trainings.get(position).getName());
        holder.shortdesc.setText(trainings.get(position).getShortdesc());
        Glide.with(context).asBitmap().load(trainings.get(position).getImageurl()).into(holder.image);
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,TrainingActivity.class);
                intent.putExtra(Training_key,trainings.get(position));
                context.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return trainings.size();
    }
    public void setTrainings(ArrayList<Training> trainings){
        this.trainings=trainings;
        notifyDataSetChanged();
    }

    public class Viewholder extends RecyclerView.ViewHolder{

        private MaterialCardView parent;
        private ImageView image;
        private TextView Activityname;
        private TextView shortdesc;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            parent=itemView.findViewById(R.id.parent);
            image=itemView.findViewById(R.id.activityimg);
            Activityname=itemView.findViewById(R.id.activityname);
            shortdesc=itemView.findViewById(R.id.shortdec);
        }
    }
}
