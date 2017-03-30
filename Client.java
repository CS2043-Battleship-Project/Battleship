import java.io.*;
import java.net.*;

public class Client
{
  private String host;
  private int port;
  private ServerSocket socket;
  private Socket s;



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


  }


  public static void main(String[] args)
  {


  }
}
