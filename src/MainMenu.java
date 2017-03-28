import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Toolkit;
public class MainMenu extends JFrame
{
  private JButton connectButton;
  private JButton exitButton;
  private ImageIcon backgroundImage;
  private JFrame frame;
  private Toolkit toolkit;

  public MainMenu()
  {
    frame  = new JFrame();
    frame.setSize(800,800);
    frame.setTitle("BattleShip");
    frame.setVisible(true);
    toolkit = Toolkit.getDefaultToolkit();


  }

  public void createComponents()
  {
    // Creates a panel for the background picture
    JPanel backgroundPanel = new JPanel();
    backgroundPanel.setPreferredSize(new Dimension(800, 800));
    Image image = toolkit.getImage("assets/image/Ocean.png");

    Image scaledImage = image.getScaledInstance(800, 800, Image.SCALE_DEFAULT);
    backgroundImage = new ImageIcon(scaledImage);
    JLabel backgroundLabel = new JLabel(backgroundImage);
    connectButton = new JButton("Connect");
    exitButton = new JButton("Exit");


    backgroundPanel.add(backgroundLabel);
    backgroundPanel.add(connectButton);
    backgroundPanel.add(exitButton);
    frame.getContentPane().add(BorderLayout.NORTH, backgroundPanel);
    frame.getContentPane().add(BorderLayout.CENTER, backgroundPanel);



    //Creates the panel for the buttons, it will be placed on top of the backgroundPanel
    /*JPanel buttonPanel = new JPanel();
    buttonPanel.setPreferredSize(new Dimension(100,100));
    connectButton = new JButton("Connect");
    exitButton = new JButton("Exit");

    buttonPanel.add(connectButton);
    buttonPanel.add(exitButton);
    frame.getContentPane().add(BorderLayout.CENTER, buttonPanel);*/



  }
  public static void main(String[] args)
  {
      MainMenu mainMenu = new MainMenu();
      mainMenu.createComponents();
  }

}
