package com.cap.seattlegetready;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class WhereActivity extends AppCompatActivity {

     List<Maps> mapList;

     RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_where);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        mapList = new ArrayList<>();


        //ADD the Maps...

        mapList.add(
                new Maps(
                        1, "CENTRAL",
                        "***HUB 19 - Fisher Pavilion - 2nd Ave N & Thomas St\n" +
                                  "***HUB 139 - Olympic Sculpture Park - 2901 Western Ave\n" +
                                  "***HUB 108 - Cascade P-PatchMinor Ave N & Thomas St",
                        5, "DOWNTOWN", R.drawable.downtownz));

        mapList.add(
                new Maps(
                        2, "WEST CENTRAL",
                        "***HUB 99 - Thomas Street Gardens P-Patch - 1010 E Thomas St\n" +
                                  "***HUB 103 - Unpaving Paradise P-Patch - Summit Ave E & E John St" ,
                        6, "CAPITOL HILL", R.drawable.capitolhillz));

        mapList.add(
                new Maps(
                        1, "EAST CENTRAL",
                        "***HUB 129 - Queen Anne P-Patch - 3rd Ave N & Lynn St\n" +
                                 "***HUB 20 - West Queen Anne Playfield150 W Blaine St",
                        4, "QUEEN ANN", R.drawable.queenannz));


        // Create...
        MapsAdapter adapter = new MapsAdapter(this, mapList);

      //  SET...
        recyclerView.setAdapter(adapter);
    }
}