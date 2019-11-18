package com.cap.seattlegetready;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import android.util.Log;
import android.view.View;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import com.google.android.material.navigation.NavigationView;
import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

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


        // Get current date time
        LocalDateTime todays = LocalDateTime.now();
        //  LocalDate yesterday = LocalDate.now().plusDays(1);
        LocalDateTime yesterdays = LocalDateTime.now().minusDays(1);
        //Build formatter
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        //Format LocalDateTime
        String formattedDateTimeT = todays.format(formatter);
        String formattedDateTimeY = yesterdays.format(formatter);
        String subtodays= formattedDateTimeT.substring(0,10);
        String subyesterdays= formattedDateTimeY.substring(0,10);



        Log.wtf("myTag", "0000000000000000000000000000000000000000");
        Log.wtf("myTag", "000000000000000000000000000000000000" + subtodays);
        Log.wtf("myTag", "0000000000000000000000000000000000000000");
        Log.wtf("myTag", "000000000000000000000000000000000000" + subyesterdays);

      //  String URL2 = "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=";

    //    https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=2019-10-14&endtime=2019-10-15&minmagnitude=5

  //     String URL = "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=" + subyesterdays + "&endtime=" + subtodays + "&minmagnitude=4";

        String URL = "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=" + subyesterdays + "&endtime=" + subtodays + "&minmagnitude=5";

   //     String URL = "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=2019-11-10&endtime=2019-11-11";

        Log.wtf("myTag", "0000000000000000000000000000000000000000");
        Log.wtf("myTag", "000000000000000000000000000000000000" + URL);

  //      https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=2019-11-10&endtime=2019-11-11&minmagnitude=5


        CountryName = new ArrayList<>();
    //    spinner = (Spinner) findViewById(R.id.country_Name);

        Log.wtf("myTag", "11AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        Log.wtf("myTag", "ASAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");

        loadSpinnerData(URL);

        Log.wtf("myTag", "1BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
        Log.wtf("myTag", "8BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");



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

    // INFO OFR THE MARQUEE...

    private void loadSpinnerData(String url) {

        Log.wtf("myTag", "00000");
        Log.wtf("myTag", "000000000000");
        Log.wtf("myTag", "00000000000000000000");
        Log.wtf("myTag", "0000000000000000000000000000");
        Log.wtf("myTag", "000000000000000000000000000000000000" + url);


        Log.wtf("myTag", "1CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC");
        Log.wtf("myTag", "CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC");

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

        Log.wtf("myTag", "1CDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");
        Log.wtf("myTag", "CDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);

                    Log.wtf("myTag", "1CCEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
                    Log.wtf("myTag", "CEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE" + jsonObject);

                    JSONArray jsonArraytttt = jsonObject.getJSONArray("features");
                    Log.wtf("myTag", "1XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
                    Log.wtf("myTag", "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX" + jsonArraytttt);

                    for (int itttt = 0; itttt < jsonArraytttt.length(); itttt++) {

                        JSONObject jsonObject1tttt = jsonArraytttt.getJSONObject(itttt);

                        JSONObject jsonObject12tttt = jsonObject1tttt.getJSONObject("properties");

                        String countrytttt = jsonObject12tttt.getString("place");
                        String magnitud = jsonObject12tttt.getString("mag");
                        String info = "Place: " + countrytttt + ", Magnitude: " + magnitud + "   *";

                        Log.wtf("myTag", "1YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY");
                        Log.wtf("myTag", "GYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY" + jsonObject1tttt);

                        Log.wtf("myTag", "1YYYYYYYYYYYYYYYYYYYY22222222222222222222222222222");
                        Log.wtf("myTag", "GYYYYYYYYYYYYYYYYYYYY22222222222222222222222222222" + jsonObject12tttt);

                        Log.wtf("myTag", "1HZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ");
                        Log.wtf("myTag", "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ" + countrytttt);

                        banner += info + "*** ";

                        Log.wtf("myTag", "1#####################################################");
                        Log.wtf("myTag", "18888888888888888888888888888888888888888888888888888");
                        Log.wtf("myTag", "##################################################" + banner);

                        CountryName.add(banner);
                 }

                    //marquee
                    TextView txt = findViewById(R.id.marquees);
                    String mssss;
                    mssss = "Here is where I am going to try to post latest earthquake activity";
                    mssss = banner;

                    Log.wtf("myTag", "1%%%%%%%%");
                    Log.wtf("myTag", "177777777777777777777777777777777777777777777777");
                    Log.wtf("myTag", "99999999999999999999999999999999999999999999999999999999" + banner);
                    Log.wtf("myTag", "17777777777777777777777777777777777777777777777777");
                    Log.wtf("myTag", "1%%%%%%%%%");


                    Log.wtf("myTag", "1%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                    Log.wtf("myTag", "1%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                    Log.wtf("myTag", "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" + banner);

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
        // Inflate...
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    // TIME...
    public class CurrentDateTimeExample1 {
        public void main(String[] args) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();

        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


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
