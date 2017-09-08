package com.hyperdev.androidme.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import com.hyperdev.androidme.R;
import com.hyperdev.androidme.data.AndroidImageAssets;


public class MainActivity extends AppCompatActivity {

    BodyPartsFragments headPart;
    BodyPartsFragments bodyPart;
    BodyPartsFragments legPart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            headPart = new BodyPartsFragments();
            headPart.setPartList(AndroidImageAssets.getHeads());
            int head = getIntent().getIntExtra("head", 0);
            headPart.setListPosition(head);
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.headParts, headPart)
                    .commit();


            bodyPart = new BodyPartsFragments();
            bodyPart.setPartList(AndroidImageAssets.getBodies());
            int body = getIntent().getIntExtra("body", 0);
            bodyPart.setListPosition(body);
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.bodyParts, bodyPart)
                    .commit();

            legPart = new BodyPartsFragments();
            legPart.setPartList(AndroidImageAssets.getLegs());
            int leg = getIntent().getIntExtra("legs", 0);
            legPart.setListPosition(leg);
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.legParts, legPart)
                    .commit();
        }
    }
}