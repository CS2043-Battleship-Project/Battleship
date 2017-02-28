import java.util.ArrayList;

public class GameBoardTest {
  public static void main(String[] args) {
    GameBoard board = new GameBoard();

    ArrayList<String> parts = new ArrayList<String>();
    parts.add("A1");
    parts.add("A2");
    Ship ship = new Ship("FR", parts);
    board.addShip(1, ship);

    parts.clear();
    parts.add("A3");
    parts.add("A4");
    ship = new Ship("FR", parts);
    System.out.println(board.addShip(1, ship));

    GameBoard board2 = new GameBoard();

    parts.clear();
    parts.add("A1");
    parts.add("A2");
    Ship ship2 = new Ship("FR", parts);
    board2.addShip(1, ship2);

    parts.clear();
    parts.add("A2");
    parts.add("A3");
    Ship ship3 = new Ship("FR", parts);
    System.out.println(board2.addShip(1, ship3));
  }
}
