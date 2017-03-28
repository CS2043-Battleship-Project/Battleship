import java.util.ArrayList;

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
    if (playerNumber == 1) {
      for (int i = 0; i < playerOneShips.size(); i++) {
        System.out.println(playerOneShips.get(i));
        if (playerOneShips.get(i).partAt(location)) {
          playerOneShips.get(i).removePart(location);
          if (playerOneShips.get(i).getSize() == 0) {
            if (playerOneShips.size() == 0) {
              return "sunk " + playerOneShips.get(i).toString() + ",win";
            }
            return "sunk " + playerOneShips.get(i).toString();
          } else {
            return "hit";
          }
        }
        miss = true;
      }
    } else if (playerNumber == 2) {
      for (int i = 0; i < playerTwoShips.size(); i++) {
        System.out.println(playerTwoShips.get(i));
        if (playerTwoShips.get(i).partAt(location)) {
          playerTwoShips.get(i).removePart(location);
          if (playerTwoShips.get(i).getSize() == 0) {
            if (playerTwoShips.size() == 0) {
              return "sunk " + playerOneShips.get(i).toString() + ",win";
            }
            return "sunk " + playerOneShips.get(i).toString();
          } else {
            return "hit";
          }
        }
        miss = true;
      }
    } else {
      return "err";
    }
    if (miss) {
      return "miss";
    } else {
      return "err";
    }
  }
}
