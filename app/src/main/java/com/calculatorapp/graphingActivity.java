package com.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

import com.example.calculatorapp.R;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.DataPointInterface;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.OnDataPointTapListener;
import com.jjoe64.graphview.series.Series;

public class graphingActivity extends AppCompatActivity {
    private ArrayList<Double> m = GraphingCalcInputsActivity.m;
    private ArrayList<Double> b = GraphingCalcInputsActivity.b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphing);


        GraphView graph = (GraphView) findViewById(R.id.graph);
        ArrayList<LineGraphSeries<DataPoint>> dataset = new ArrayList<>();


        double y;

        // creates datasets and adds them to dataset arraylist
        for (int i =0; i< m.size(); i++) {
            LineGraphSeries<DataPoint> dataset1 = new LineGraphSeries<>();
            for (int x = -90; x < 90; x++) {
                y = (m.get(i) * x) + b.get(i);
                dataset1.appendData(new DataPoint(x,y),true,180);
            }
            dataset.add(dataset1);
        }

        // array to hold colors
        int[] color = {Color.RED, Color.BLACK, Color.BLUE, Color.YELLOW, Color.GREEN, Color.CYAN};
        int c = 0;

        // loop to display equations on graph
        for (int i =0; i < dataset.size(); i++){
            graph.addSeries(dataset.get(i));
            dataset.get(i).setTitle("Equation " + (i+1) );
            dataset.get(i).setThickness(8);
            if (c > color.length - 1){
                c=0;
            }
            dataset.get(i).setColor(color[c]);
            c++;
            dataset.get(i).setOnDataPointTapListener(new OnDataPointTapListener() {
                @Override
                public void onTap(Series series, DataPointInterface dataPoint) {
                    String msg = "X: "+ dataPoint.getX() + "\nY: " + dataPoint.getY();
                    Toast.makeText(graphingActivity.this,msg,Toast.LENGTH_LONG).show();
                }
            });


        }


        graph.getViewport().setMinX(-10);
        graph.getViewport().setMaxX(10);
        graph.getViewport().setMinY(-10);
        graph.getViewport().setMaxY(10);

        //allows zooming
        graph.getViewport().setScalable(true);
        graph.getViewport().setScalableY(true);


        //set Title of graph
        graph.setTitle("Graph");
        graph.setTitleTextSize(90);
        graph.setTitleColor(Color.BLUE);

        // legend
        graph.getLegendRenderer().setVisible(true);
        graph.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);

        // axis titles
        GridLabelRenderer gridLabel = graph.getGridLabelRenderer();
        gridLabel.setHorizontalAxisTitle("X Axis Title");
        gridLabel.setHorizontalAxisTitleTextSize(50);
        gridLabel.setVerticalAxisTitle("Y Axis Title");
        gridLabel.setVerticalAxisTitleTextSize(50);

    }

    // restart equations if back button clicked
    @Override
    public void onBackPressed(){
        m.clear();
        b.clear();
        Intent intent = new Intent(this, GraphingCalcInputsActivity.class);
        startActivity(intent);
        finish();
    }



}