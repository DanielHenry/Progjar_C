package FShareServer;

import java.io.*;
import java.util.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.*;
import FShareCommon.*;

public class ServerMain {

    public static void main(String[] argv) {
        ArrayList<FileHaveIndex> fileIndex = new ArrayList<>();
        ArrayList<ThreadServer> connectedNode = new ArrayList<>();
        try {
            ServerSocket serversocket = new ServerSocket(1234);
            while (true) {
                Socket clientsocket = serversocket.accept();
                System.out.println("Accepted connection at" + clientsocket.getRemoteSocketAddress().toString());
                ThreadServer thread = new ThreadServer(clientsocket);
                connectedNode.add(thread);
                thread.setIndex(fileIndex);
                thread.run();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
