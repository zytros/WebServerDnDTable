import JSON.Character;
import JSON.CharacterData;
import core.ServerListenerThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int port = 55239;
    public static void main(String[] args) throws IOException {
        testParsing();
        /*
        ServerListenerThread serverListenerThread = new ServerListenerThread(new ServerSocket(port));
        Thread t = new Thread(serverListenerThread);
        t.start();*/
    }

    public static void testParsing(){
        CharacterData characterData = new CharacterData();
        System.out.println(characterData.getRequest());
        for (int i = 1; i < 3; i++){
            characterData.characters[i].setMaxHP(100);
            characterData.characters[i].setCurrentHP(50+i);
        }
        characterData.postUpdate(characterData.json.toJSON(new ArrayList<Character>(List.of(characterData.characters))));
        System.out.println(characterData.getRequest());
    }
}
