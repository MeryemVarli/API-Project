package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {



  public static String readProperty(String key){

      File file=new File("configuration.properties");

      Properties properties = new Properties();

      try{
          properties.load(new FileInputStream(file));
      }catch (IOException e){

          throw new RuntimeException(e);
      }


return properties.getProperty(key);

  }






// if you have more than a file create same method with different name and use another
// file in there so this is the way how you use more than one file






}
