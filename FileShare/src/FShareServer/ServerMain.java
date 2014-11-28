package FShareServer;

import java.io.*;
import java.util.*;
import java.lang.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.*;

public class ServerMain
{
	public static void main(String[] argv)
	{
		try
		{
			while (true)
			{
				ServerSocket serversocket = new ServerSocket(1234);
				Socket clientsocket = serversocket.accept();
                                System.out.println("Accepted connection at" + clientsocket.getRemoteSocketAddress().toString());
				ThreadServer thread = new ThreadServer(clientsocket);
				thread.run();
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
