package com.example.angelina.travelapp.events.ui;

import android.app.Application;

import com.example.angelina.travelapp.events.api.EventbriteApi;
import com.example.angelina.travelapp.events.db.CachingDbHelper;
import com.example.angelina.travelapp.events.helper.Constants;

public class EventbriteApplication extends Application {
    private static EventbriteApplication instance;
    private CachingDbHelper cachingDbHelper;
    private EventbriteApi eventbriteApi;

    @Override
    public void onCreate() {
        super.onCreate();
        this.instance = this;
        this.eventbriteApi = new EventbriteApi(Constants.EventbriteApi.URL);
        this.cachingDbHelper = new CachingDbHelper(getApplicationContext());
    }

    public static EventbriteApplication getApplication() {
        return instance;
    }

    public CachingDbHelper getCachingDbHelper() {
        return cachingDbHelper;
    }

    public EventbriteApi getEventbriteApi() {
        return eventbriteApi;
    }
}
