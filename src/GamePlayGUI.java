import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Toolkit;

public class GamePlayGUI extends JFrame
{
  private static JFrame frame;
  private static Toolkit toolkit;
  private static JButton[][] attackLocation;
  private static JButton[][] shipLocation;
  private static JButton exitButton;
  private static JLabel instructions;
  private static ActionListener listener;

  public GamePlayGUI()
  {
    frame  = new JFrame();
    frame.setSize(800,800);
    frame.setTitle("BattleShip");
    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    frame.setLayout(new GridLayout(3, 1));
    frame.setVisible(true);
    toolkit = Toolkit.getDefaultToolkit();

    listener = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
          String text = ((JButton)e.getSource()).getText();
          JOptionPane.showMessageDialog(null, text);
        }
      }
    };

    shipLocation = new JButton[10][10];
    attackLocation = new JButton[10][10];
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        attackLocation[i][j] = new JButton((char)(i + 65) + "" + (j + 1));
        shipLocation[i][j] = new JButton((char)(i + 65) + "" + (j + 1));
        attackLocation[i][j].addActionListener(listener);
      }
    }
  }

  public static void createComponents()
  {
    instructions = new JLabel("Please place your Aircraft Carrier", SwingConstants.CENTER);
    instructions.setPreferredSize(new Dimension(120, 20));

    exitButton = new JButton("Exit");

    JPanel attackButtonPanel = new JPanel(new GridLayout(10, 10));
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        attackButtonPanel.add(attackLocation[i][j]);
      }
    }

    JPanel shipButtonPanel = new JPanel(new GridLayout(10, 10));
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        shipButtonPanel.add(shipLocation[i][j]);
      }
    }

    JPanel topPanel = new JPanel();
    topPanel.add(shipButtonPanel);

    JPanel bottomPanel = new JPanel();
    bottomPanel.add(exitButton);
    bottomPanel.add(attackButtonPanel);

    frame.getContentPane().add(topPanel);
    frame.getContentPane().add(instructions);
    frame.getContentPane().add(bottomPanel);
  }

  public static void main(String[] args)
  {
    GamePlayGUI gamePlayGUI = new GamePlayGUI();
    gamePlayGUI.createComponents();
    gamePlayGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
