package com.anderscore.frosconsample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by max on 20.08.2015.
 */
public class Model {

    private static Model instance;

    private List<String> data;

    private Model() {
        String[] arrayData = {"Dave",
                "Stuart",
                "Kevin",
                "Bob",
                "Dave",
                "Stuart",
                "Kevin"};
        data = new ArrayList<>();
        data.addAll(Arrays.asList(arrayData));

    }


    //Singleton
    public static Model getInstance() {
        if(instance==null) {
            instance = new Model();
        }
        return instance;
    }


    public List<String> getData() {
      return data;
    }

    public void addItem(String item) {
        data.add(item);
    }
}
