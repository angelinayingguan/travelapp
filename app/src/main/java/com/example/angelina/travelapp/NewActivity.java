package com.example.angelina.travelapp;

/**
 * Created by azkajavaid on 4/26/17.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void bClick(View view){

        //text is entered as latitude, longitude pairs
        EditText editText = (EditText)findViewById(R.id.edittext);
        String text = editText.getText().toString();
        Intent mintent = new Intent(NewActivity.this, server.class);
        mintent.putExtra("location", text);
        startActivity(mintent);
    }

    public void bClick2(View view){
        EditText editText = (EditText)findViewById(R.id.edittext2);
        String text = editText.getText().toString();
        Intent mintent2 = new Intent(NewActivity.this, ThirdActivity.class);
        mintent2.putExtra("location2", text);
        startActivity(mintent2);
    }
}



//
//public class NewActivity extends Activity{
//    Button button;
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        // Get the view from activity_main.xml
//        setContentView(R.layout.activity_main2);
//
//        // Locate the button in activity_main.xml
//        button = (Button) findViewById(R.id.MyButton);
//
//        // Capture button clicks
//        button.setOnClickListener(new OnClickListener() {
//            public void onClick(View arg0) {
//
//                // Start NewActivity.class
//                Intent myIntent = new Intent(NewActivity.this,
//                        MainActivity.class);
//                startActivity(myIntent);
//            }
//        });
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.activity_main, menu);
//        return true;
//    }
//}