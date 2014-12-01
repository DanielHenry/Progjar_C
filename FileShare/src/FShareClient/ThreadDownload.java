import java.io.*;
import java.util.*;
import java.lang.*;
import java.net.*;
import FShareCommon.*;

class ThreadDownload implements Runnable
{
	private ArrayList<InetAddress> addresslist;
	private String file;
	
	public void setArrayInetAddress(ArrayList<InetAddress> addresslist)
	{
		this.addresslist = addresslist;
	}
	public void setFile(String file)
	{
		this.file = file;
	}
	
	public void run()
	{
		try
		{
			Socket hubungsocket = new Socket(addresslist.get(0),1234);
			BufferedReader br = new BufferedReader(new InputStreamReader(hubungsocket.getInputStream()));
			PrintWriter tulis_di_file = new PrintWriter(this.file);
			char c;
			int buf;
			while ((buf = br.read())!=-1)
			{
				c = (char)buf;
				tulis_di_file.print(c);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
