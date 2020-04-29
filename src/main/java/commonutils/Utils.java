package commonutils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utils {
    public Object propertiesFileReader(String key, String filepath) throws IOException {
        Properties prob = new Properties();
        InputStream inputStream = new FileInputStream(filepath);
        prob.load(inputStream);
        Object value = prob.get(key);
        return value;
    }
}
