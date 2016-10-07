package com.androidsrc.client;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

public class DatosEnBloques extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_en_bloques);


        ListManager.listaBloques.agregarInicio("123",null,10);
        ListManager.listaBloques.agregarFinal("456",null,50);/*
        ListManager.listaBloques.agregarInicio("789","ya me jodi",100);*/

        ArrayList<String> labels = new ArrayList<String>();
        ArrayList<BarEntry> entries = new ArrayList<BarEntry>();
        int contador = 0;
        MemoryBlock nodo = ListManager.listaBloques.inicio;
        while (nodo != null){
            System.out.println("entro");
            labels.add(String.valueOf(nodo.idEspacio));
            entries.add(new BarEntry((int) nodo.size*1f,contador));
            nodo = nodo.siguiente;
            contador = contador+1;
        }
        BarDataSet dataset = new BarDataSet(entries, "# of ID");
        BarChart chart = new BarChart(this);
        setContentView(chart);


        BarData data = new BarData(labels, dataset);
        chart.setData(data);

        chart.setDescription("space of memory");


    }
}
