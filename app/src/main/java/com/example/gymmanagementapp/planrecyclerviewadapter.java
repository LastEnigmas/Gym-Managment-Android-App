package com.example.gymmanagementapp;

import static com.example.gymmanagementapp.TrainingActivity.Training_key;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class planrecyclerviewadapter extends RecyclerView.Adapter<planrecyclerviewadapter.Viewholder> {

    public interface Removedplan{
        void onRemovbePlan(Plan plan);
    }

    private Removedplan removeplan;

    private ArrayList<Plan> plans=new ArrayList<>();
    private Context context;
    private String type;
    public planrecyclerviewadapter(Context context){
        this.context=context;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.plan_item,parent,false);

        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.txtName.setText(plans.get(position).getTraining().getName());
        holder.txtDescription.setText(plans.get(position).getTraining().getShortdesc());
        holder.txtTime.setText(String.valueOf(plans.get(position).getMinutes()));
        Glide.with(context).asBitmap().load(plans.get(position).getTraining().getImageurl()).into(holder.image);
        if(plans.get(position).isIsaccomplished()){
            holder.emptycircle.setVisibility(View.GONE);
            holder.checkedcircles.setVisibility(View.VISIBLE);
        }else {
            holder.emptycircle.setVisibility(View.VISIBLE);
            holder.checkedcircles.setVisibility(View.GONE);

        }

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,TrainingActivity.class);

                intent.putExtra(Training_key,plans.get(position).getTraining());
                context.startActivity(intent);
            }
        });

        if(type!=null) {

            if (type.equals("edit")) {
                holder.emptycircle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                                .setTitle("Finished").setMessage("Have you finished " + plans.get(position).getTraining().getName() + "?")
                                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                    }
                                })
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                        for (Plan p : utils.getPlans()) {

                                            if (p.equals(plans.get(position))) {
                                                p.setIsaccomplished(true);
                                            }
                                        }
                                        notifyDataSetChanged();

                                    }
                                });
                        builder.create().show();
                    }
                });
            }
        }
        holder.parent.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                AlertDialog.Builder builder =new AlertDialog.Builder(context)
                        .setTitle("Remove").setMessage("Are you sure you want to delete this plan? ")
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        }).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                try {
                                    removeplan=(Removedplan) context;
                                    removeplan.onRemovbePlan(plans.get(position));

                                }catch (ClassCastException e){
                                    e.printStackTrace();
                                }


                            }
                        });

                builder.create().show();

                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return plans.size();
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPlans(ArrayList<Plan> plans){
        this.plans=plans;
        notifyDataSetChanged();
    }

    public class Viewholder extends RecyclerView.ViewHolder{

        private TextView txtTime,txtName,txtDescription;
        private MaterialCardView parent;
        private ImageView image,emptycircle,checkedcircles;


        public Viewholder(@NonNull View itemView) {
            super(itemView);

            txtName=itemView.findViewById(R.id.trainingname);
            txtTime=itemView.findViewById(R.id.time);
            txtDescription=itemView.findViewById(R.id.description);
            parent=itemView.findViewById(R.id.parent);
            image=itemView.findViewById(R.id.trainingimage1);
            emptycircle=itemView.findViewById(R.id.emptycircle);
            checkedcircles=itemView.findViewById(R.id.checkedcircle);
        }
    }
}
