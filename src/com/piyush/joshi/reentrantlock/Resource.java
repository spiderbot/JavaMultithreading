package com.piyush.joshi.reentrantlock;

import java.util.HashMap;
import java.util.Map;

public class Resource {

    Map<String,String> data = new HashMap<>();

    public void putData(String key,String value){
        data.put(key,value);
    }

    public void printData(){
        data.entrySet().stream().forEach((key) -> {
            System.out.println(key + " -> " + data.get(key));
        });
    }
}
