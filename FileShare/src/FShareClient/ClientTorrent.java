package FShareClient;

import java.io.*;
import java.util.*;
import java.lang.*;
import java.net.Socket;
import FShareClient.*;
import FShareCommon.*;


/* @author Wildi*/
public class ClientTorrent {

    public static void main(String[] args) {
        ArrayList<ClientThread> listThread=new ArrayList<>();
        ArrayList<FileSeed> seedIndex=new ArrayList<>();
        Socket serverSock = null;
        try {
            Scanner scan = new Scanner(System.in);
            String m;

            /*InputStream r = client.getInputStream();
            OutputStream w = client.getOutputStream();
            for (; true;) {
            m = scan.nextLine();
            w.write(m.getBytes());
            
            for (; true;) {
            int temp = r.read();
            if (temp == -1) {
            break;
            } else {
            char a = (char) temp;
            System.out.print(a);
            }
            }
            }*/
            
            while(true){
                m=scan.nextLine();
                String low = m;
                low.toLowerCase();
                System.out.println(low);
                if(low.startsWith("create")){
                    System.out.println("Create initialized");
                    ClientThread thread = new ClientThread();
                    thread.SetMethod(1);
                    thread.SetCommand(m);
                    listThread.add(thread);
                    thread.run();
                }
                else if(low.startsWith("load")){
                    System.out.println("Load initialized");
                    if(serverSock==null){
                        System.out.println("Initialize server first!");
                        continue;
                    }
                    ClientThread thread = new ClientThread();
                    thread.SetMethod(2);
                    thread.SetCommand(m);
                    thread.SetServerSocket(serverSock);
                    listThread.add(thread);
                    thread.run();
                }
                else if(low.startsWith("server")){
                    System.out.println("Input server IP address: ");
                    m=scan.nextLine();
                    serverSock = new Socket(m, 1234);
                    System.out.println("server IP address: " + serverSock.getInetAddress().toString() + " " + serverSock.getPort());
                }
                else{
                    PrintHelp();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void PrintHelp(){
        System.out.println("Command list:\nCREATE: create file descriptor");
    }

}
