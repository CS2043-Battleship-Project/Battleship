public class BGSetupParserTest {
  public static void main(String[] args) {
    Ship ship = BGSetupParser.parseMessage("AC A1 A2 A3 A4 A5");
    System.out.println(ship.isValid());
  }
}
