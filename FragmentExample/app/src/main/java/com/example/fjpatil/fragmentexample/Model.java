package com.example.fjpatil.fragmentexample;

import java.io.Serializable;

/**
 * Created by Fakkirgouda.Patil on 11/23/2015.
 */
public class Model implements Serializable {

    public String name;



    public Model(String name) {
        this.name = name;
    }

    public Model() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
