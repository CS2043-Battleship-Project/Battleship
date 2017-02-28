import java.net.*;
import java.io.*;

public class Server {
  private ServerSocket socket;
  private Socket playerOneSocket;
  private Socket playerTwoSocket;
  private BufferedReader playerOneIn;
  private BufferedReader playerTwoIn;
  private PrintWriter playerOneOut;
  private PrintWriter playerTwoOut;

  public Server(String port) {
    // TODO: server connection stuff
    try {
      socket = new ServerSocket(Integer.parseInt(port));
    } catch (IOException e) {
      System.err.println("Couldn't listen on: " + port + ". " + e.getMessage());
    }

    System.out.println("Server listening on port " + port);

    try {
      playerOneSocket = socket.accept();
    } catch (IOException e) {
      System.err.println("Accepting player one failed: " + e.getMessage());
    }


    try {
      playerOneIn = new BufferedReader
                    (new InputStreamReader(playerOneSocket.getInputStream()));
      playerOneOut = new PrintWriter
                     (playerOneSocket.getOutputStream());
	
    } catch (IOException e) {
      System.err.println("Cannot read or write player one: " + e.getMessage());
    }

    System.out.println("Player one connected");

    try {
      playerTwoSocket = socket.accept();
	
    } catch (IOException e) {
      System.err.println("Accepting player two failed: " + e.getMessage());
    }

    try {
      playerTwoIn = new BufferedReader
                    (new InputStreamReader(playerTwoSocket.getInputStream()));
      playerTwoOut = new PrintWriter
                     (playerTwoSocket.getOutputStream());
		String player2Input;
	
	
    } catch (IOException e) {
      System.err.println("Cannot read or write player two: " + e.getMessage());
	
    }
	

    System.out.println("Player two connected");
	try{
	
		boolean done = false;
		GameManager gm = new GameManager();
		while(!done)
		{
		    String player1Input = playerOneIn.readLine();
		     String player2Input = playerTwoIn.readLine();
     		
		     gm.receiveMessage(1,player1Input);
			gm.receiveMessage(2,player2Input);
			
			 if (player1Input.trim().equals("BYE") ||player2Input.trim().equals("BYE") ) {
                  done = true;
               }
		 }
		
	  }
	catch (IOException e) {
         System.err.println("Unable to read from or write to the client: "
                            + e.getMessage());
      }
	 try {
         playerOneOut.close();
         playerOneIn.close();
         playerOneSocket.close();
         socket.close();
      }
      catch (IOException e) {
         System.err.println("Unable to close player one's writer, reader, or socket: "
                            + e.getMessage());
      }
	try {
         playerTwoOut.close();
         playerTwoIn.close();
         playerTwoSocket.close();
         
      }
      catch (IOException e) {
         System.err.println("Unable to close player two's writer, reader, or socket: "
                            + e.getMessage());
      }
	}
	
  public Boolean sendMessage(int playerNumber, String message) {
    if (playerNumber == 1) {
      playerOneOut.println(message);
    } else if (playerNumber == 2) {
      playerTwoOut.println(message);
    } else {
      return false;
    }
    return false;
  }
}
