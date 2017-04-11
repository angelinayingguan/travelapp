package com.example.angelina.travelapp;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.angelina.travelapp.places.PlacesActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttona= (Button) findViewById(R.id.b1);
        buttona.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                Intent startNewPage= new Intent(MainActivity.this, PlacesActivity.class);
                startActivity (startNewPage);
            }

        });


        Button buttonc= (Button) findViewById(R.id.b5);
        Button buttond= (Button) findViewById(R.id.b6);


        buttonc.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                Intent startNewPage= new Intent(MainActivity.this, MainActivity.class);
                startActivity (startNewPage);
            }

        });

        buttond.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                Intent startNewPage= new Intent(MainActivity.this, CameraActivity.class);
                startActivity (startNewPage);
            }

        });

    }


}
