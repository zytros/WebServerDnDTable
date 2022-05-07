package core;

import JSON.Data;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerListenerThread extends Thread{
    ServerSocket serverSocket;
    Data data = new Data();

    public ServerListenerThread(ServerSocket serverSocket){
        this.serverSocket = serverSocket;
    }

    public void run() {
        try {
            while(serverSocket.isBound() && !serverSocket.isClosed()) {
                Socket socket = this.serverSocket.accept();

                ConnectionWorkerThread workerThread = new ConnectionWorkerThread(socket, data);
                workerThread.start();
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
