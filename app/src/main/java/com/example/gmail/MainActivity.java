package com.example.gmail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.gmail.fragments.InicioFragment;
import com.example.gmail.interfaces.ComunicarFragments;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity implements ComunicarFragments {

    Fragment fragmentInicio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentInicio=new InicioFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedorFragments,fragmentInicio).commit();

    }

    @Override
    public void abrirGmail() {
        //Toast.makeText(getApplicationContext(), "Abrir Gmail", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent (this, Gmail.class);
        startActivityForResult(intent, 0);
    }

    @Override
    public void abrirWinzip() {
        //Toast.makeText(getApplicationContext(), "Abrir Winzip", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent (this, Winzip.class);
        startActivityForResult(intent, 0);
    }

    @Override
    public void abrirDrive() {
        //Toast.makeText(getApplicationContext(), "Abrir Drive", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent (this, Drive.class);
        startActivityForResult(intent, 0);
    }


}