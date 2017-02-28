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

    if (type != "AC" && type != "CR" && type != "SB" && type != "FR") {
      return false;
    }

    if (type == "AC" && parts.size() != 5) {
      return false;
    }

    if (type == "CR" && parts.size() != 4) {
      return false;
    }

    if (type == "SB" && parts.size() != 3) {
      return false;
    }

    if (type == "FR" && parts.size() != 2) {
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
}
