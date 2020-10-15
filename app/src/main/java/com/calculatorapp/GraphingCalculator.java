package com.calculatorapp;

       // import javax.swing.*;
        import android.graphics.Color;

        import java.util.*;
        //import java.awt.*;
        import org.jfree.*;
        import org.jfree.chart.ChartFactory;
        import org.jfree.chart.ChartPanel;
        import org.jfree.chart.JFreeChart;
        import org.jfree.chart.axis.NumberAxis;
        import org.jfree.chart.plot.CategoryPlot;
        import org.jfree.chart.plot.PlotOrientation;
        import org.jfree.data.xy.XYDataset;
        import org.jfree.ui.ApplicationFrame;

        import java.util.ArrayList;





public class GraphingCalculator {

    XYDataset dataset;
    JFreeChart chart = ChartFactory.createXYLineChart(
            "Graphing Calculator",
            "X-Axis",
            "Y-Axis",
            dataset,
            PlotOrientation.VERTICAL,
            true, true, false
    );

    ChartPanel panel = new ChartPanel(chart);


}
