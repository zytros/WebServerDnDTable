 package core;

import JSON.CharacterData;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ConnectionWorkerThread extends Thread{

    private Socket socket;
    private CharacterData characterData;


    public ConnectionWorkerThread(Socket socket, CharacterData characterData){
        this.socket = socket;
        this.characterData = characterData;
    }

    @Override
    public void run() {
        InputStream inputStream = null;
        DataOutputStream outputStream = null;
        try {
            inputStream = socket.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            outputStream = new DataOutputStream(socket.getOutputStream());


            DataInputStream input = new DataInputStream(inputStream);
            //String request = input.readUTF();
            String request = in.readLine();
            //System.out.println(request);

            String response = null;
            String[] splreq = request.split("%1");
            if(splreq[0].equals("GET")){
                if(splreq[1].equals("chardata")){
                    response = characterData.getRequest();
                }else if(splreq[1].equals("ledinfo")){
                    //TODO ledinfo
                }

            }else if(splreq[0].equals("POST")){
                if(splreq[1].equals("pw")){
                    //check pw
                    characterData.postUpdate(splreq[2]);
                    response = "1";
                }else {
                    response = "0";
                } 
            }


            //System.out.println(response);
            outputStream.writeUTF(response);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {}
            }if(outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {}
            }if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {}
            }
        }
    }
}
