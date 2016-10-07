package com.androidsrc.client;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class GEstadoDelNodo extends MainActivity {
    PieChart mChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestado_del_nodo);

        mChart = new PieChart(this);
        setContentView(mChart);

        mChart.setUsePercentValues(true);
        mChart.setDescription("graficos prueba");

        mChart.setDrawHoleEnabled(true);
        mChart.setHoleRadius(7);
        mChart.setTransparentCircleRadius(10);

        ArrayList<Entry> entries = new ArrayList<Entry>();
        ArrayList<String> labels= new ArrayList<String>();
        entries.add(new BarEntry(ListManager.getBytesTotales()-ListManager.getBytesDisponibles(),1));
        labels.add("Datos utilizados: "+ String.valueOf(ListManager.getBytesTotales()-ListManager.getBytesDisponibles()));
        entries.add(new BarEntry(ListManager.getBytesDisponibles(),2));
        labels.add("Datos libres:     "+String.valueOf(ListManager.getBytesDisponibles()));



        PieDataSet dataset = new PieDataSet(entries,"Numero de los nodos");
        dataset.setSliceSpace(3);
        dataset.setSelectionShift(5);

        ArrayList<Integer> colors = new ArrayList<Integer>();
        for(int Contador : ColorTemplate.VORDIPLOM_COLORS)
            colors.add(Contador);

        for(int Contador : ColorTemplate.JOYFUL_COLORS)
            colors.add(Contador);
        for(int Contador : ColorTemplate.COLORFUL_COLORS)
            colors.add(Contador);
        for(int Contador : ColorTemplate.LIBERTY_COLORS)
            colors.add(Contador);
        for(int Contador : ColorTemplate.PASTEL_COLORS)
            colors.add(Contador);
        colors.add(ColorTemplate.getHoloBlue());
        dataset.setColors(colors);


        PieData data = new PieData(labels,dataset);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.GRAY);

        mChart.setData(data);
        mChart.highlightValue(null);

        //Actualizar pie chart
        mChart.invalidate();

    }
}
