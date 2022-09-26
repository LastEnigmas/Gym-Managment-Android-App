package com.example.gymmanagementapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.util.Util;

public class TrainingActivity extends AppCompatActivity implements plandetaildialog.passPlaninterface {
    private static final String TAG = "TrainingActivity";

    public static final String Training_key="training";
    private Button btnaddtoplan;
    private TextView longdescription,trainingname;
    private ImageView trainingimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);
        initviews();
        Intent intent=getIntent();
        if(intent!=null){
            Training training=intent.getParcelableExtra(Training_key);
            if(null!= training){
                trainingname.setText(training.getName());
                longdescription.setText(training.getLongdesc());
                Glide.with(this).asBitmap().load(training.getImageurl()).into(trainingimg);
                btnaddtoplan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        plandetaildialog dialog=new plandetaildialog();
                        Bundle bundle=new Bundle();
                        bundle.putParcelable(Training_key,training);
                        dialog.setArguments(bundle);
                        dialog.show(getSupportFragmentManager(),"plan detail dialog");
                    }
                });
            }

        }
    }

    private void initviews() {
        btnaddtoplan=findViewById(R.id.btnaddtoplan);
        longdescription=findViewById(R.id.longdesc);
        trainingimg=findViewById(R.id.trainingimage);
        trainingname=findViewById(R.id.txttrainingname);
    }

    @Override
    public void getPlan(Plan plan) {
        Log.d(TAG,"plan: "+plan.toString());
        if (utils.addplan(plan)) {
            Toast.makeText(this,plan.getTraining().getName()+" added to your plan",Toast.LENGTH_SHORT).show();

            Intent intent=new Intent(this,PlanActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);

        }
    }
}