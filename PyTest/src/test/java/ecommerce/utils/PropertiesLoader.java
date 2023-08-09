package ecommerce.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {
  private static PropertiesLoader instance;
  private Properties properties;

  private PropertiesLoader() {
    // Carga las propiedades en el constructor
    properties = new Properties();
    try {
      InputStream inputStream = PropertiesLoader.class.getClassLoader().getResourceAsStream("config.properties");
      properties.load(inputStream);
      inputStream.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static PropertiesLoader getInstance() {
    if (instance == null) {
      instance = new PropertiesLoader();
    }
    return instance;
  }

  public Properties getProperties() {
    return properties;
  }
}
