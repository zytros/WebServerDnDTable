package JSON;



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
        List<Character> chars = json.fromJSONCharacterList(update);
        characters = chars.toArray(characters);
        System.out.println(update);
    }

    public String getRequest(){
        ArrayList<Character> charList = new ArrayList<>();
        for (int i = 0; i < charnums; i++){
            charList.add(characters[i]);
        }
        System.out.println("GET-request");
        
        return json.toJSON(charList);
    }
}
