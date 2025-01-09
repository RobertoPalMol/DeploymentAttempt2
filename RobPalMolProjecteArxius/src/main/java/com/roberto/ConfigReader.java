package com.roberto;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private Properties properties;

    public ConfigReader(String filePath) throws IOException {
        properties = new Properties();
        try (FileInputStream input = new FileInputStream(filePath)) {
            properties.load(input);
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
