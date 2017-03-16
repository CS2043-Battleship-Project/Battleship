public class GameManager {
  private static Boolean isInSetup;
  private static GameBoard board;
  private static Server server;

  public static void main(String[] args) {
    // Port defaults to 314159 if a port isn't passed in on the command line

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
      String result = board.attack((playerNumber == 1 ? 2 : 1), message);
      return (playerNumber == 1 ? 2 : 1) + ":" + message + ',' + result;
    }
  }

  public static void setIsInSetup(Boolean _isInSetup) {
    isInSetup = _isInSetup;
  }
}
