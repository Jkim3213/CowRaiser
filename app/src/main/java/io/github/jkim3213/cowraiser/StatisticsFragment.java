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
import java.util.Map;

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
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_statistics, null);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.view = view;
    }

    int total = UserProfile.carbonLbs;
    String totalCarbon = Integer.toString(total);

    @Override
    public void onResume() {
        super.onResume();
        setupPieChart(view);
    }

    private void setupPieChart(View view) {

        List<PieEntry> pieEntries = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : UserProfile.challengeOccurences.entrySet()){
            System.out.printf("Key : %s and Value: %s %n", entry.getKey(), entry.getValue());
            if(entry.getValue() > 0) {
                PieEntry p = new PieEntry(entry.getValue(), entry.getKey());
                pieEntries.add(p);
            }

        }//non mutable hashmap iteration

        //set dataset
        PieDataSet dataSet = new PieDataSet(pieEntries, "Carbon Pounds Saved");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        PieData pieData = new PieData(dataSet);

        //chart
        PieChart chart = (PieChart) view.findViewById(R.id.pieChart);
        chart.setData(pieData);
        chart.setCenterTextColor(Color.BLACK);
        chart.setEntryLabelColor(Color.BLACK);
        chart.setEntryLabelTextSize(16f);
        chart.setCenterText("Total Carbon saved" + "\n" + totalCarbon + "lbs" );
        chart.setCenterTextSize(18f);
        chart.animateY(1000);
        chart.invalidate();
    }

}
