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

    Boolean doneSignin = false;
    Boolean doneSetup = false;
    Boolean playerOneSuccessfulSignin = false;
    Boolean playerTwoSuccessfulSignin = false;
    Boolean playerOneSuccessful = false;
    Boolean playerTwoSuccessful = false;

    while (!playerOneSuccessfulSignin) {
      try {
        String playerOneLine = playerOneIn.readLine();
        System.out.println(playerOneLine);
        if (playerOneLine == null) {
          doneSignin = true;
        } else {
          String message = GameManager.receiveMessage(1, playerOneLine);
          String[] response = message.replaceFirst("(1|2):", "").split(",");
          if (response.length > 1 && (response[1].equals("Unknown User") ||
              response[1].equals("Duplicate User Name"))) {
            playerOneOut.println(message);
            continue;
          } else {
            playerOneSuccessfulSignin = true;
            playerOneOut.println(message);
          }
        }
      } catch (IOException e) {
        System.err.println("Error reading player input: " + e.getMessage());
      }
    }

    while (!playerTwoSuccessfulSignin) {
      try {
        String playerTwoLine = playerTwoIn.readLine();
        System.out.println(playerTwoLine);
        if (playerTwoLine == null) {
          doneSignin = true;
        } else {
          String message = GameManager.receiveMessage(2, playerTwoLine);
          String[] response = message.replaceFirst("(1|2):", "").split(",");
          if (response.length > 1 && (response[1].equals("Unknown User") ||
              response[1].equals("Duplicate User Name"))) {
            playerTwoOut.println(message);
            continue;
          } else {
            playerTwoSuccessfulSignin = true;
            playerTwoOut.println(message);
          }
        }
      } catch (IOException e) {
        System.err.println("Error reading player input: " + e.getMessage());
      }
    }

    GameManager.setIsInSignin(false);
    doneSignin = true;
    System.out.println("Hey we're here now");

    while (!doneSetup) {
      try {
        if (!playerOneSuccessful) {
          String playerOneLine = playerOneIn.readLine();
          System.out.println(playerOneLine);
          if (playerOneLine == null) {
            doneSetup = true;
          } else {
            String message = GameManager.receiveMessage(1, playerOneLine);
            System.out.println(message);
            String response = message.replaceFirst("(1|2):", "");
            if (message.charAt(0) == '1') {
              if (response.startsWith("ack")) {
                playerOneSuccessful = true;
              }
              playerOneOut.println(response);
            } else {
              playerTwoOut.println(response);
            }

          }
        }

        if (!playerTwoSuccessful) {
          String playerTwoLine = playerTwoIn.readLine();
          System.out.println(playerTwoLine);
          if (playerTwoLine == null) {
            doneSetup = true;
          } else {
            String message = GameManager.receiveMessage(2, playerTwoLine);
            String response = message.replaceFirst("(1|2):", "");
            System.out.println(response);
            if (message.charAt(0) == '1') {
              playerOneOut.println(response.replaceFirst("(1|2):", ""));
            } else {
              if (response.startsWith("ack")) {
                playerTwoSuccessful = true;
              }
              playerTwoOut.println(response.replaceFirst("(1|2):", ""));
            }
          }
        }
      } catch (IOException e) {
        System.err.println("Error reading player input: " + e.getMessage());
      }

      if (playerOneSuccessful && playerTwoSuccessful) {
        GameManager.setIsInSetup(false);
        playerOneOut.println("ok");
        doneSetup = true;
      }
    }

    Boolean doneGame = false;
    while (!doneGame) {
      try {
          String playerOneLine = playerOneIn.readLine();
          System.out.println("Player one input: " + playerOneLine);
          if (playerOneLine == null) {
            doneGame = true;
          } else {
            String message = GameManager.receiveMessage(1, playerOneLine);

            System.out.println("Player one messsage: " + message);
            String[] response = message.replaceFirst("(1|2):", "").split(",");
            if (response.length > 1 && response[1].equals("err")) {
              playerOneOut.println(response[1]);
              continue;
            }
            if (response.length > 2) {
              playerOneOut.println(response[1] + ",win");
              playerTwoOut.println(response[0] + ',' + response[1] + ',' + response[2]);
            } else {
              playerOneOut.println(response[1]);
              playerTwoOut.println(response[0] + ',' + response[1]);
            }
          }


          String playerTwoLine = playerTwoIn.readLine();
          System.out.println(playerTwoLine);
          if (playerTwoLine == null) {
            doneGame = true;
          } else {
            String message = GameManager.receiveMessage(2, playerTwoLine);
            String[] response = message.replaceFirst("(1|2):", "").split(",");
            if (response.length > 1 && response[1].equals("err")) {
              playerTwoOut.println(response[1]);
              continue;
            }
            if (response.length > 2) {
              playerTwoOut.println(response[1] + ",win");
              playerOneOut.println(response[0] + ',' + response[1] + ',' + response[2]);
            } else {
              playerTwoOut.println(response[1]);
              playerOneOut.println(response[0] + ',' + response[1]);
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
