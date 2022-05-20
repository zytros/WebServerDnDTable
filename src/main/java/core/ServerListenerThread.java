package core;

import JSON.CharacterData;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerListenerThread extends Thread{
    ServerSocket serverSocket;
    CharacterData characterData = new CharacterData();

    public ServerListenerThread(ServerSocket serverSocket){
        this.serverSocket = serverSocket;
    }

    public void run() {
        try {
            while(serverSocket.isBound() && !serverSocket.isClosed()) {
                Socket socket = this.serverSocket.accept();
                System.out.println("started");
                ConnectionWorkerThread workerThread = new ConnectionWorkerThread(socket, characterData);
                Thread t = new Thread(workerThread);
                t.start();
            }


        } catch (IOException e) {
        } finally {
            if(serverSocket != null){
                try {
                    serverSocket.close();
                } catch (IOException e) {}
            }
        }
    }
}
