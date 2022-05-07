package core;

import JSON.Data;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ConnectionWorkerThread extends Thread{

    private Socket socket;
    private Data data;


    public ConnectionWorkerThread(Socket socket, Data data){
        this.socket = socket;
        this.data = data;
    }

    @Override
    public void run() {
        InputStream inputStream = null;
        DataOutputStream outputStream = null;
        try {
            inputStream = socket.getInputStream();
            outputStream = new DataOutputStream(socket.getOutputStream());


            DataInputStream input = new DataInputStream(inputStream);
            String request = input.readUTF();
            String response = null;
            String[] splreq = request.split("%1");
            if(splreq[0].equals("GET")){
                if(splreq[1].equals("chardata")){
                    response = data.getRequest();
                }else if(splreq[1].equals("ledinfo")){
                    //TODO ledinfo
                }

            }else if(splreq[0].equals("POST")){
                if(splreq[1].equals("pw")){
                    //check pw
                    data.postUpdate(splreq[2]);
                    response = "1";
                }else {
                    response = "0";
                }
            }

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
