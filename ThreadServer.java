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
			while (true)
			{
				int i;
				for (i=0; true; i++)
				{
					//System.out.printf("Bisa %d !!\n",i);
					buf = is.read();
					c = (char)buf;
					kalimat[i] = c;
					if (c=='\n') break;
				}
				//System.out.println("Bisa nggak ya!!");
				kalimat[i] = '\0';
				
				//System.out.println("Bisa nggak ya!!");
				
				String pesan = kalimat.toString();
				
				//System.out.println("Bisa nggak ya!!");
				
				os.write(pesan.getBytes());
			}
		}
		catch (IOException e)
		{
			System.out.println("Ada yang salah dengan semua ini dari thread!!!");
		}
		
	}
}
