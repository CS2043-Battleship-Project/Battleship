import java.util.ArrayList;

public class Ship {
  private String type;
  private ArrayList<String> parts;

  public Ship(String type, ArrayList<String> parts) {
    this.type = type;
    this.parts = parts;
  }

  public Boolean removePart(String location) {
    return parts.remove(location);
  }

  public Boolean isValid() {
    if (parts.size() == 0) {
      return false;
    }

    if (!type.equals("AC") && !type.equals("CR") && !type.equals("SB") &&
        !type.equals("FR")) {
      return false;
    }

    if (type.equals("AC") && parts.size() != 5) {
      return false;
    }

    if (type.equals("CR") && parts.size() != 4) {
      return false;
    }

    if (type.equals("SB") && parts.size() != 3) {
      return false;
    }

    if (type.equals("FR") && parts.size() != 2) {
      return false;
    }

    for (int i = 0; i < parts.size(); i++) {
      char row = parts.get(i).charAt(0);

      if (row != 'A' && row != 'B' && row != 'C' && row != 'D' && row != 'E' &&
          row != 'F' && row != 'G' && row != 'H' && row != 'I' && row != 'J') {
        return false;
      }

      char col = parts.get(i).charAt(1);

      if (col != '1' && col != '2' && col != '3' && col != '4' && col != '5' &&
          col != '6' && col != '7' && col != '8' && col != '9') {
        return false;
      }

      if (parts.get(i).length() > 2) {
        if (parts.get(i).charAt(2) == '1') {
          return false;
        }
      }
    }

    for (int i = 0; i < parts.size(); i++) {
      if (parts.get(0).charAt(0) != parts.get(i).charAt(0) && parts.get(0).charAt(1) != parts.get(i).charAt(1)) {
        return false;
      }
    }

    return true;
  }

  public Boolean partAt(String location) {
    return parts.contains(location);
  }

  public int getSize() {
    return parts.size();
  }

  public String toString() {
    String temp = type + " ";
    for (int i = 0; i < parts.size(); i++) {
      temp += parts.get(i) + " ";
    }
    return temp;
  }
}
