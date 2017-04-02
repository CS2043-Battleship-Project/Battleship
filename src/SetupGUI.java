import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Toolkit;
import java.util.ArrayList;

public class SetupGUI extends JFrame
{
  private JFrame frame;
  private Toolkit toolkit;
  private JButton[][] location;
  private JButton exitButton;
  private JLabel instructions;
  private ActionListener listener;
  private String shipToBePlaced;
  private ArrayList<String> parts;
  private ArrayList<ArrayList<String>> ships;

  private ImageIcon backgroundImage;

  public SetupGUI()
  {
    frame  = new JFrame();
    frame.setSize(800,800);
    frame.setTitle("Setup");
    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    frame.setLayout(new GridLayout(2, 1));
    frame.setVisible(true);
    toolkit = Toolkit.getDefaultToolkit();
    parts = new ArrayList<String>();
    ships = new ArrayList<ArrayList<String>>();
    shipToBePlaced = "AC";

    listener = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
          String text = ((JButton)e.getSource()).getText();
          if (shipToBePlaced.equals("AC")) {
            System.out.print(text + " ");
            parts.add(text);
            if (parts.size() == 5) {
              System.out.println();
              shipToBePlaced = "CR";
              ships.add(parts);
              parts.clear();
            }
          } else if (shipToBePlaced.equals("CR")) {
            parts.add(text);
            System.out.print(text + " ");
            if (parts.size() == 4) {
              System.out.println();
              shipToBePlaced = "SB";
              ships.add(parts);
              parts.clear();
            }
          } else if (shipToBePlaced.equals("SB")) {
            parts.add(text);
            System.out.print(text + " ");
            if (parts.size() == 3) {
              System.out.println();
              shipToBePlaced = "FR";
              ships.add(parts);
              parts.clear();
            }
          } else if (shipToBePlaced.equals("FR")) {
            parts.add(text);
            System.out.print(text + " ");
            if (parts.size() == 2) {
              System.out.println();
              ships.add(parts);

              // Call server with placed ships.
            }
          }
        }
      }
    };
	createComponents();


  }

  public void createComponents()
  {
	 JPanel backgroundPanel = new JPanel();

	 backgroundPanel.setPreferredSize(new Dimension(800, 800));
	  Image image = toolkit.getImage("Ocean.png");

	 Image scaledImage = image.getScaledInstance(800, 800, Image.SCALE_DEFAULT);
    backgroundImage = new ImageIcon(scaledImage);
    JLabel backgroundLabel = new JLabel(backgroundImage);
	  backgroundPanel.add(backgroundLabel);

    instructions = new JLabel("Please place your Aircraft Carrier", SwingConstants.CENTER);
    instructions.setPreferredSize(new Dimension(120, 20));

    exitButton = new JButton("Exit");
	 exitButton.addActionListener(new Exit());

	 location = new JButton[10][10];
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        location[i][j] = new JButton((char)(i + 65) + "" + (j + 1));
        location[i][j].addActionListener(listener);
      }


	}

    JPanel buttonPanel = new JPanel(new GridLayout(10, 10));
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        buttonPanel.add(location[i][j]);
      }
    }

    JPanel bottomPanel = new JPanel();
    bottomPanel.add(exitButton);
    bottomPanel.add(buttonPanel);
	frame.getContentPane().add(BorderLayout.NORTH, backgroundPanel);
    frame.getContentPane().add(instructions);
    frame.getContentPane().add(bottomPanel);
  }
   private class Exit implements ActionListener
      {
        @Override
        public void actionPerformed(ActionEvent e) {

          System.exit(0);

      }

      }


 /* public static void main(String[] args)
  {
    SetupGUI setupGUI = new SetupGUI();
    setupGUI.createComponents();
    setupGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  })*/
}
