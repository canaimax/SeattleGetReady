package com.cap.seattlegetready;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class HowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        Button stayingButton = (Button) findViewById(R.id.stayingsafe);
        stayingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HowActivity.this, StaySafeAct.class));
            }
        });

        Button buildingButton = (Button) findViewById(R.id.buildINGakit);
        buildingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HowActivity.this, BuildKitAct.class));
            }
        });


        Button storingButton = (Button) findViewById(R.id.storingwater);
        storingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HowActivity.this, StoreWaterAct.class));
            }
        });

        Button medicalButton = (Button) findViewById(R.id.medicalneeds);
        medicalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HowActivity.this, MedNeedsAct.class));
            }
        });



        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "HOW SECTION", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
