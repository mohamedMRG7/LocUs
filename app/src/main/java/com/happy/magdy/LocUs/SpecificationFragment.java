package com.happy.magdy.LocUs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class SpecificationFragment extends Fragment {
    private View rootView;

    List<String> noOfPeople = new ArrayList<String>();                                                  // No of People
    List<String> locationsList = new ArrayList<String>();                                               // Locations

    SpinnerCustomAdapter locationSpinnerAdapter;
    SpinnerCustomAdapter peopleNumberAdapter;

    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();                    // Realtime Database Root
    DatabaseReference mLocationRef = mRootRef.child("location");                                   // Realtime Database Locations Node
    // Use them with Firebase UI
    //Firebase mRootRef = new Firebase("https://locus-dbfff.firebaseio.com/");
    //Firebase mLocationRef =  mRootRef.child("location");
    public SpecificationFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_specification, container, false);
        final Spinner locationSpinner = (Spinner) rootView.findViewById(R.id.location_spinner);
        Spinner peopleNumberSpinner = (Spinner) rootView.findViewById(R.id.people_number_spinner);
        Button confirmBtn = (Button) rootView.findViewById(R.id.confirm_btn);

        // Add hint to noOfPeople Spinner
        noOfPeople.add("Number of People ");
        // Fill noOfPeople ArrayList
        for(int i = 10; i <= 1000; i*=1){
            noOfPeople.add(Integer.toString(i));
            if(i < 70)
                i += 20;
            else if(i < 100)
                i += 30;
            else if(i < 300)
                i += 50;
            else if(i < 500)
                i += 100;
            else
                i += 250;
        }
        // Create Spinners Adapters
        locationSpinnerAdapter = new SpinnerCustomAdapter(
                getActivity()
                , R.layout.spinner_item_locations
                , R.id.spinner_item_locations_textview
                , locationsList );
        locationSpinnerAdapter.add("Location");                                     // Add hint to Location Spinner
        peopleNumberAdapter = new SpinnerCustomAdapter(
                getActivity()
                , R.layout.spinner_item_number
                , R.id.spinner_item_number_textview
                , noOfPeople );

        mLocationRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String SelectedLoc = dataSnapshot.getKey();
                DatabaseReference mSelectedLocRef = mLocationRef.child(SelectedLoc);
                firebaseChildListener(mSelectedLocRef, "region");
                Log.v("LOCATION_CHILD-ADDED", SelectedLoc);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                String SelectedLoc = dataSnapshot.getKey();
                DatabaseReference mSelectedLocRef = mLocationRef.child(SelectedLoc);
                firebaseChildListener(mSelectedLocRef, "region");
                Log.v("LOCATION_CHILD-CHANGED", SelectedLoc);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                String SelectedLoc = dataSnapshot.getKey();
                DatabaseReference mSelectedLocRef = mLocationRef.child(SelectedLoc);
                firebaseChildListener(mSelectedLocRef, "region");
                Log.v("LOCATION_CHILD-REMOVED", SelectedLoc);
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                // IGNORE
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        // Set Spinners' Adapters
        // Set Location Adapter
        locationSpinnerAdapter.setDropDownViewResource(R.layout.spinner_item_locations);
        locationSpinner.setAdapter(locationSpinnerAdapter);
        peopleNumberAdapter.setDropDownViewResource(R.layout.spinner_item_number);
        peopleNumberSpinner.setAdapter(peopleNumberAdapter);
        // No of People Spinner Click Listener
        peopleNumberSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position > 0)
                    Toast.makeText(getActivity(), (String)peopleNumberAdapter.getItem(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        // Confirm btn Click Listener
        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Confirm", Toast.LENGTH_SHORT).show();
                // Write a message to the database
                Intent i= new Intent(getActivity(),Recycle.class);
                startActivity(i);
                /*FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("message");

                myRef.setValue("Hello, World!");*/
            }
        });
        return rootView;

    }
    // Get required value from Realtime DataBase
    void firebaseChildListener(DatabaseReference mRef, final String requiredKey){

        mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String key = dataSnapshot.getKey();
                if(key.equals(requiredKey))
                    locationSpinnerAdapter.add(dataSnapshot.getValue(String.class));
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                String key = dataSnapshot.getKey();
                if(key.equals(requiredKey))
                    locationSpinnerAdapter.add(dataSnapshot.getValue(String.class));
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                String key = dataSnapshot.getKey();
                if(key.equals(requiredKey))
                    locationSpinnerAdapter.add(dataSnapshot.getValue(String.class));
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                // IGNORE
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
