package com.example.angelina.travelapp;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by angelina on 2/7/17.
 */

public class LoginFileUtil {
    public static String readFromFile(Context ctx)
    {
        ArrayList<Uinfo> ui = new ArrayList<>();
        String txtemail= new String();
        InputStream inputStream = ctx.getResources().openRawResource(R.raw.userinformation);
        InputStreamReader inputreader = new InputStreamReader(inputStream);
        BufferedReader buffreader = new BufferedReader(inputreader);
        String line;


        try {
            while (( line = buffreader.readLine()) != null) {

                Uinfo u = new Uinfo();
                Log.d("FileUtil", line);
                String[] parts = line.split(",");
                u.setEmail(parts[0]);
                txtemail=u.getEmail(parts[0]);
                u.setPassword(parts[1]);
                ui.add(u);
            }
        } catch (IOException e) {
            return null;
        }

        return txtemail;
    }

}
