package com.twitter.controller;

import java.io.FileInputStream;
import java.util.Properties;

public class Library {

    public String getProperty(String CONFIG_PATH, String key)
    {
        String property = "";
        Properties properties = new Properties();
        try
        {
            properties.load(new FileInputStream(CONFIG_PATH));
            property = properties.getProperty(key);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return property;
    }
}
