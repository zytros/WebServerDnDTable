package JSON;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Json {

    public String toJSON(Object o){
        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;
        try {
            json = objectMapper.writeValueAsString(o);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    public List<Character> fromJSONCharacterList(String json){
        ObjectMapper objectMapper = new ObjectMapper();
        List<Character> characters = new ArrayList<>();
        try {
            characters = Arrays.asList(objectMapper.readValue(json, Character[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }



}
