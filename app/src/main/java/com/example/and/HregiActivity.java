package com.example.and;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HregiActivity extends AppCompatActivity {

    TextView tvhname ,tvaname,tvhuname ,tvhpass,tvhpno,tvhadd,tvhmail,tvtitle;
    EditText ethname,etaname,ethuname ,ethpass,ethpno,ethadd,ethmail;
    Button btnsub;

    FirebaseDatabase database1;
    DatabaseReference ref1;
    Hospital hospital;


    @Override
    protected void onCreate(Bundle savedInstancesState) {
        super.onCreate(savedInstancesState);
        setContentView(R.layout.activity_hregi);

        tvhname = (TextView) findViewById(R.id.tvhname);
        tvtitle = (TextView) findViewById(R.id.tvtitle);
        tvaname = (TextView) findViewById(R.id.tvaname);
        tvhpass = (TextView) findViewById(R.id.tvhpass);
        tvhuname = (TextView) findViewById(R.id.tvhuname);
        tvhpno = (TextView) findViewById(R.id.tvhpno);
        tvhadd = (TextView) findViewById(R.id.tvhadd);
        tvhmail = (TextView) findViewById(R.id.tvhmail);

        ethname = (EditText) findViewById(R.id.ethname);
        etaname = (EditText) findViewById(R.id.etaname);
        ethpass = (EditText) findViewById(R.id.ethpass);
        ethuname = (EditText) findViewById(R.id.ethuname);
        ethpno = (EditText) findViewById(R.id.ethpno);
        ethadd = (EditText) findViewById(R.id.ethadd);
        ethmail = (EditText) findViewById(R.id.ethmail);


        btnsub = (Button) findViewById(R.id.btnsub);


        database1 = FirebaseDatabase.getInstance();
        ref1 = database1.getReference("Hospital");
        hospital = new Hospital();


        btnsub.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {
                                          if (ethname.length() == 0) {
                                              ethname.setError("hospital name is empty");
                                              ethname.requestFocus();
                                              return;
                                          }


                                          if (ethuname.length() == 0) {
                                              ethuname.setError("usename is empty");
                                              ethuname.requestFocus();
                                              return;
                                          }
                                          if (ethpass.length() == 0) {
                                              ethpass.setError("password is empty");
                                              ethpass.requestFocus();
                                              return;
                                          }

                                          if (ethname.length() == 0) {
                                              etaname.setError("admin name is empty");
                                              etaname.requestFocus();
                                              return;
                                          }
                                          if (ethmail.length() == 0) {
                                              ethmail.setError("mail is empty");
                                              ethmail.requestFocus();
                                              return;
                                          }

                                          if (ethpno.length() == 0) {
                                              ethpno.setError("phone no is empty");
                                              ethpno.requestFocus();
                                              return;
                                          }
                                          if (ethadd.length() == 0) {
                                              ethadd.setError("password is empty");
                                              ethadd.requestFocus();
                                              return;
                                          }


                                          ref1.addValueEventListener(new ValueEventListener() {
                                              @Override
                                              public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                   getValues();
                                                  ref1.child("hospital").setValue(hospital);
                                                  Toast.makeText(HregiActivity.this, "Data Inserted ..", Toast.LENGTH_LONG).show();
                                                  Intent i = new Intent(HregiActivity.this, MainActivity.class);
                                                  startActivity(i);

                                              }

                                              @Override
                                              public void onCancelled(@NonNull DatabaseError databaseError) {

                                              }

                                          });
                                      }

                                      // finish();




                                  }


        );

    }
    private void getValues() {
        hospital.setHname(ethname.getText().toString());
        hospital.setUname(ethuname.getText().toString());
        hospital.setPass(ethpass.getText().toString());
        hospital.setAname(etaname.getText().toString());
        hospital.setEmail(ethmail.getText().toString());
        hospital.setPhno(ethpno.getText().toString());
        hospital.setAdd(ethadd.getText().toString());
    }
}