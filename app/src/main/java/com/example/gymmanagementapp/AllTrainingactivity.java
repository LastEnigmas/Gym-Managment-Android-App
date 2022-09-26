package com.example.gymmanagementapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Collections;

public class AllTrainingactivity extends AppCompatActivity {
    private RecyclerView recyclerview;
    private Trainingsadapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_trainingactivity);
        recyclerview=findViewById(R.id.recyclerview);
        adapter=new Trainingsadapter(this);
        recyclerview.setAdapter(adapter);
        recyclerview.setLayoutManager(new GridLayoutManager(this,2));
        ArrayList<Training> allTrainings=utils.getTrainings();

        if(null != allTrainings){
            adapter.setTrainings(allTrainings);
        }

        ItemTouchHelper helper=new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT|ItemTouchHelper.UP|ItemTouchHelper.DOWN,0) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                int from=viewHolder.getAbsoluteAdapterPosition();
                int to=target.getAbsoluteAdapterPosition();
                Collections.swap(allTrainings,from,to);
                adapter.notifyItemMoved(from,to);
                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

            }
        });
        helper.attachToRecyclerView(recyclerview);


    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}