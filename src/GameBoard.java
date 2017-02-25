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
    if (playerNumber == 1) {
      for (int i = 0; i < playerOneShips.size(); i++) {
        if (playerOneShips.get(i).partAt(location)) {
          playerOneShips.get(i).removePart(location);
          if (playerOneShips.get(i).isValid()) {
            return "sunk";
          } else {
            return "hit";
          }
        } else {
          return "miss";
        }
      }
    } else if (playerNumber == 2) {
      for (int i = 0; i < playerTwoShips.size(); i++) {
        if (playerTwoShips.get(i).partAt(location)) {
          playerTwoShips.get(i).removePart(location);
          if (playerTwoShips.get(i).isValid()) {
            return "sunk";
          } else {
            return "hit";
          }
        } else {
          return "miss";
        }
      }
    } else {
      return "err";
    }
    return "err";
  }
}
