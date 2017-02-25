public class GameManager {
  private Boolean isInSetup;
  private GameBoard board;

  public static void main(String[] args) {
    // Port defaults to 314159 if a port isn't passed in on the command line
    Server server = new Server(args.length != 0 ? args[0] : "31415");
    // TODO: main method
  }

  public Boolean receiveMessage(int playerNumber, String message) {
    if (isInSetup) {
      String[] unparsedShips = message.split(",");

      for (int i = 0; i < unparsedShips.length; i++) {
        //board.addS
      }
    }
    return true;
  }
}
