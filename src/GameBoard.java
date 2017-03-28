import java.util.ArrayList;
import java.util.Iterator;

public class GameBoard {
  private ArrayList<Ship> playerOneShips;
  private ArrayList<Ship> playerTwoShips;

  public GameBoard() {
	playerOneShips = new ArrayList<Ship>();
	playerTwoShips = new ArrayList<Ship>();
  }

  public Boolean addShip(int playerNumber, Ship ship) {
    System.out.println(ship);
    if (ship == null) {
      return false;
    } else {
      if (playerNumber == 1) {
        return playerOneShips.add(ship);
      } else if (playerNumber == 2) {
        return playerTwoShips.add(ship);
      } else {
        return false;
      }
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
    char row = location.charAt(0);
    char col = location.charAt(1);
    char thrdDig = '\0';
    if (location.length() > 2) {
      thrdDig = location.charAt(2);
    }
    if (row != 'A' && row != 'B' && row != 'C' && row != 'D' && row != 'E' &&
        row != 'F' && row != 'G' && row != 'H' && row != 'I' && row != 'J') {
      return "err";
    }

    if (col != '1' && col != '2' && col != '3' && col != '4' && col != '5' &&
        col != '6' && col != '7' && col != '8' && col != '9' && thrdDig != '0') {
      return "err";
    }
    Boolean miss = false;

    for (int i = 0; i < playerOneShips.size(); i++) {
      System.out.println("Player one ships: " + playerOneShips.get(i));
    }

    for (int i = 0; i < playerTwoShips.size(); i++) {
      System.out.println("Player two ships: " + playerTwoShips.get(i));
    }

    if (playerNumber == 1) {
      for (Iterator<Ship> iterator = playerOneShips.iterator(); iterator.hasNext(); ) {
        Ship playerOneShip = iterator.next();
        if (playerOneShip.partAt(location)) {
          playerOneShip.removePart(location);
          if (playerOneShip.getSize() == 0) {
            String temp = "" + playerOneShip.toString().charAt(0) +
                               playerOneShip.toString().charAt(1) +
                               playerOneShip.toString().charAt(2);
            iterator.remove();
            if (playerOneShips.isEmpty()) {
              temp = playerOneShip.toString().trim();
              return "sunk " + temp + ",win";
            }
            return "sunk " + temp;
          } else {
            return "hit";
          }
        }
        return "miss";
      }
    } else if (playerNumber == 2) {
      for (Iterator<Ship> iterator = playerTwoShips.iterator(); iterator.hasNext(); ) {
        Ship playerTwoShip = iterator.next();
        if (playerTwoShip.partAt(location)) {
          playerTwoShip.removePart(location);
          if (playerTwoShip.getSize() == 0) {
            String temp = "" + playerTwoShip.toString().charAt(0) +
                               playerTwoShip.toString().charAt(1) +
                               playerTwoShip.toString().charAt(2);
            iterator.remove();
            if (playerTwoShips.isEmpty()) {
              temp = playerTwoShip.toString().trim();
              return "sunk " + temp + ",win";
            }
            return "sunk " + temp;
          } else {
            return "hit";
          }
        }
        return "miss";
      }
    }
    return "err";
  }
}
