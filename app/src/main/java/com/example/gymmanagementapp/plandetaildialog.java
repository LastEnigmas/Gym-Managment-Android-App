package com.example.gymmanagementapp;

import static com.example.gymmanagementapp.TrainingActivity.Training_key;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class plandetaildialog extends DialogFragment {
    public interface passPlaninterface{
        void getPlan(Plan plan);
    }

    private passPlaninterface passplaninterface;
    private Button btndismiss,btnadd;
    private TextView txtName;
    private Spinner spinnerday;
    private EditText edttxtmins;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view=getActivity().getLayoutInflater().inflate(R.layout.plan_details,null);
        inintview(view);

        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity()).setView(view).setTitle("Enter Details");
        Bundle bundle=getArguments();
        if(null!=bundle){
            Training training=bundle.getParcelable(Training_key);
            if(training!=null){
                txtName.setText(training.getName());
                btndismiss.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dismiss();
                    }
                });
                btnadd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String day=spinnerday.getSelectedItem().toString();
                        int mins=Integer.valueOf(edttxtmins.getText().toString());
                        Plan plan= new Plan(training,mins,day,false);

                        try {
                            passplaninterface= (passPlaninterface) getActivity();
                            passplaninterface.getPlan(plan);
                            dismiss();

                        }catch (ClassCastException e){
                            e.printStackTrace();
                            dismiss();

                        }



                    }
                });

            }
        }

        return builder.create();
    }

    private void inintview(View v) {
        btndismiss=v.findViewById(R.id.dismissbtn);
        btnadd=v.findViewById(R.id.btnadd);
        txtName=v.findViewById(R.id.txtname);
        spinnerday=v.findViewById(R.id.spinner);
        edttxtmins=v.findViewById(R.id.minutesoftraining);



    }
}
