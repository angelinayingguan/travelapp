package com.example.angelina.travelapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;


public class FoodToPeople extends Activity {
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    Bill data;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        intent = getIntent();
        data = (Bill)intent.getSerializableExtra("itemSend");
        expListView = (ExpandableListView) findViewById(R.id.lvExp);
        listAdapter = new ExpandableListAdapter(this, data);
        expListView.setAdapter(listAdapter);
    }

    public void back(View view){
        finish();
    }



}
