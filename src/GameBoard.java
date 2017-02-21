import java.util.ArrayList;

public class GameBoard {
  private ArrayList<Ship> playerOneShips;
  private ArrayList<Ship> playerTwoShips;

  public GameBoard() {

  }

  public Boolean addShip(int playerNumber, Ship ship) {
    if (playerNumber == 1) {
      return playerOneShips.add(ship);
    } else if (playerNumber == 2) {
      return playerTwoShips.add(ship);
    } else {
      return false;
    }
  }

  public Boolean removeShip(int playerNumber, Ship ship) {
    if (playerNumber == 1) {
      return playerOneShips.remove(ship);
    } else if (playerNumber == 2) {
      return playerTwoShips.remove(ship);
    } else {
      return false;
    }
  }

  public String attack(int playerNumber, String location) {
    // TODO: implement attack
    return "miss";
  }
}
