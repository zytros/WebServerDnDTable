package JSON;


import com.fasterxml.jackson.core.type.TypeReference;

import java.util.ArrayList;
import java.util.List;

public class CharacterData {
    public int charnums = 4;
    public Character[] characters = new Character[charnums];
    public Json json = new Json();

    public CharacterData(){
        for(int i = 0; i < charnums; i++){
            characters[i] = new Character(i);
        }
    }
    public boolean contains(String name){
        boolean ret = false;
        for(Character c : characters){
            if (c.getName().equals(name)){
                ret = true;
            }
        }
        return ret;
    }

    public void postUpdate(String update){
        List<Character> chars = json.fromJSON(update, Character[].class);
        for (Character c : chars){
            for (Character cs : characters){
                if (c.getName().equals(cs.getName())){
                    cs = c;
                }
            }
        }
    }

    public String getRequest(){
        ArrayList<Character> charList = new ArrayList<>();
        for (int i = 0; i < charnums; i++){
            charList.add(characters[i]);
        }
        return json.toJSON(charList);
    }
}
