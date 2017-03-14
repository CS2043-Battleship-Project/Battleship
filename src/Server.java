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
                     (playerOneSocket.getOutputStream(), true);

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
                     (playerTwoSocket.getOutputStream(), true);
		String player2Input;


    } catch (IOException e) {
      System.err.println("Cannot read or write player two: " + e.getMessage());

    }


    System.out.println("Player two connected");

    Boolean done = false;
    while (!done) {
      try {
        String playerOneLine = playerOneIn.readLine();
        if (playerOneLine == null) {
          done = true;
        } else {
          String response = GameManager.receiveMessage(1, playerOneLine);
          if (response.charAt(0) == '1') {
            playerOneOut.println(response.replaceFirst("(1|2):", ""));
          } else {
            playerTwoOut.println(response.replaceFirst("(1|2):", ""));
          }

        }

        String playerTwoLine = playerTwoIn.readLine();
        if (playerTwoLine == null) {
          done = true;
        } else {
          String response = GameManager.receiveMessage(2, playerTwoLine);
          if (response.charAt(0) == '1') {
            playerOneOut.println(response.replaceFirst("(1|2):", ""));
          } else {
            playerTwoOut.println(response.replaceFirst("(1|2):", ""));
          }
        }
      } catch (IOException e) {
        System.err.println("Error reading player input: " + e.getMessage());
      }
}

	  try {
       playerOneOut.close();
       playerOneIn.close();
       playerOneSocket.close();
    }
      catch (IOException e) {
         System.err.println("Unable to close player one's resources: "
                            + e.getMessage());
      }
      try {
         playerTwoOut.close();
         playerTwoIn.close();
         playerTwoSocket.close();
      }
        catch (IOException e) {
           System.err.println("Unable to close player two's resources: "
                              + e.getMessage());
        }
}
	}
