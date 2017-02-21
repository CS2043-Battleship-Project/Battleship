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
      System.err.println("Cannont read or write player one: " + e.getMessage());
    }

    try {
      playerTwoIn = new BufferedReader
                    (new InputStreamReader(playerTwoSocket.getInputStream()));
      playerTwoOut = new PrintWriter
                     (playerTwoSocket.getOutputStream());
    } catch (IOException e) {
      System.err.println("Cannont read or write player two: " + e.getMessage());
    }


    System.out.println("Player one connected");

    try {
      playerTwoSocket = socket.accept();
    } catch (IOException e) {
      System.err.println("Accepting player two failed: " + e.getMessage());
    }

    System.out.println("Player two connected");
  }

  public Boolean sendMessage(String player, String message) {
    // TODO: server send stuff
    return true;
  }
}
