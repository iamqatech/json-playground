package main.java;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;

public class JsonUtil {


    private static String filePath = "src/main/resources/testFile.json";

    public static void main(String[] args) {
try{
        System.out.println("Json Playground is live !!!!");
        System.out.println(filePath);
        LoadJsonObjectFromFile(filePath);

    }

  catch (Exception e){
      System.out.println(e.getMessage());
  }
    }


    public static void LoadJsonObjectFromFile(String filePath) {

        try {
            File jsonFile = new File(filePath);

            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(jsonFile);
            JsonNode users = rootNode.get("users");
            System.out.println(users);
            for (JsonNode user : users)
            {
                JsonNode userData = user.get("user");

                JsonNode userName= userData.get("name");

                System.out.println("User name is "+ userName.asText());



            }
        }

        catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }

}
