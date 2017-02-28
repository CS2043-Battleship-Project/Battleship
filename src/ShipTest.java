import java.util.ArrayList;

public class ShipTest {
  public static void main(String[] args) {
    ArrayList<String> parts = new ArrayList<String>();
    parts.add("A1");
    Ship ship = new Ship("FR", parts);
    System.out.println(ship.isValid());

    parts.clear();
    parts.add("A1");
    parts.add("A2");
    parts.add("A3");
    ship = new Ship("FR", parts);
    System.out.println(ship.isValid());

    parts.clear();
    parts.add("A1");
    parts.add("B2");
    ship = new Ship("FR", parts);
    System.out.println(ship.isValid());

    parts.clear();
    parts.add("A11");
    parts.add("A12");
    ship = new Ship("FR", parts);
    System.out.println(ship.isValid());

    parts.clear();
    parts.add("A1");
    parts.add("A2");
    ship = new Ship("FR", parts);
    System.out.println(ship.isValid());
  }
}
