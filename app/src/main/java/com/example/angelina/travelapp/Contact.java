package com.example.angelina.travelapp;

/**
 * Created by angelina on 2/10/17.
 */

public class Contact {
    int id;
    String name, email, pass, username;

    public void setId(int id)
    {
        this.id =id;
    }
    public int getId()
    {
        return this.id;
    }

    public void setName(String name)
    {this.name =name;}

    public String getName()
    {return this.name;
    }

    public void setUsername(String username)
    {this.username =username;}

    public String getUsername()
    {return this.username;
    }

    public void setEmail(String email)
    {this.email =email;}

    public String getEmail()
    {return this.email;
    }

    public String getPass()
    {return this.pass;
    }
    public void setPass(String pass)
    {this.pass =pass;}



}
