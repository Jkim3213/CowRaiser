package io.github.jkim3213.cowraiser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class visualization extends AppCompatActivity {

    LineGraphSeries<DataPoint> series;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualization);

        double x,y;
        x = 0.0;

        GraphView graph = (GraphView) findViewById(R.id.graph);

        series = new LineGraphSeries<DataPoint>();
        // how to display the value overtime since we are adding them we donot have a way to show them
        // the past history overtime alway we are having one number which will be a straight line
        // we need to save based on time so we can have some value
        for(int i = 0; i < 500; i++) {

            x += 100;
            //y = Math.sin(x);
            //y = y +
            y = UserProfile.carbonLbs;
            series.appendData(new DataPoint(x,y), true, 500);
        }
        graph.addSeries(series);
    }

}
