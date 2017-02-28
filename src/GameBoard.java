import java.util.ArrayList;

public class GameBoard {
  private ArrayList<Ship> playerOneShips;
  private ArrayList<Ship> playerTwoShips;

  public GameBoard() {
    playerOneShips = new ArrayList<Ship>();
    playerTwoShips = new ArrayList<Ship>();
  }

  public Boolean addShip(int playerNumber, Ship ship) {
    if (playerNumber == 1) {
      for (int i = 0; i < playerOneShips.size(); i++) {
        if (playerOneShips.get(i).partAt("A1") && ship.partAt("A1") ||
            playerOneShips[i].partAt("A2") && ship.partAt("A2") ||
            playerOneShips[i].partAt("A3") && ship.partAt("A3") ||
            playerOneShips[i].partAt("A4") && ship.partAt("A4") ||
            playerOneShips[i].partAt("A5") && ship.partAt("A5") ||
            playerOneShips[i].partAt("A6") && ship.partAt("A6") ||
            playerOneShips[i].partAt("A7") && ship.partAt("A7") ||
            playerOneShips[i].partAt("A8") && ship.partAt("A8") ||
            playerOneShips[i].partAt("A9") && ship.partAt("A9") ||
            playerOneShips[i].partAt("A10") && ship.partAt("A10") ||
            playerOneShips[i].partAt("B1") && ship.partAt("B1") ||
            playerOneShips[i].partAt("B2") && ship.partAt("B2") ||
            playerOneShips[i].partAt("B3") && ship.partAt("B3") ||
            playerOneShips[i].partAt("B4") && ship.partAt("B4") ||
            playerOneShips[i].partAt("B5") && ship.partAt("B5") ||
            playerOneShips[i].partAt("B6") && ship.partAt("B6") ||
            playerOneShips[i].partAt("B7") && ship.partAt("B7") ||
            playerOneShips[i].partAt("B8") && ship.partAt("B8") ||
            playerOneShips[i].partAt("B9") && ship.partAt("B9") ||
            playerOneShips[i].partAt("B10") && ship.partAt("B10") ||
            playerOneShips[i].partAt("C1") && ship.partAt("C1") ||
            playerOneShips[i].partAt("C2") && ship.partAt("C2") ||
            playerOneShips[i].partAt("C3") && ship.partAt("C3") ||
            playerOneShips[i].partAt("C4") && ship.partAt("C4") ||
            playerOneShips[i].partAt("C5") && ship.partAt("C5") ||
            playerOneShips[i].partAt("C6") && ship.partAt("C6") ||
            playerOneShips[i].partAt("C7") && ship.partAt("C7") ||
            playerOneShips[i].partAt("C8") && ship.partAt("C8") ||
            playerOneShips[i].partAt("C9") && ship.partAt("C9") ||
            playerOneShips[i].partAt("C10") && ship.partAt("C10") ||
            playerOneShips[i].partAt("D1") && ship.partAt("D1") ||
            playerOneShips[i].partAt("D2") && ship.partAt("D2") ||
            playerOneShips[i].partAt("D3") && ship.partAt("D3") ||
            playerOneShips[i].partAt("D4") && ship.partAt("D4") ||
            playerOneShips[i].partAt("D5") && ship.partAt("D5") ||
            playerOneShips[i].partAt("D6") && ship.partAt("D6") ||
            playerOneShips[i].partAt("D7") && ship.partAt("D7") ||
            playerOneShips[i].partAt("D8") && ship.partAt("D8") ||
            playerOneShips[i].partAt("D9") && ship.partAt("D9") ||
            playerOneShips[i].partAt("D10") && ship.partAt("D10") ||
            playerOneShips[i].partAt("E1") && ship.partAt("E1") ||
            playerOneShips[i].partAt("E2") && ship.partAt("E2") ||
            playerOneShips[i].partAt("E3") && ship.partAt("E3") ||
            playerOneShips[i].partAt("E4") && ship.partAt("E4") ||
            playerOneShips[i].partAt("E5") && ship.partAt("E5") ||
            playerOneShips[i].partAt("E6") && ship.partAt("E6") ||
            playerOneShips[i].partAt("E7") && ship.partAt("E7") ||
            playerOneShips[i].partAt("E8") && ship.partAt("E8") ||
            playerOneShips[i].partAt("E9") && ship.partAt("E9") ||
            playerOneShips[i].partAt("E10") && ship.partAt("E10") ||
            playerOneShips[i].partAt("F1") && ship.partAt("F1") ||
            playerOneShips[i].partAt("F2") && ship.partAt("F2") ||
            playerOneShips[i].partAt("F3") && ship.partAt("F3") ||
            playerOneShips[i].partAt("F4") && ship.partAt("F4") ||
            playerOneShips[i].partAt("F5") && ship.partAt("F5") ||
            playerOneShips[i].partAt("F6") && ship.partAt("F6") ||
            playerOneShips[i].partAt("F7") && ship.partAt("F7") ||
            playerOneShips[i].partAt("F8") && ship.partAt("F8") ||
            playerOneShips[i].partAt("F9") && ship.partAt("F9") ||
            playerOneShips[i].partAt("F10") && ship.partAt("F10") ||
            playerOneShips[i].partAt("G1") && ship.partAt("G1") ||
            playerOneShips[i].partAt("G2") && ship.partAt("G2") ||
            playerOneShips[i].partAt("G3") && ship.partAt("G3") ||
            playerOneShips[i].partAt("G4") && ship.partAt("G4") ||
            playerOneShips[i].partAt("G5") && ship.partAt("G5") ||
            playerOneShips[i].partAt("G6") && ship.partAt("G6") ||
            playerOneShips[i].partAt("G7") && ship.partAt("G7") ||
            playerOneShips[i].partAt("G8") && ship.partAt("G8") ||
            playerOneShips[i].partAt("G9") && ship.partAt("G9") ||
            playerOneShips[i].partAt("G10") && ship.partAt("G10") ||
            playerOneShips[i].partAt("H1") && ship.partAt("H1") ||
            playerOneShips[i].partAt("H2") && ship.partAt("H2") ||
            playerOneShips[i].partAt("H3") && ship.partAt("H3") ||
            playerOneShips[i].partAt("H4") && ship.partAt("H4") ||
            playerOneShips[i].partAt("H5") && ship.partAt("H5") ||
            playerOneShips[i].partAt("H6") && ship.partAt("H6") ||
            playerOneShips[i].partAt("H7") && ship.partAt("H7") ||
            playerOneShips[i].partAt("H8") && ship.partAt("H8") ||
            playerOneShips[i].partAt("H9") && ship.partAt("H9") ||
            playerOneShips[i].partAt("H10") && ship.partAt("H10") ||
            playerOneShips[i].partAt("I1") && ship.partAt("I1") ||
            playerOneShips[i].partAt("I2") && ship.partAt("I2") ||
            playerOneShips[i].partAt("I3") && ship.partAt("I3") ||
            playerOneShips[i].partAt("I4") && ship.partAt("I4") ||
            playerOneShips[i].partAt("I5") && ship.partAt("I5") ||
            playerOneShips[i].partAt("I6") && ship.partAt("I6") ||
            playerOneShips[i].partAt("I7") && ship.partAt("I7") ||
            playerOneShips[i].partAt("I8") && ship.partAt("I8") ||
            playerOneShips[i].partAt("I9") && ship.partAt("I9") ||
            playerOneShips[i].partAt("I10") && ship.partAt("I10") ||
            playerOneShips[i].partAt("J1") && ship.partAt("J1") ||
            playerOneShips[i].partAt("J2") && ship.partAt("J2") ||
            playerOneShips[i].partAt("J3") && ship.partAt("J3") ||
            playerOneShips[i].partAt("J4") && ship.partAt("J4") ||
            playerOneShips[i].partAt("J5") && ship.partAt("J5") ||
            playerOneShips[i].partAt("J6") && ship.partAt("J6") ||
            playerOneShips[i].partAt("J7") && ship.partAt("J7") ||
            playerOneShips[i].partAt("J8") && ship.partAt("J8") ||
            playerOneShips[i].partAt("J9") && ship.partAt("J9") ||
            playerOneShips[i].partAt("J10") && ship.partAt("J10")) {
          return false;
        }
      }
      return playerOneShips.add(ship);
    } else if (playerNumber == 2) {
      for (int i = 0; i < playerTwoShips.size(); i++) {
        if (playerTwoShips[i].partAt("A1") && ship.partAt("A1") ||
            playerTwoShips[i].partAt("A2") && ship.partAt("A2") ||
            playerTwoShips[i].partAt("A3") && ship.partAt("A3") ||
            playerTwoShips[i].partAt("A4") && ship.partAt("A4") ||
            playerTwoShips[i].partAt("A5") && ship.partAt("A5") ||
            playerTwoShips[i].partAt("A6") && ship.partAt("A6") ||
            playerTwoShips[i].partAt("A7") && ship.partAt("A7") ||
            playerTwoShips[i].partAt("A8") && ship.partAt("A8") ||
            playerTwoShips[i].partAt("A9") && ship.partAt("A9") ||
            playerTwoShips[i].partAt("A10") && ship.partAt("A10") ||
            playerTwoShips[i].partAt("B1") && ship.partAt("B1") ||
            playerTwoShips[i].partAt("B2") && ship.partAt("B2") ||
            playerTwoShips[i].partAt("B3") && ship.partAt("B3") ||
            playerTwoShips[i].partAt("B4") && ship.partAt("B4") ||
            playerTwoShips[i].partAt("B5") && ship.partAt("B5") ||
            playerTwoShips[i].partAt("B6") && ship.partAt("B6") ||
            playerTwoShips[i].partAt("B7") && ship.partAt("B7") ||
            playerTwoShips[i].partAt("B8") && ship.partAt("B8") ||
            playerTwoShips[i].partAt("B9") && ship.partAt("B9") ||
            playerTwoShips[i].partAt("B10") && ship.partAt("B10") ||
            playerTwoShips[i].partAt("C1") && ship.partAt("C1") ||
            playerTwoShips[i].partAt("C2") && ship.partAt("C2") ||
            playerTwoShips[i].partAt("C3") && ship.partAt("C3") ||
            playerTwoShips[i].partAt("C4") && ship.partAt("C4") ||
            playerTwoShips[i].partAt("C5") && ship.partAt("C5") ||
            playerTwoShips[i].partAt("C6") && ship.partAt("C6") ||
            playerTwoShips[i].partAt("C7") && ship.partAt("C7") ||
            playerTwoShips[i].partAt("C8") && ship.partAt("C8") ||
            playerTwoShips[i].partAt("C9") && ship.partAt("C9") ||
            playerTwoShips[i].partAt("C10") && ship.partAt("C10") ||
            playerTwoShips[i].partAt("D1") && ship.partAt("D1") ||
            playerTwoShips[i].partAt("D2") && ship.partAt("D2") ||
            playerTwoShips[i].partAt("D3") && ship.partAt("D3") ||
            playerTwoShips[i].partAt("D4") && ship.partAt("D4") ||
            playerTwoShips[i].partAt("D5") && ship.partAt("D5") ||
            playerTwoShips[i].partAt("D6") && ship.partAt("D6") ||
            playerTwoShips[i].partAt("D7") && ship.partAt("D7") ||
            playerTwoShips[i].partAt("D8") && ship.partAt("D8") ||
            playerTwoShips[i].partAt("D9") && ship.partAt("D9") ||
            playerTwoShips[i].partAt("D10") && ship.partAt("D10") ||
            playerTwoShips[i].partAt("E1") && ship.partAt("E1") ||
            playerTwoShips[i].partAt("E2") && ship.partAt("E2") ||
            playerTwoShips[i].partAt("E3") && ship.partAt("E3") ||
            playerTwoShips[i].partAt("E4") && ship.partAt("E4") ||
            playerTwoShips[i].partAt("E5") && ship.partAt("E5") ||
            playerTwoShips[i].partAt("E6") && ship.partAt("E6") ||
            playerTwoShips[i].partAt("E7") && ship.partAt("E7") ||
            playerTwoShips[i].partAt("E8") && ship.partAt("E8") ||
            playerTwoShips[i].partAt("E9") && ship.partAt("E9") ||
            playerTwoShips[i].partAt("E10") && ship.partAt("E10") ||
            playerTwoShips[i].partAt("F1") && ship.partAt("F1") ||
            playerTwoShips[i].partAt("F2") && ship.partAt("F2") ||
            playerTwoShips[i].partAt("F3") && ship.partAt("F3") ||
            playerTwoShips[i].partAt("F4") && ship.partAt("F4") ||
            playerTwoShips[i].partAt("F5") && ship.partAt("F5") ||
            playerTwoShips[i].partAt("F6") && ship.partAt("F6") ||
            playerTwoShips[i].partAt("F7") && ship.partAt("F7") ||
            playerTwoShips[i].partAt("F8") && ship.partAt("F8") ||
            playerTwoShips[i].partAt("F9") && ship.partAt("F9") ||
            playerTwoShips[i].partAt("F10") && ship.partAt("F10") ||
            playerTwoShips[i].partAt("G1") && ship.partAt("G1") ||
            playerTwoShips[i].partAt("G2") && ship.partAt("G2") ||
            playerTwoShips[i].partAt("G3") && ship.partAt("G3") ||
            playerTwoShips[i].partAt("G4") && ship.partAt("G4") ||
            playerTwoShips[i].partAt("G5") && ship.partAt("G5") ||
            playerTwoShips[i].partAt("G6") && ship.partAt("G6") ||
            playerTwoShips[i].partAt("G7") && ship.partAt("G7") ||
            playerTwoShips[i].partAt("G8") && ship.partAt("G8") ||
            playerTwoShips[i].partAt("G9") && ship.partAt("G9") ||
            playerTwoShips[i].partAt("G10") && ship.partAt("G10") ||
            playerTwoShips[i].partAt("H1") && ship.partAt("H1") ||
            playerTwoShips[i].partAt("H2") && ship.partAt("H2") ||
            playerTwoShips[i].partAt("H3") && ship.partAt("H3") ||
            playerTwoShips[i].partAt("H4") && ship.partAt("H4") ||
            playerTwoShips[i].partAt("H5") && ship.partAt("H5") ||
            playerTwoShips[i].partAt("H6") && ship.partAt("H6") ||
            playerTwoShips[i].partAt("H7") && ship.partAt("H7") ||
            playerTwoShips[i].partAt("H8") && ship.partAt("H8") ||
            playerTwoShips[i].partAt("H9") && ship.partAt("H9") ||
            playerTwoShips[i].partAt("H10") && ship.partAt("H10") ||
            playerTwoShips[i].partAt("I1") && ship.partAt("I1") ||
            playerTwoShips[i].partAt("I2") && ship.partAt("I2") ||
            playerTwoShips[i].partAt("I3") && ship.partAt("I3") ||
            playerTwoShips[i].partAt("I4") && ship.partAt("I4") ||
            playerTwoShips[i].partAt("I5") && ship.partAt("I5") ||
            playerTwoShips[i].partAt("I6") && ship.partAt("I6") ||
            playerTwoShips[i].partAt("I7") && ship.partAt("I7") ||
            playerTwoShips[i].partAt("I8") && ship.partAt("I8") ||
            playerTwoShips[i].partAt("I9") && ship.partAt("I9") ||
            playerTwoShips[i].partAt("I10") && ship.partAt("I10") ||
            playerTwoShips[i].partAt("J1") && ship.partAt("J1") ||
            playerTwoShips[i].partAt("J2") && ship.partAt("J2") ||
            playerTwoShips[i].partAt("J3") && ship.partAt("J3") ||
            playerTwoShips[i].partAt("J4") && ship.partAt("J4") ||
            playerTwoShips[i].partAt("J5") && ship.partAt("J5") ||
            playerTwoShips[i].partAt("J6") && ship.partAt("J6") ||
            playerTwoShips[i].partAt("J7") && ship.partAt("J7") ||
            playerTwoShips[i].partAt("J8") && ship.partAt("J8") ||
            playerTwoShips[i].partAt("J9") && ship.partAt("J9") ||
            playerTwoShips[i].partAt("J10") && ship.partAt("J10")) {
          return false;
        }
      }
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
            if (playerOneShips.size() == 0) {
              return "sunk " + playerOneShips.get(i).getType() + ",win";
            } else {
              return "sunk " + playerOneShips.get(i).getType();
            }
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
            if (playerOneShips.size() == 0) {
              return "sunk " + playerTwoShips.get(i).getType() + ",win";
            } else {
              return "sunk " + playerTwoShips.get(i).getType();
            }
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
