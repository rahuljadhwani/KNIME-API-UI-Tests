package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


/**
 * This class contains logic for reading properties file and return it as a map
 *
 */
public final class PropertyReaderUtil {

    private PropertyReaderUtil(){

    }

    static HashMap<String, String> propertyFileData = new HashMap<>();

    public static HashMap<String, String> readPropertyFileAsMap(String filePathFromProjectRoot) {
        Properties properties = new Properties();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(System.getProperty("user.dir")+ File.separator+filePathFromProjectRoot);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(Map.Entry<Object, Object> entry : properties.entrySet()){
            propertyFileData.put((String) entry.getKey(), CryptUtil.decodeData((String) entry.getValue()));
        }
        return propertyFileData;
    }

    public static void emptyPropertyMap(){
        propertyFileData = null;
    }

}
