public class User {
  private String name;
  private int wins;
  private int losses;

  public User(String name) {
    this.name = name;
  }

  public void win() {
    wins++;
  }

  public void lose() {
    losses++;
  }

  public int getScore() {
    return wins * 10 + losses * -10;
  }

  public String getName() {
    return name;
  }
}
