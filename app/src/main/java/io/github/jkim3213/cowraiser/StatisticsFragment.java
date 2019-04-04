package io.github.jkim3213.cowraiser;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

public class StatisticsFragment extends Fragment {


    private float rainFall[] = {98.2f, 123.4f, 161.1f, 24.2f, 52f, 13.8f, 20};
    private String dayName[] = {"Mon", "Tues", "Wend", "Thurs", "Fri", "Sat", "Sun"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_statistics, null);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupPieChart(view);
    }
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
        chart.animateY(1000);
        chart.invalidate();
    }


}
