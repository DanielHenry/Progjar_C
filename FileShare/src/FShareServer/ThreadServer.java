package FShareServer;

import java.io.*;
import java.util.*;
import java.lang.Runnable;
import java.net.Socket;

class ThreadServer implements Runnable {

    private Socket clientsocket;

    public ThreadServer(Socket clientsocket) {
        this.clientsocket = clientsocket;
    }
    public void setIndex(){
        
    }
    @Override
    public void run() {
        try {
            InputStream is = this.clientsocket.getInputStream();
            OutputStream os = this.clientsocket.getOutputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
            String kalimat = new String();
            char c;
            while (true) {

                kalimat = br.readLine();
                bw.write(kalimat + "\r\n");
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
