package com.example.angelina.travelapp;

/**
 * Created by angelina on 2/22/17.
 */

public class MapData {
    int mid;
    String location1, location2;

    public void setId(int id)
    {
        this.mid =id;
    }
    public int getId()
    {
        return this.mid;
    }

    public void setLocation1(String locationmap1)
    {this.location1 =locationmap1;}

    public String getLocation1()
    {return this.location1;
    }

    public void setLocation2(String locationmap2)
    {this.location2 =locationmap2;}

    public String getLocation2()
    {return this.location2;
    }
}


