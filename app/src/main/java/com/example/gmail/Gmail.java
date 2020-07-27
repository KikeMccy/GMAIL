package com.example.gmail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.gmail.adaptador.AdapterActivity;
import com.example.gmail.modelo.ModelActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Gmail extends AppCompatActivity {
    private static final String URL = "https://api.androidhive.info/json/inbox.json";
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ModelActivity> modelActivityList;
    private ProgressBar progressBar;
    private RecyclerView.LayoutManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gmail);

        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        recyclerView = (RecyclerView)findViewById(R.id.myRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        modelActivityList = new ArrayList<>();

        loadData();


    }

    private void loadData() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        progressBar.setVisibility(View.GONE);

                        try {
                            //JSONObject jsonObject = new JSONObject(response);
                            JSONArray jsonArray = new JSONArray(response);

                            for(int i=0; i<jsonArray.length(); i++){

                                JSONObject o = jsonArray.getJSONObject(i);
                                ModelActivity modelActivity = new ModelActivity(
                                        /*o.getString("head").substring(0,1),
                                        o.getString("head"),
                                        o.getString("subject"),
                                        o.getString("description"),
                                        o.getString("date")*/
                                           o.getString("from").substring(0,1),
                                        o.getString("from"),
                                        o.getString("subject"),
                                        o.getString("message"),
                                        o.getString("timestamp")
                                );
                                modelActivityList.add(modelActivity);
                            }

                            adapter = new AdapterActivity(modelActivityList, getApplicationContext());
                            recyclerView.setAdapter(adapter);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    /*private ArrayList<ModelActivity> GetListItems() {
        final ArrayList<ModelActivity> ListItems = new ArrayList<>();
            ListItems.add(new ModelActivity("M", "HOLA", "HP","SI","FUNCIONA"));
        return ListItems;
    }*/


}