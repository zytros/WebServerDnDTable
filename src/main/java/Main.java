import JSON.Character;
import JSON.Data;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Data data = new Data();
        System.out.println(data.getRequest());
        for (int i = 1; i < 3; i++){
            data.characters[i].setMaxHP(100);
            data.characters[i].setCurrentHP(50+i);
        }
        data.postUpdate(data.json.toJSON(new ArrayList<Character>(List.of(data.characters))));
        System.out.println(data.getRequest());
    }
}
