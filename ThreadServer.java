import java.io.*;
import java.util.*;
import java.lang.Runnable;
import java.net.Socket;

class ThreadServer implements Runnable
{
	private Socket clientsocket; 
	
	public ThreadServer(Socket clientsocket)
	{
		this.clientsocket = clientsocket;
	}
	public void run()
	{
		try
		{
			InputStream is = this.clientsocket.getInputStream();
			OutputStream os = this.clientsocket.getOutputStream();
			char[] kalimat = new char[1000];
			int buf;
			char c;
			for (int i=0; (buf = is.read())!=-1; i++)
			{
				c = (char)buf;
				kalimat[i] = c;
			}
			String pesan = kalimat.toString();
			os.write(pesan.getBytes());
		}
		catch (IOException e)
		{
			System.out.println("Ada yang salah dengan semua ini dari thread!!!");
		}
		
	}
}
