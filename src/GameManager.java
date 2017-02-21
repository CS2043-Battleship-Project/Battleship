public class GameManager {
  private Boolean isInSetup;

  public static void main(String[] args) {
    // Port defaults to 314159 if a port isn't passed in on the command line
    Server server = new Server(args.length != 0 ? args[0] : "31415");
    // TODO: main method
  }

  public Boolean receiveMessage(String message) {
    // TODO: receiveMessage
    return true;
  }
}
