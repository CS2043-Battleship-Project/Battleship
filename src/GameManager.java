public class GameManager {
  private Boolean isInSetup;
  private GameBoard board;
  private static Server server;

  public static void main(String[] args) {
    // Port defaults to 314159 if a port isn't passed in on the command line
    server = new Server(args.length != 0 ? args[0] : "31415");
    // TODO: main method
  }

  public Boolean receiveMessage(int playerNumber, String message) {
    if (isInSetup) {
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
        server.sendMessage(playerNumber, "ack," + playerNumber);
      } else {
        server.sendMessage(playerNumber, "err");
      }

    } else {
      String result = board.attack(playerNumber, message);
      server.sendMessage(playerNumber, result);
      server.sendMessage(playerNumber == 1 ? 2 : 1, message + ',' + result);
    }
    return true;
  }
}
