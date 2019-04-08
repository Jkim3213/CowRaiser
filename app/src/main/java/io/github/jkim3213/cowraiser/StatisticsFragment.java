package io.github.jkim3213.cowraiser;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import com.github.mikephil.charting.charts.PieChart;

import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class StatisticsFragment extends Fragment {

    private FirebaseDatabase mFirebasedatabase;
    private  DatabaseReference myRef;
    private DatabaseReference rootRef;
    private FirebaseAuth mAuth;
    private  FirebaseAuth.AuthStateListener mAuthListener;
    //float totalCarbonLb;
    private String userId;


    private float rainFall[] = {10.0f, 10.0f, 10.0f, 10.0f, 1.0f, 10.0f, 10.0f};
    private String dayName[] = {"Mon", "Tues", "Wed", "Thurs", "Fri", "Sat", "Sun"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_statistics, null);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupPieChart(view);

        mAuth = FirebaseAuth.getInstance();
        mFirebasedatabase = mFirebasedatabase.getInstance();
        myRef = mFirebasedatabase.getReference();
        FirebaseUser user = mAuth.getCurrentUser();
        userId = user.getUid();

        Log.d("Oncreatetestlog", "onCreate() Restoring previous state");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                showData(dataSnapshot);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void showData(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds: dataSnapshot.getChildren()) {

            UserProfile u = new UserProfile();
            u.setCarbonLbs(ds.child(userId).getValue(UserProfile.class).getCarbonLbs());
            Log.d("car", "carbonlbsdisplayed " +  u.getCarbonLbs());
            Log.d("myTag", "This is my message");

        }
    }

    int total = UserProfile.carbonLbs;
    String totalCarbon = Integer.toString(total);


    private void setupPieChart(View view) {

        List<PieEntry> pieEntries = new ArrayList<>();
        for(int i =0; i < rainFall.length; i++) {
            pieEntries.add(new PieEntry(rainFall[i], dayName[i]));

        }


        PieDataSet dataSet = new PieDataSet(pieEntries, "Carbon Pounds Saved");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        PieData pieData = new PieData(dataSet);

        //chart
        PieChart chart = (PieChart) view.findViewById(R.id.pieChart);
        chart.setData(pieData);
        chart.setCenterText("Total Carbon saved" + "\n" + totalCarbon + "lbs" );
        chart.setCenterTextSize(18f);
        //chart.setCenterTextColor(Color.);
        chart.animateY(1000);
        chart.invalidate();
    }
//
//    public void readfromDB(){
//        rootRef = FirebaseDatabase.getInstance().getReference();
//        DatabaseReference tripsRef = rootRef.child("Users");
//        ValueEventListener valueEventListener = new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                List<String> list = new ArrayList<>();
//                for (DataSnapshot ds : dataSnapshot.getChildren()) {
//
////                UserProfile u = new UserProfile();
////
////                u.setCarbonLbs(ds.child(userId).getValue(UserProfile.class).getCarbonLbs());
//
//                int totalCarbonLb = ds.child(userId).getValue(UserProfile.class).getCarbonLbs();
//                //int totalEcoDollar = ds.child("Ecodollar").getValue(int.class);
//                //ArrayList<JournalEntry> entryList = (ArrayList<JournalEntry>) ds.child("list").getValue();
//                //String departure = ds.child("Departure").getValue(String.class);
//                //String time = ds.child("Time").getValue(String.class);
//                //Log.d("TAG", arrival + " / " + departure  + " / " + time);
//                //list.add(time);
//
//                //Log.d("TAG","valuesCar" + u.getCarbonLbs());
//                //Log.d("TAG","valueseco" +entryList);
//                //Log.d(tag: "TAG")
//                }
//                //Log.d("TAG", time);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                databaseError.toException();
//            }
//        };
//        //tripsRef.addListenerForSingleValueEvent(valueEventListener);
//    }



}
