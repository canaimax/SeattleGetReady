package com.cap.seattlegetready;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;


public class WhatActivity extends AppCompatActivity {

    private String TAG = MainActivity.class.getSimpleName();

    private ProgressDialog pDialog;
    private ListView parsedJson;


    private static String url = "https://api.myjson.com/bins/1dlc0l";

    JSONObject xx = new JSONObject();

    String jsonStr="[" +
            "{\"id\":\"\",\"title\":\"ABOUT...\",\"brief\":\"Earthquakes are the most serious hazard facing Seattle. Unlike other potentially catastrophic hazards, Seattle has had and will experience powerful earthquakes.\",\"filesource\":\"http://www.seattle.gov/emergency-management/hazards/earthquake\"}," +
            "{\"id\":\"\",\"title\":\"SEATTLE...\",\"brief\":\" An earthquake on the Seattle Fault poses the greatest risk to Seattle because:\n" +
            "\n" +
            "    The Seattle Fault Zone extends east-west through the middle of the city.\n" +
            "    A Seattle Fault quake could be as large as M7.5,160 but less than M7.0 is more probable.\n" +
            "    The most recent Seattle Fault earthquake was about 1,100 years ago;\n" +
            "    The Seattle Fault has been active about three or four times in the past 3,000 years.\",\"filesource\":\"http://www.seattle.gov/emergency-management/hazards/earthquake\"}," +
            "{\"id\":\"\",\"title\":\"TYPES...\",\"brief\":\"The Seattle area experiences three earthquake types with varying consequences:o Crustal or Shallow Quakes occur in the North American plate at 0-30 km near the crust's surface along faults. Intense shaking occurs near the epicenter but usually diminishes quickly with distance relative to the other earthquake types.\n" +
            "\n" +
            "    Crustal earthquakes are expected on the Seattle Fault Zone, which is the primary but not only source for this type of quake in Seattle. An example of a crustal earthquake is the magnitude (M)6.2 Christchurch, New Zealand earthquake that occurred in 2011.\n" +
            "    Intraplate or Deep Quakes occur at depths of 30-70 km in oceanic crust as it dives under lighter continental crust. Because of the depth, even buildings located right above them are far enough away that seismic waves are attenuated. An example of a deep earthquake is the M6.8 Nisqually Earthquake that occurred in the Pacific Northwest in 2001.\n" +
            "    Subduction Zone or Megathrust Quakes occur on the interface between the North American plate and the Juan de Fuca plate, a small plate extending from northern California to British Columbia. An example of a megathrust earthquake is the M9.0 Tōhoku Earthquake that occurred off the coast of Japan in 2011." +
            "\",\"filesource\":\"http://www.seattle.gov/emergency-management/hazards/earthquake\"}" +
            "] }";



    ArrayList<HashMap<String, String>> recyclerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_what);

        recyclerList = new ArrayList<>();

        parsedJson = findViewById(R.id.parsedJson);


        Log.e(TAG, "Response from url: " + jsonStr);

        if (jsonStr != null) {
            try {

                // Getting JSON Array
                JSONArray report = new JSONArray(jsonStr);

                // EARTHQUAE Info
                for (int i = 0; i < report.length(); i++) {
                    JSONObject c = report.getJSONObject(i);

                    String id = c.getString("id");
                    String title = c.getString("title");
                    String brief = c.getString("brief");
                    String filesource = c.getString("filesource");

                    // HASH
                    HashMap<String, String> reports = new HashMap<>();

                    // ADD to HAsh
                    reports.put("id", id);
                    reports.put("title", title);
                    reports.put("brief", brief);
                    reports.put("filesource", filesource);

                    // aAdd Earthquake info
                    recyclerList.add(reports);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        ListAdapter adapter = new SimpleAdapter(
                WhatActivity.this, recyclerList,
                R.layout.parsed_list, new String[]{"id", "title",
                "brief","filesource"}, new int[]{R.id.id,
                R.id.title, R.id.brief,R.id.filesource});

        parsedJson.setAdapter(adapter);
    }
}