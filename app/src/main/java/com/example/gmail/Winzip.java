package com.example.gmail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.gmail.adaptador.AdapterGmail;
import com.example.gmail.adaptador.AdapterWinzip;
import com.example.gmail.modelo.ModelWinzip;

import java.util.ArrayList;

public class Winzip extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winzip);
        recyclerView = (RecyclerView) findViewById(R.id.myRecyclerViewWinzip);
        manager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        adapter = new AdapterWinzip(this,GetListItems());
        recyclerView.setAdapter(adapter);
    }
    private ArrayList<ModelWinzip> GetListItems() {
        final ArrayList<ModelWinzip> ListItems= new ArrayList<>();
        ListItems.add(new ModelWinzip("CloudDrive","Archivos: 0; carpetas:0"));
        ListItems.add(new ModelWinzip("Download","Archivos: 265; carpetas:0"));
        ListItems.add(new ModelWinzip("Bluetooth","Archivos: 66; carpetas:0"));
        ListItems.add(new ModelWinzip("Recordings","Archivos: 10; carpetas:0"));
        ListItems.add(new ModelWinzip("Video","Archivos: 4; carpetas:0"));
        ListItems.add(new ModelWinzip("Pictures","Archivos: 0; carpetas:6"));
        ListItems.add(new ModelWinzip("WhatsApp","Archivos: 0; carpetas:7"));
        ListItems.add(new ModelWinzip("Telegram","Archivos: 0; carpetas:4"));
        ListItems.add(new ModelWinzip("CamScanner","Archivos: 25; carpetas:3"));
        ListItems.add(new ModelWinzip("Photo Editor","Archivos: 3; carpetas:0"));
        ListItems.add(new ModelWinzip("Andorid","Archivos: 0; carpetas:4"));
        return ListItems;
    }
}