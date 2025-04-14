package com.automate.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

public class Config {
    private static final Properties prop = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream(
                Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "config.properties").toString()
            );
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return prop.getProperty(key);
    }
}
