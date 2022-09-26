package com.example.gymmanagementapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class EditActivity extends AppCompatActivity implements planrecyclerviewadapter.Removedplan {

    private static final String TAG = "EditActivity";
    private TextView txtday;
    private RecyclerView recyclerview;
    private Button btnaddtoplan;

    private planrecyclerviewadapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        initview();
        adapter=new planrecyclerviewadapter(this);
        adapter.setType("edit");
        recyclerview.setAdapter(adapter);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));


        Intent intent=getIntent();
        if(null!=intent){
            String day=intent.getStringExtra("day");
            if(day!=null){
                txtday.setText(day);
                ArrayList<Plan> plans=getPlanByDay(day);
                adapter.setPlans(plans);
            }


        }

        btnaddtoplan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(EditActivity.this,AllTrainingactivity.class);
                startActivity(intent);
            }
        });
    }

    private void initview() {

        txtday=findViewById(R.id.txtDay);
        recyclerview=findViewById(R.id.edtrecy);
        btnaddtoplan=findViewById(R.id.btnaddmoretoplan);
    }

    private ArrayList<Plan> getPlanByDay(String day){
        ArrayList<Plan> allplans=utils.getPlans();
        ArrayList<Plan> plans=new ArrayList<>();
        for (Plan p:allplans){
            if(p.getDay().equalsIgnoreCase(day)){
                plans.add(p);
            }
        }
        return plans;
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(this,PlanActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }

    @Override
    public void onRemovbePlan(Plan plan) {
        if(utils.removeplan(plan)){
            Toast.makeText(this,"Training removed from your plan",Toast.LENGTH_SHORT).show();
            adapter.setPlans(getPlanByDay(plan.getDay()));
            adapter.setType("edit");
        }
    }
}