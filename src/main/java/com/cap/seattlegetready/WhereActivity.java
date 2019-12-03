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
                        3, "EAST CENTRAL",
                        "***HUB 129 - Queen Anne P-Patch - 3rd Ave N & Lynn St\n" +
                                 "***HUB 20 - West Queen Anne Playfield150 W Blaine St",
                        4, "QUEEN ANN", R.drawable.queenannz));

        mapList.add(
                new Maps(
                        4, "NORTH WEST",
                        "***HUB 35 - NW 57th & 22nd Ave NW\n" +
                                "***HUB 100 - Olympic Sculpture Park - 2855 NW 58th St\n" +
                                "***HUB 111 - Greg's Garden P-Patch - 14th Ave NW & NW 54th S",
                        3, "BALLARDS", R.drawable.ballards));

        mapList.add(
                new Maps(
                        5, "SOUTH WEST",
                        "***HUB 17 - California Ave SW & SW Lander St\n" +
                                "***HUB 16 - Alki Community Center 59th Ave SW & SW Stevens St" ,
                        4, "WEST SEATTLE", R.drawable.westseattle));

        mapList.add(
                new Maps(
                        6, "NORTH CENTRAL",
                        "***HUB 38 - Lower Woodland PlayfieldsGreen Lake Way N & N 50th St\n" +
                                "***HUB 33 - Green Lake Playfield & Community Center7201 Green Lake Dr N",
                        2, "GREEN LAKE", R.drawable.greenlake));



        // Create...
        MapsAdapter adapter = new MapsAdapter(this, mapList);

      //  SET...
        recyclerView.setAdapter(adapter);
    }
}