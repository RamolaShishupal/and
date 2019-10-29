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

public class AregiActivity extends AppCompatActivity {
    EditText etdname, etduname, etdpass, etdage, etdbg, etdpno, etdadd, etdmail;
    TextView tvdname, tvduname, tvdpass, tvdage, tvdbg, tvdpno, tvdadd, tvdmail, tvtitle;
    Button btnsub;
    FirebaseDatabase database;
    DatabaseReference ref;
    Donor donor;


    @Override
    protected void onCreate(Bundle savedInstancesState) {
        super.onCreate(savedInstancesState);
        setContentView(R.layout.activity_aregi);

    etdname = (EditText) findViewById(R.id.etdname);
    etduname = (EditText) findViewById(R.id.etduname);
    etdpass = (EditText) findViewById(R.id.etdpass);
    etdage = (EditText) findViewById(R.id.etdage);
    etdbg = (EditText) findViewById(R.id.etdbg);
    etdpno = (EditText) findViewById(R.id.etdpno);
    etdadd = (EditText) findViewById(R.id.etdadd);
    etdmail = (EditText) findViewById(R.id.etdmail);

    tvdname = (TextView) findViewById(R.id.tvdname);
    tvtitle = (TextView) findViewById(R.id.tvtitle);
    tvduname = (TextView) findViewById(R.id.tvduname);
    tvdpass = (TextView) findViewById(R.id.tvdpass);
    tvdage = (TextView) findViewById(R.id.tvdage);
    tvdbg = (TextView) findViewById(R.id.tvdbg);
    tvdpno = (TextView) findViewById(R.id.tvdpno);
    tvdadd = (TextView) findViewById(R.id.tvdadd);
    tvdmail = (TextView) findViewById(R.id.tvdmail);
    btnsub = (Button) findViewById(R.id.btnsub);
    database =FirebaseDatabase.getInstance();
    ref=database.getReference("User");
    donor=new Donor();
        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etdname.length() == 0) {
                    etdname.setError("name is empty");
                    etdname.requestFocus();
                    return;
                }


                if (etduname.length() == 0) {
                    etduname.setError("usename is empty");
                    etduname.requestFocus();
                    return;
                }
                if (etdpass.length() == 0) {
                    etdpass.setError("password is empty");
                    etdpass.requestFocus();
                    return;
                }

                if (etdage.length() == 0) {
                    etdage.setError("age is empty");
                    etdage.requestFocus();
                    return;
                }
                if (etdmail.length() == 0) {
                    etdmail.setError("mail is empty");
                    etdmail.requestFocus();
                    return;
                }
                if (etdbg.length() == 0) {
                    etdbg.setError("blood group is empty");
                    etdbg.requestFocus();
                    return;
                }
                if (etdpno.length() == 0) {
                    etdpno.setError("phone no is empty");
                    etdpno.requestFocus();
                    return;
                }
                if (etdadd.length() == 0) {
                    etdadd.setError("password is empty");
                    etdadd.requestFocus();
                    return;
                }



                    ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            getValues();
                            ref.child("user").setValue(donor);
                            Toast.makeText(AregiActivity.this,"Data Inserted ..",Toast.LENGTH_LONG).show();
                            Intent i = new Intent(AregiActivity.this, MainActivity.class);
                            startActivity(i);


                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });





            }
        });


    }
private void getValues()
    {
        donor.setDname(etdname.getText().toString());
        donor.setUname(etduname.getText().toString());
        donor.setPass(etdpass.getText().toString());
        donor.setAge(etdage.getText().toString());
        donor.setBg(etdbg.getText().toString());
        donor.setPhno(etdpno.getText().toString());
        donor.setAdd(etdadd.getText().toString());
        donor.setEmail(etdmail.getText().toString());


    }



}
