package com.example.gymmanagementapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class PlanActivity extends AppCompatActivity {
    public static final String TAG="PlanActivity";
    private TextView mondayedt,tuesdayedt,wednesdayedt,thursdayedt,fridayedt,saturdayedt,sundayedt;
    private RecyclerView mondayrecy,tuesdayrecy,wednesdayrecy,thursdayrecy,fridayrecy,saturdayrecy,sundayrecy;
    private RelativeLayout noplanlayout;
    private NestedScrollView nestedScrollView;
    private Button btnaddplan;

    private planrecyclerviewadapter mondayadapt,tuesdayadapt,wednesdayadapt,thursdayadapt,fridayadapt,saturdayadapr,sundayadapt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);
        inintview();

        ArrayList<Plan> plans=utils.getPlans();
        if(null!= plans){
            if(plans.size()>0){
                noplanlayout.setVisibility(View.GONE);
                nestedScrollView.setVisibility(View.VISIBLE);
                initRecViews();
                setedtonclicklistener();

            }else {
                noplanlayout.setVisibility(View.VISIBLE);
                nestedScrollView.setVisibility(View.GONE);
                btnaddplan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(PlanActivity.this,AllTrainingactivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                });

            }

        }
        else {
            noplanlayout.setVisibility(View.VISIBLE);
            nestedScrollView.setVisibility(View.GONE);
            btnaddplan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(PlanActivity.this,AllTrainingactivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            });
        }


    }

    private void setedtonclicklistener() {
        Intent intent=new Intent(this,EditActivity.class);
        mondayedt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("day","Monday");
                startActivity(intent);
            }
        });
        tuesdayedt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("day","Tuesday");
                startActivity(intent);
            }
        });
        wednesdayedt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("day","Wednesday");
                startActivity(intent);
            }
        });
        thursdayedt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("day","Thursday");
                startActivity(intent);
            }
        });
        fridayedt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("day","Friday");
                startActivity(intent);
            }
        });
        saturdayedt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("day","Saturday");
                startActivity(intent);
            }
        });
        sundayedt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("day","Sunday");
                startActivity(intent);
            }
        });



    }

    private void initRecViews() {
        mondayadapt=new planrecyclerviewadapter(this);
        mondayrecy.setAdapter(mondayadapt);
        mondayrecy.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        mondayadapt.setPlans(getPlanByDay("Monday"));

        tuesdayadapt=new planrecyclerviewadapter(this);
        tuesdayrecy.setAdapter(tuesdayadapt);
        tuesdayrecy.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        tuesdayadapt.setPlans(getPlanByDay("Tuesday"));

        wednesdayadapt=new planrecyclerviewadapter(this);
        wednesdayrecy.setAdapter(wednesdayadapt);
        wednesdayrecy.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        wednesdayadapt.setPlans(getPlanByDay("Wednesday"));

        thursdayadapt=new planrecyclerviewadapter(this);
        thursdayrecy.setAdapter(thursdayadapt);
        thursdayrecy.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        thursdayadapt.setPlans(getPlanByDay("Thursday"));

        fridayadapt=new planrecyclerviewadapter(this);
        fridayrecy.setAdapter(fridayadapt);
        fridayrecy.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        fridayadapt.setPlans(getPlanByDay("Friday"));

        saturdayadapr=new planrecyclerviewadapter(this);
        saturdayrecy.setAdapter(saturdayadapr);
        saturdayrecy.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        saturdayadapr.setPlans(getPlanByDay("Saturday"));

        sundayadapt=new planrecyclerviewadapter(this);
        sundayrecy.setAdapter(sundayadapt);
        sundayrecy.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        sundayadapt.setPlans(getPlanByDay("Sunday"));






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

    private void inintview() {

        Log.d(TAG,"initViews: started");


        mondayedt=findViewById(R.id.edtmonday);
        tuesdayedt=findViewById(R.id.edttuesday);
        wednesdayedt=findViewById(R.id.edtWednesday);
        thursdayedt=findViewById(R.id.edtthursday);
        fridayedt=findViewById(R.id.edtfriday);
        saturdayedt=findViewById(R.id.edtsat);
        sundayedt=findViewById(R.id.edtsunday);

        mondayrecy=findViewById(R.id.mondayrec);
        tuesdayrecy=findViewById(R.id.tuesdayrecy);
        wednesdayrecy=findViewById(R.id.wednsdayrecy);
        thursdayrecy=findViewById(R.id.thursdayrecy);
        fridayrecy=findViewById(R.id.fridayrecy);
        saturdayrecy=findViewById(R.id.saturdayrecy);
        sundayrecy=findViewById(R.id.saundayrecy);

        noplanlayout=findViewById(R.id.noplanlauout);

        nestedScrollView=findViewById(R.id.scrollview);

        btnaddplan=findViewById(R.id.btnaddpln);



    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }
}