package com.example.angelina.travelapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

public class RegisterActivity extends ActionBarActivity {
    EditText email, pass, name, username;
    DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        //final Button bRegister = (Button) findViewById(R.id.btn_signup);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        /*getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#e12929'>Sign Up</font>"));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/
    }



       /* bRegister.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                final String semail = email.getText().toString();
                final String sname = name.getText().toString();
                final String susername = username.getText().toString();
                final String spassword = pass.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                RegisterActivity.this.startActivity(intent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                builder.setMessage("Register Failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                RegisterRequest registerRequest = new RegisterRequest(semail,sname, susername, spassword, responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerRequest);
            }
        });}

*/

    public void Login(View v) {
        email = (EditText) findViewById(R.id.email);
        name = (EditText) findViewById(R.id.name);
        pass = (EditText) findViewById(R.id.password);
        username= (EditText) findViewById(R.id.id);
        String namestr = name.getText().toString();
        String usernamestr = username.getText().toString();
        String passstr = pass.getText().toString();
        String emailstr = email.getText().toString();

        /*if (CheckFieldValidation()) {
            //Calling method of field validation*/
        if(email.getText().toString().equals("")){
            email.setError("Can't be Empty");
            }
        else if(name.getText().toString().equals("")){
            name.setError("Can't be Empty");
            ;
        }else if(pass.getText().toString().equals("")){
            pass.setError("Can't be Empty");
            ;
        }else if(username.getText().toString().equals("")){
            username.setError("Can't be Empty");
            ;
        }
        else{
            Contact c = new Contact();
            c.setName(namestr);
            c.setEmail(emailstr);
            c.setUsername(usernamestr);
            c.setPass(passstr);

            helper.insertContact(c);
            Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(i);
            /*//insert the details in database
            Contact c =new Contact();
            c.setEmail(emailstr);*/

        //}

    }}

    //When Button Sign up clicked
    public void Back(View v){

        Intent i= new Intent(RegisterActivity.this,LoginActivity.class);
        startActivity(i);
    }
    public void dlogin(View v) {
        email = (EditText) findViewById(R.id.email);
        name = (EditText) findViewById(R.id.name);
        pass = (EditText) findViewById(R.id.password);
        username = (EditText) findViewById(R.id.id);
        String namestr = name.getText().toString();
        String usernamestr = username.getText().toString();
        String passstr = pass.getText().toString();
        String emailstr = email.getText().toString();

        /*if (CheckFieldValidation()) {
            //Calling method of field validation*/
        if (email.getText().toString().equals("")) {
            email.setError("Can't be Empty");
        } else if (name.getText().toString().equals("")) {
            name.setError("Can't be Empty");
            ;
        } else if (pass.getText().toString().equals("")) {
            pass.setError("Can't be Empty");
            ;
        } else if (username.getText().toString().equals("")) {
            username.setError("Can't be Empty");
            ;
        } else {
            Contact c = new Contact();
            c.setName(namestr);
            c.setEmail(emailstr);
            c.setUsername(usernamestr);
            c.setPass(passstr);

            helper.insertContact(c);
            Intent i = new Intent(RegisterActivity.this, MainActivity.class);
            startActivity(i);
        }
    }}
    //checking field are empty

    /*private boolean CheckFieldValidation(){

        boolean valid=true;
        if(email.getText().toString().equals("")){
            email.setError("Can't be Empty");
            valid=false;}
        else if(name.getText().toString().equals("")){
            name.setError("Can't be Empty");
            valid=false;
        }else if(pass.getText().toString().equals("")){
            pass.setError("Can't be Empty");
            valid=false;
        }else if(username.getText().toString().equals("")){
            username.setError("Can't be Empty");
            valid=false;
        }
        return valid;
    }
}*/