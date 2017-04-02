import java.io.*;
import java.net.*;

public class Client
{
  private String host;
  private int port;
  private ServerSocket socket;
  private Socket s;
  private PrintWriter out;
  private BufferedReader in;
  private BufferedReader stdln;
  private SetupGUI setupGUI;

  public Client(String host, int port)
  {
     this.host = host;
     this.port = port;
      s = null;
     
	
    try
    {
        s = new Socket(host, port);
    }
    catch (UnknownHostException e)
    {
      System.err.println("Unknown host: " + host);
      System.exit(-1);
    }
    catch (IOException e)
    {
      System.err.println("Unable to get I/O connection to: "
                        + host + " on port: " + port);
      System.exit(-1);
    }
	
	setupGUI = new SetupGUI();
	
	openStream();
	messageToServer();
	
  }
  public void openStream()
  {
    try
    {
      out = new PrintWriter(s.getOutputStream(), true);
      in = new BufferedReader(new InputStreamReader(s.getInputStream()));
      stdln = new BufferedReader(new InputStreamReader(System.in));
    }
    catch(IOException e)
    {
        System.out.println("Problem reading or writing:" + e.getMessage());
    }
  }
  public void messageToServer()
  {
      boolean done = false;
      try{
      while(!done )
      {
        String line = in.readLine();
        if(line == null)
        {
          done = true;
		  closeStream();
        }
        else
        {
          out.println(line);
        }
      }
    }
    catch(IOException e)
    {
      System.out.println("Problem reading or writing:" + e.getMessage());
    }
  }
  public void closeStream()
  {

    try
    {
        in.close();
        out.close();
        stdln.close();
        s.close();

    }
    catch(IOException e)
    {
      System.out.println("Problem with closing the reader, writer or socket");
    }


  }
	public void paintComponent()
	{
		SetupGUI setupGUI = new SetupGUI();
		setupGUI.createComponents();
	}
  

 /* public static void main(String[] args)
  {
    Client client =new Client("localhost", 31415);
    client.openStream();
    client.messageToServer();
    client.closeStream();

  }*/
}
