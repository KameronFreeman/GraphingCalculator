package com.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.example.calculatorapp.R;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class graphingActivity extends AppCompatActivity {
    private double m = GraphingCalcInputsActivity.m;
    private double b = GraphingCalcInputsActivity.b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphing);


        GraphView graph = (GraphView) findViewById(R.id.graph);
        LineGraphSeries<DataPoint> dataset = new LineGraphSeries<>();


        double y;

        // if linear equation
        for (int x = -90; x <90; x++){
            y = (m * x) + b;
            dataset.appendData(new DataPoint(x,y),true,180);
        }
        graph.addSeries(dataset);

        graph.getViewport().setMinX(-10);
        graph.getViewport().setMaxX(10);
        graph.getViewport().setMinY(-10);
        graph.getViewport().setMaxY(10);

        //graph.getViewport().setYAxisBoundsManual(true);
       // graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setScalable(true);
        graph.getViewport().setScalableY(true);


        /*for (int x = 0; x < 90; x++) {
            y = Math.sin(2 * x * .2) - 2 * Math.sin(x * .2);
            dataset.appendData(new DataPoint(x, y), true, 90);
        }
        graph.addSeries(dataset); */

        //set color, title of curve, DataPoints Radius, thickness

        dataset.setColor(Color.RED);
        dataset.setTitle("Data Set");
        //dataset.setDrawDataPoints(true);
        //dataset.setDataPointsRadius(16);
        dataset.setThickness(8);

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
}