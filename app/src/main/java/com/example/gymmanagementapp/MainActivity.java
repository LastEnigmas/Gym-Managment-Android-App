package com.example.gymmanagementapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.bumptech.glide.util.Util;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Button btnalltrainings;
    private Button btnabout;
    private Button btnseeplan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initviews();
        utils.initTrainings();
        btnseeplan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,PlanActivity.class);
                startActivity(intent);

            }
        });

        btnalltrainings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,AllTrainingactivity.class);
                startActivity(intent);

            }
        });

        btnabout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this)
                        .setMessage("Created by Aria Taghizade")
                        .setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        }).setPositiveButton("Visit", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent=new Intent(MainActivity.this,webviewactivity.class);
                                startActivity(intent);

                            }
                        });
                builder.create().show();
            }
        });

    }
    private void initviews(){
        Log.d(TAG,"Initviews started");
        btnalltrainings=findViewById(R.id.btnseealactivities);
        btnabout=findViewById(R.id.btnaboutus);
        btnseeplan=findViewById(R.id.btnseeplan);


    }
}