import java.io.*;
import java.util.*;
import java.lang.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.*;

class utama
{
	public static void main(String[] argv)
	{
		try
		{
			while (true)
			{
				ServerSocket serversocket = new ServerSocket(1234);
				Socket clientsocket = serversocket.accept();
				ThreadServer thread = new ThreadServer(clientsocket);
				thread.run();
			}
		}
		catch(IOException e)
		{
			System.out.println("Ada yang salah dengan semua ini dari server utama!!!");
		}
	}
}
