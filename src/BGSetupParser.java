import java.util.ArrayList;

public class BGSetupParser {
  public static Ship parseMessage(String message) {
    ArrayList<String> parts = new ArrayList<String>();
    String[] tokens = message.split(" ");

    if (tokens[0].equals("AC")) {
      if (tokens.length != 6) {
        return null;
      } else {
        for (int i = 1; i < tokens.length; i++) {
          parts.add(tokens[i]);
        }
      }
    } else if (tokens[0].equals("CR")) {
      if (tokens.length != 5) {
        return null;
      } else {
        for (int i = 1; i < tokens.length; i++) {
          parts.add(tokens[i]);
        }
      }
    } else if (tokens[0].equals("SB")) {
      if (tokens.length != 4) {
        return null;
      } else {
        for (int i = 1; i < tokens.length; i++) {
          parts.add(tokens[i]);
        }
      }
    } else if (tokens[0].equals("FR")) {
      if (tokens.length != 3) {
        return null;
      } else {
        for (int i = 1; i < tokens.length; i++) {
          parts.add(tokens[i]);
        }
      }
    } else {
      return null;
    }

    Ship temp = new Ship(tokens[0], parts);
    if (temp.isValid()) {
      return temp;
    } else {
      return null;
    }
  }
}
