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

  public Boolean receiveMessage(int playerNumber, String message) {
    if (isInSetup == true) {
      String[] unparsedShips = message.split(",");

      boolean success = false;

      for (int i = 0; i < unparsedShips.length; i++) {
        success = false;
        if (!board.addShip(playerNumber, BGSetupParser.parseMessage(unparsedShips[i]))) {
          break;
        }
        success = true;
      }

      if (success) {
        if (server != null) {
          server.sendMessage(playerNumber, "ack," + playerNumber);
        }
      } else {
        if (server != null) {
          server.sendMessage(playerNumber, "err");
        }
      }

    } else {
      String result = board.attack(playerNumber, message);
      server.sendMessage(playerNumber, result);
      server.sendMessage(playerNumber == 1 ? 2 : 1, message + ',' + result);
    }
    System.out.println("It works");
    return true;
  }
}
