package clienttorrent;

import java.io.*;
import java.util.*;
import java.lang.*;
import java.net.Socket;

/* @author Wildi*/
public class ClientTorrent {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String m;
        Socket client = new Socket(); /*didalam kurung ada ip, port*/
        InputStream r = client.getInputStream();
        OutputStream w = client.getOutputStream();
        for(;true;){
            m = scan.nextLine();
            w.write(m.getBytes()); /*isi didalam kurung adalah byte kalimat yang mau diisi*/
            for(;true;){
                int temp = r.read();
                if(temp == -1)
                    break;
                else{
                    char a = (char)temp;
                    System.out.print(a);
                }
            }   
        }            
    }
    
}
