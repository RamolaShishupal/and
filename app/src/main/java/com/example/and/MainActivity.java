package com.example.and;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.maps.model.Marker;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity {
    TextView tvmsg ;
    EditText etmail;
    EditText etpass;
    Button btnlogin ,btnhregi,btnaregi;
    DatabaseReference ref ,ref1;



    String u,p,uf,pf;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tvmsg=(TextView)findViewById(R.id.tvmsg);
        etmail=(EditText)findViewById(R.id.etmail);
        etpass=(EditText)findViewById(R.id.etpass);
        btnlogin=(Button)findViewById(R.id.btnlogin);
        btnhregi=(Button)findViewById(R.id.btnhregi);
        btnaregi=(Button)findViewById(R.id.btnaregi);



        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 u = etmail.getText().toString();
                 Log.e("u",u);
                 p = etpass.getText().toString();
                 Log.e("p",p);


                if (u.isEmpty() && p.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Fields Empty!", Toast.LENGTH_SHORT).show();
                }
                else{
                    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
                    Log.e("ref",ref.toString());
                       ref.child("User").addValueEventListener(new ValueEventListener() {
                           @Override
                           public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                               for (DataSnapshot ds: dataSnapshot.getChildren()) {
                                         Log.e("ds",ds.toString());

                                       try {
                                           uf = ds.child("email").getValue().toString();
                                           Log.e("uf",uf);
                                           pf= ds.child("pass").getValue().toString();
                                           Log.e("pf",pf);




                                       }catch (Exception e){

                                       }

                                       if( u.equals(uf) && p.equals(pf) ){
                                           Log.e("equals",u);
                                           Intent in= new Intent(MainActivity.this,MapsActivity.class);
                                           startActivity(in);
                                       }
                                   }
                               }



                           @Override
                           public void onCancelled(@NonNull DatabaseError databaseError) {


                           }
                       });
                    DatabaseReference ref1 = FirebaseDatabase.getInstance().getReference();
                    ref1.child("Hospital").addValueEventListener(new ValueEventListener() {
                           @Override
                           public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                               for (DataSnapshot ps: dataSnapshot.getChildren()){


                                       try {
                                            uf = ps.child("email").getValue().toString();
                                            Log.e("uf",uf);
                                           pf = ps.child("pass").getValue().toString();




                                       }catch (Exception e){

                                       }
                                       if( u.equals(uf) && p.equals(pf) ){
                                           Log.e("equals",u);
                                           Toast.makeText(MainActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
                                           Intent in= new Intent(MainActivity.this,MapsActivity.class);
                                           startActivity(in);
                                       }
                                   }


                               }



                           @Override
                           public void onCancelled(@NonNull DatabaseError databaseError) {

                           }
                       });

                       /* if(u == && p == ){
                        Intent i= new Intent(MainActivity.this,MapsActivity.class);
                        startActivity(i);
                    }
*/
                }


            }
        });



        btnaregi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this,AregiActivity.class);
                startActivity(i);
                //finish();

            }
        }); btnhregi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this,HregiActivity.class);
                startActivity(i);
                //finish();

            }
        });


    }


}
