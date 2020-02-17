package com.ark.final_integration;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;
import com.ark.final_integration.R;



public class graphics extends AppCompatActivity {
    PieChartView pieChartView;
     DatabaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphics);
        //graphics code goes here

       // Toast.makeText(graphics.this,"In graphis!",Toast.LENGTH_LONG).show();

        // to use user inout values--> use below
         Cursor result = myDB.getAllData();
           int x =  Integer.parseInt(result.getString(1));       //total
             int y =  Integer.parseInt(result.getString(2));            //grocery
               int z =  Integer.parseInt(result.getString(3));                   //travel
                 int a =  Integer.parseInt(result.getString(4));                         //party
                   int b =  Integer.parseInt(result.getString(5));                              //misc

       
       


        pieChartView = findViewById(R.id.chart);

        List pieMoney = new ArrayList<>();
        pieMoney.add(new SliceValue(15, Color.BLUE).setLabel("Spent: €150"));
        pieMoney.add(new SliceValue(25, Color.GRAY).setLabel("Budget€: €250"));

        PieChartData pieChartData = new PieChartData(pieMoney );
        pieChartData.setHasLabels(true).setValueLabelTextSize(14);
        pieChartData.setHasCenterCircle(true).setCenterText1("Expenditure").setCenterText1FontSize(22).setCenterText1Color(Color.parseColor("#FC0303"));
        pieChartData.setHasLabelsOutside(true);
        pieChartView.setPieChartData(pieChartData);
    }
}
