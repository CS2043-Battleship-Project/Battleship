public class GameManager {
  private static Boolean isInSetup;
  private static GameBoard board;
  private static Server server;

  public static void main(String[] args) {
    // Port defaults to 31415 if a port isn't passed in on the command line

   // TODO: main method
    isInSetup = true;
    board = new GameBoard();
		server = new Server(args.length != 0 ? args[0] : "31415");

  }

  public static String receiveMessage(int playerNumber, String message) {
    if (isInSetup == true) {
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
      System.out.println("GameManager: " + message);
      if (temp == "err") {
        return playerNumber + ":" + temp;
      }
      String[] result = temp.split(",");
      if (result.length > 1 && result[1] == "win") {
        return (playerNumber == 1 ? 2 : 1) + ":" + message + ','
                                           + result[0] + ",loss";
      }
      return (playerNumber == 1 ? 2 : 1) + ":" + message + ',' + result[0];
    }
  }

  public static void setIsInSetup(Boolean _isInSetup) {
    isInSetup = _isInSetup;
  }
}
