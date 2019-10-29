package com.example.and;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.List;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;



   // String add;

   // Geocoder coder = new Geocoder(MapsActivity.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        Map();


    }

    private void Map(){
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    @Override
    public void onMapReady(final GoogleMap googleMap) {
        mMap = googleMap;

      /*  DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        ref.child("User").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                int size = (int) dataSnapshot.getChildrenCount(); //

                mMap.clear();

                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    //Specify your model class here

                    //lets create a loop



                    for(int i=0;i<=size;i++){

                        try {
                            add = ds.child("add").getValue().toString();
                            convertAddress(add);



                        }catch (Exception e){

                        }

                    }

                }

            }

            private void convertAddress(String add) {
                    if (add != null && !add.isEmpty()) {
                        try {

                            List<Address> address = coder.getFromLocationName(add, 1);
                            if (address != null && address.size() > 0) {
                                double lat = address.get(0).getLatitude();
                                double lng = address.get(0).getLongitude();
                                googleMap.addMarker(new MarkerOptions().position(new LatLng( lat, -lng)).title("Marker"));

                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        } // end catch
                    } // end if

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        DatabaseReference ref1 = FirebaseDatabase.getInstance().getReference();
        ref1.child("Hospital").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                int size = (int) dataSnapshot.getChildrenCount(); //
                mMap.clear();

                for(DataSnapshot ds: dataSnapshot.getChildren()) {
                    //Specify your model class here


                    //lets create a loop



                    for(int i=0;i<=size;i++){

                        try {
                            add = ds.getValue().toString();
                            convertAddress(add);


                        }catch (Exception e){

                        }

                    }


                }

            }

            private void convertAddress(String add) {
                if (add != null && !add.isEmpty()) {
                    try {

                        List<Address> address = coder.getFromLocationName(add, 1);
                        if (address != null && address.size() > 0) {
                            double lat = address.get(0).getLatitude();
                            double lng = address.get(0).getLongitude();
                            googleMap.addMarker(new MarkerOptions().position(new LatLng( lat, -lng)).title("Marker"));


                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } // end catch


                } // end if

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });






*/
    }
}
