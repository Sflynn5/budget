package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

public class MainActivity extends AppCompatActivity {

    PieChartView pieChartView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pieChartView = findViewById(R.id.chart);

        List pieMoney = new ArrayList<>();
        pieMoney .add(new SliceValue(15, Color.BLUE).setLabel("Spent: €150"));
        pieMoney .add(new SliceValue(25, Color.GRAY).setLabel("Budget€: €250"));

        PieChartData pieChartData = new PieChartData(pieMoney );
        pieChartData.setHasLabels(true).setValueLabelTextSize(14);
        pieChartData.setHasCenterCircle(true).setCenterText1("Expenditure").setCenterText1FontSize(22).setCenterText1Color(Color.parseColor("#FC0303"));
        pieChartData.setHasLabelsOutside(true);
        pieChartView.setPieChartData(pieChartData);
    }

}