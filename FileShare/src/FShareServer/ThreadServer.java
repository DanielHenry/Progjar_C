package FShareServer;

import java.io.*;
import java.util.*;
import java.net.Socket;
import FShareCommon.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class ThreadServer implements Runnable {

    private Socket clientsocket;
    private ArrayList<FileHaveIndex> index;
    private ObjectInputStream streamIn = null;
    private ObjectOutputStream streamOut = null;

    public ThreadServer(Socket clientsocket) {
        this.clientsocket = clientsocket;
    }

    public void setIndex(ArrayList<FileHaveIndex> fileIndex) {
        this.index = fileIndex;
    }

    @Override
    /*public void run() {
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
     }*/
    public void run() {
        try {
            streamIn = new ObjectInputStream(clientsocket.getInputStream());
            if (streamIn != null) {
                CommunicationObject input = (CommunicationObject) streamIn.readObject();
                if (input.GetClassTypeEnum() == 1) {
                    FileHave obj = (FileHave) input;
                    
                    // If object is FileHave
                    
                    if(obj.GetSubClassTypeEnum()==1){
                        byte[] hash = obj.GetMD5Hash();
                        boolean found = false;
                        for(int i=0;i<index.size();i++){
                            int comp = index.get(i).CompareHash(hash);
                            if(comp==1){
                                found=true;
                                index.get(i).AddRemoteNode(obj.GetAddr());
                                break;
                            }
                        }
                        if(!found){
                            FileHaveIndex temp = new FileHaveIndex(3, 0);
                            temp.SetFilename(obj.GetFilename());
                            temp.SetMD5Hash(obj.GetMD5Hash());
                            temp.SetSize(obj.GetSize());
                            temp.AddRemoteNode(obj.GetAddr());
                        }
                    }
                    // End FileHave
                }
            }

        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ThreadServer.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }
}