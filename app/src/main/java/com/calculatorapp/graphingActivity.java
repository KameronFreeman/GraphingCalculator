package com.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.ContactsContract;

import java.lang.reflect.Array;
import java.util.ArrayList;

import com.example.calculatorapp.R;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class graphingActivity extends AppCompatActivity {
    //private double m[] = GraphingCalcInputsActivity.m;
    //private double b[] = GraphingCalcInputsActivity.b;

    private ArrayList<Double> m = GraphingCalcInputsActivity.m;
    private ArrayList<Double> b = GraphingCalcInputsActivity.b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphing);


        GraphView graph = (GraphView) findViewById(R.id.graph);
        ArrayList<LineGraphSeries<DataPoint>> dataset = new ArrayList<>();
        ////LineGraphSeries<DataPoint> dataset2 = new LineGraphSeries<>();
        LineGraphSeries<DataPoint> dataset3 = new LineGraphSeries<>();
        //LineGraphSeries<DataPoint> dataset4 = new LineGraphSeries<>();

        double y;

        for (int i =0; i< m.size(); i++) {
            LineGraphSeries<DataPoint> dataset1 = new LineGraphSeries<>();
            for (int x = -90; x < 90; x++) {
                //y = (m[i] * x) + b[i];
                y = (m.get(i) * x) + b.get(i);
                dataset1.appendData(new DataPoint(x,y),true,180);
            }
            dataset.add(dataset1);
        }

        // if linear equation
        /*for (int x = -90; x <90; x++){
            y = (m[0] * x) + b[0];
            dataset.appendData(new DataPoint(x,y),true,180);
        }

        for (int x = -90; x <90; x++){
            y = (m[1] * x) + b[1];
            dataset2.appendData(new DataPoint(x,y),true,180);
        }

        for (int x = -90; x <90; x++){
            y = (m[2] * x) + b[2];
            dataset3.appendData(new DataPoint(x,y),true,180);
        }

        for (int x = -90; x <90; x++){
            y = (m[3] * x) + b[3];
            dataset4.appendData(new DataPoint(x,y),true,180);
        }

        graph.addSeries(dataset);
        graph.addSeries(dataset2);
        graph.addSeries(dataset3);
        graph.addSeries(dataset4);

         */

        for (int i =0; i < dataset.size(); i++){
            graph.addSeries(dataset.get(i));
            dataset.get(i).setTitle("Equation " + (i+1) );
            dataset.get(i).setThickness(8);
        }

        //dataset.get(0).setColor(Color.RED);
        //dataset.get(1).setColor(Color.BLUE);
        //dataset.get(2).setColor(Color.BLACK);
        //dataset.get(3).setColor(Color.YELLOW);

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

        //dataset.setColor(Color.RED);
        //dataset.setTitle("Data Set");
        //dataset.setDrawDataPoints(true);
        //dataset.setDataPointsRadius(16);
        //dataset.setThickness(8);
        //dataset2.setColor(Color.BLUE);
        //dataset3.setColor(Color.BLACK);
        //dataset4.setColor(Color.YELLOW);

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

    @Override
    public void onBackPressed(){
        m.clear();
        b.clear();
        Intent intent = new Intent(this, GraphingCalcInputsActivity.class);
        startActivity(intent);
        finish();
    }

}