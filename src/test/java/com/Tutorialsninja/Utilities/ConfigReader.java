package com.Tutorialsninja.Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    static {
        try{
            String path="config.properties";

            //dosyayi java diline okur
            FileInputStream input =new FileInputStream(path);

            properties =new Properties();

            //verileri dosyadan, kye value seklinde yukler
            properties.load(input);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String getProperties(String KeyName){

        return properties.getProperty(KeyName);
    }

}
