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
    // TODO: implement valid logic
    return true;
  }

  public Boolean partAt(String location) {
    return parts.contains(location);
  }
}
