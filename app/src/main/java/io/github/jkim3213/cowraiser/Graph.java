package io.github.jkim3213.cowraiser;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.github.mikephil.charting.charts.PieChart;

import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class Graph extends AppCompatActivity{


    float rainFall[] = {98.2f, 123.4f, 161.1f, 24.2f, 52f, 13.8f, 20};
    String monthName[] = {"Mon", "Tues", "Wend", "Thurs", "Fri", "Sat", "Sun"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barchart);


        setupPieChart();

    }

    private void setupPieChart() {

        List<PieEntry> pieEntries = new ArrayList<>();
        for(int i =0; i < rainFall.length; i++) {
            pieEntries.add(new PieEntry(rainFall[i], monthName[i]));

        }
        PieDataSet dataSet = new PieDataSet(pieEntries, "Carbon Pounds Saved");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        PieData pieData = new PieData(dataSet);

        //chart
        PieChart chart = (PieChart) findViewById(R.id.pieChart);
        chart.setData(pieData);
        chart.animateY(1000);
        chart.invalidate();
    }

}







