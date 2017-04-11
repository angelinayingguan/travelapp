package com.example.angelina.travelapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;

public class FromToActivity extends ActionBarActivity {
    EditText address1, address2;
    MapDatavaseHelper helper1 = new MapDatavaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_from_to);


        //final Button bRegister = (Button) findViewById(R.id.btn_signup);

        /*getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#e12929'>Map Part1</font>"));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/
    }


    public void Mapp(View v) {
        address1 = (EditText) findViewById(R.id.from);
        address2 = (EditText) findViewById(R.id.to);
        String address1str = address1.getText().toString();
        String address2str = address2.getText().toString();

        /*if (CheckFieldValidation()) {
            //Calling method of field validation*/
        if(address1.getText().toString().equals("")){
            address1.setError("Can't be Empty");
        }
        else if(address1.getText().toString().equals("")){
            address1.setError("Can't be Empty");
            ;
        }
        else{
            MapData dmp = new MapData();
            dmp.setLocation1(address1str);
            dmp.setLocation2(address2str);


            helper1.insertMap(dmp);
            Intent i = new Intent(FromToActivity.this, MapsActivity.class);
            startActivity(i);
            /*//insert the details in database
            Contact c =new Contact();
            c.setEmail(emailstr);*/

            //}

        }}

    //When Button Sign up clicked

}