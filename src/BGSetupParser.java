import java.util.ArrayList;

public class BGSetupParser {
  Ship parseMessage(String message) {
    // TODO: implement parseMessage
    ArrayList<String> bob =  new ArrayList<String>();
    bob.add("A1");
    bob.add("A2");
    return new Ship("FR", bob);
  }
}
