package com.cap.seattlegetready;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import java.util.ArrayList;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    Spinner spinner;

    ArrayList<String> CountryName;
    String banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);

        //  GET TODAY...
        LocalDateTime todays = LocalDateTime.now();
        LocalDateTime yesterdays = LocalDateTime.now().minusDays(1);
        // Build formatter
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        // Format LocalDateTime
        String formattedDateTimeT = todays.format(formatter);
        String formattedDateTimeY = yesterdays.format(formatter);
        String subtodays= formattedDateTimeT.substring(0,10);
        String subyesterdays= formattedDateTimeY.substring(0,10);
        // Join it
        String URL = "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=" + subyesterdays + "&endtime=" + subtodays;

        CountryName = new ArrayList<>();

        loadSpinnerData(URL);


        Button whatButton = (Button) findViewById(R.id.whatBtn);
        whatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, WhatActivity.class));
            }
        });

        Button howButton = (Button) findViewById(R.id.howBtn);
        howButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, HowActivity.class));
            }
        });

        Button whereButton = (Button) findViewById(R.id.whereBtn);
        whereButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, WhereActivity.class));
            }
        });


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Seattle Emergency Email", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    // INFO OFR THE MARQUEE here...

    private void loadSpinnerData(String url) {

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);

                    JSONArray jsonArraytttt = jsonObject.getJSONArray("features");

                    for (int itttt = 0; itttt < jsonArraytttt.length(); itttt++) {

                        JSONObject jsonObject1tttt = jsonArraytttt.getJSONObject(itttt);

                        JSONObject jsonObject12tttt = jsonObject1tttt.getJSONObject("properties");

                        String countrytttt = jsonObject12tttt.getString("place");
                        String magnitud = jsonObject12tttt.getString("mag");
                        String info = "Place: " + countrytttt + ", Magnitude: " + magnitud + "   *";

                        banner += info + "*** ";

                        CountryName.add(banner);
                 }

                    //marquee
                    TextView txt = findViewById(R.id.marquees);
                    String mssss;
                    mssss = "Here is where I am going to try to post latest earthquake activity";
                    mssss = banner;

                    txt.setText(mssss);
                    txt.setSelected(true);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        int socketTimeout = 30000;
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(policy);
        requestQueue.add(stringRequest);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    // TIME...
    public class CurrentDateTimeExample1 {
        public void main(String[] args) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
           //  System.out.println(dtf.format(now));
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_what) {

        } else if (id == R.id.nav_how) {

        } else if (id == R.id.nav_where) {

        } else if (id == R.id.nav_contact) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
