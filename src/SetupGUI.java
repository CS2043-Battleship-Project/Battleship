import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Toolkit;

public class SetupGUI extends JFrame
{
  private JFrame frame;
  private Toolkit toolkit;
  private JButton[][] location;
  private JButton exitButton;
  private ActionListener listener;

  public SetupGUI()
  {
    frame  = new JFrame();
    frame.setSize(800,800);
    frame.setTitle("BattleShip");
    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    frame.setLayout(new FlowLayout());
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

    location = new JButton[10][10];
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        location[i][j] = new JButton((char)(i + 65) + "" + (j + 1));
        location[i][j].addActionListener(listener);
      }
    }
  }

  public void createComponents()
  {
    exitButton = new JButton("Exit");

    JPanel buttonPanel = new JPanel(new GridLayout(10, 10));
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        buttonPanel.add(location[i][j]);
      }
    }

    frame.getContentPane().add(exitButton);
    frame.getContentPane().add(buttonPanel);
  }

  public static void main(String[] args)
  {
    SetupGUI setupGUI = new SetupGUI();
    setupGUI.createComponents();
    setupGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
