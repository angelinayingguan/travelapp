package com.example.angelina.travelapp;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

public class server extends AppCompatActivity {

    private String TAG = server.class.getSimpleName();

    private ProgressDialog pDialog;
    private ListView lv;

    //TextView mTextview;

    //TextView mTextview = (TextView)findViewById(R.id.textView1);

    //private String jr = getIntent().getStringExtra("mytext");

    //TextView mTextview;
    //mTextview = (TextView)findViewById(R.id.textView1);
    //mTextview.setText(getIntent().getStringExtra("mytext"));

    // URL to get contacts JSON
    //http://vlan431-168.subnet-230.amherst.edu:9001/geoAC/42.371671,-72.517136/ (link for
    //private static String url = "http://vlan431-168.subnet-230.amherst.edu:9001/geoAC/42.372900,-72.515654/";
    //private static String url;
    //private static String url = "http://vlan431-168.subnet-230.amherst.edu:9001/geoAC/" + jr + "/";

    ArrayList<HashMap<String, String>> contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server);

        //String jr = getIntent().getStringExtra("mytext");

        //url = "http://vlan431-168.subnet-230.amherst.edu:9001/geoAC/" + (jr) + "/";
        //url = "http://vlan431-168.subnet-230.amherst.edu:9001/geoAC/42.372900,-72.515654/";

        contactList = new ArrayList<>();

        lv = (ListView) findViewById(R.id.list);

        new GetContacts().execute();
    }

    /**
     * Async task class to get json by making HTTP call
     */
    private class GetContacts extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialogf
            pDialog = new ProgressDialog(server.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();

            //String url = "http://vlan431-168.subnet-230.amherst.edu:9001/geoAC/40.6782,-73.9442/";


            //42.372012 -72.514722

            //String url = "http://vlan431-168.subnet-230.amherst.edu:9001/geoAC/KEEFE/";
            String jr = getIntent().getStringExtra("location");

            String url = "http://vlan431-168.subnet-230.amherst.edu:9001/geoAC/" + (jr) + "/";
            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url);

            Log.e(TAG, "Response from url: " + jsonStr);
            //TextView textView2 = (TextView)findViewById(R.id.textView2);

            //TextView textView2 = (TextView)findViewById(R.id.textView);
            //textView2.setText(result);

            if (jsonStr != null) {
                try {
                    //TextView textView2 = (TextView)findViewById(R.id.textView2);
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting JSON Array node
                    JSONArray contacts = jsonObj.getJSONArray("contacts");
                    // looping through All Contacts
                    for (int i = 0; i < contacts.length(); i++) {
                        JSONObject c = contacts.getJSONObject(i);

                        String event = c.getString("event");
                        String description = c.getString("description");
                        String building = c.getString("building");
                        String time = c.getString("time");
                        String date = c.getString("dateToday");

                        // Phone node is JSON Object
                        //JSONObject phone = c.getJSONObject("phone");
                        //String home = phone.getString("home");
                        //String office = phone.getString("office");

                        // tmp hash map for single contact
                        HashMap<String, String> contact = new HashMap<>();

                        // adding each child node to HashMap key => value
                        contact.put("event", event);
                        contact.put("description", description);
                        contact.put("building", building);
                        contact.put("time", time);
                        contact.put("date", date);

                        // adding contact to contact list
                        contactList.add(contact);
                    }
                }
                catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    });

                }
                //textView2.setText(idu);
            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });

            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();
            /**
             * Updating parsed JSON data into ListView
             * */
            ListAdapter adapter = new SimpleAdapter(
                    server.this, contactList,
                    R.layout.list_item, new String[]{"event", "description",
                    "building", "time", "date"}, new int[]{R.id.event,
                    R.id.description, R.id.building, R.id.time, R.id.date});

            lv.setAdapter(adapter);
        }

    }
}
