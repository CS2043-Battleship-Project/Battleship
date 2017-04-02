import java.util.ArrayList;

public class GameManager {
  private static Boolean isInSignin;
  private static Boolean isInSetup;
  private static GameBoard board;
  private static Server server;
  private static ArrayList<User> users;
  private static Client client;
  private static MainMenu mainMenu;


  public static void main(String[] args) {
    // Port defaults to 31415 if a port isn't passed in on the command line

   // TODO: main method
    isInSignin = true;
    isInSetup = true;
    board = new GameBoard();
    users = new ArrayList<User>();
		server = new Server(args.length != 0 ? args[0] : "31415");
		
  }

  public static String receiveMessage(int playerNumber, String message) {
    if (isInSignin == true) {
      String[] signinMessage = message.split(",");
      if (signinMessage[0].equals("N")) {
        Boolean found = false;
        for (int i = 0; i < users.size(); i++) {
          if (users.get(i).getName().equals(signinMessage[1])) {
            found = true;
          }
        }
        if (found) {
          return "err,Duplicate User Name";
        } else {
          users.add(new User(signinMessage[1]));
          return "ack";
        }
      } else {
        Boolean found = false;
        for (int i = 0; i < users.size(); i++) {
          if (users.get(i).getName().equals(signinMessage[1])) {
            found = true;
          }
        }
        if (!found) {
          return "err,Unknown User";
        } else {
          return "ack";
        }
      }
    }
    else if (isInSetup == true) {
      String[] unparsedShips = message.split(",");

      boolean success = true;

      for (int i = 0; i < unparsedShips.length; i++) {
        System.out.println("unparsedShips[" + i + "] : " + unparsedShips[i]);
        if (!board.addShip(playerNumber,
                           BGSetupParser.parseMessage(unparsedShips[i]))) {
                             success = false;
          break;
        }

      }

      if (success) {
          return playerNumber + ":" + "ack," + playerNumber;
      } else {
          return playerNumber + ":" + "err";
      }

    } else {
      String temp = board.attack((playerNumber == 1 ? 2 : 1), message);
      System.out.println("GameManager: " + temp);
      if (temp == "err") {
        return playerNumber + ":" + temp;
      }
      String[] result = temp.split(",");
      if (result.length > 1 && result[1].equals("win")) {
        System.out.println((playerNumber == 1 ? 2 : 1) + ":" + message + ','
                                                       + result[0] + ",loss");
        return (playerNumber == 1 ? 2 : 1) + ":" + message + ','
                                           + result[0] + ",loss";
      }
      System.out.println("GM: " + (playerNumber == 1 ? 2 : 1) + ":" + message + ',' + result[0]);
      return (playerNumber == 1 ? 2 : 1) + ":" + message + ',' + result[0];
    }
  }

  public static void setIsInSetup(Boolean _isInSetup) {
    isInSetup = _isInSetup;
  }

  public static void setIsInSignin(Boolean _isInSignin) {
    isInSignin = _isInSignin;
  }
}
