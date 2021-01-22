package service.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {

    public static String getProperty(String property) {
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("src//test//resources//config.properties"));
            return prop.getProperty("BASEURI");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

    }
}
