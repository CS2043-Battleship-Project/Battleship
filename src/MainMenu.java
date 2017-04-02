import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import java.awt.Graphics;

public class MainMenu extends JFrame
{
  private JPanel panel;
  private JPanel labels;
  private JButton connectButton;
  private JButton exitButton;
  private ImageIcon backgroundImage;

  private JFrame frame;
  private Toolkit toolkit;
  private String connectPopUp;

  private String user;
  private int port;
  private JTextField userIP;
  private JTextField userPort;
  private String userString;
  private String portString;
  private String dummyUser = "localhost";
  private String dummyPort = "31415";
  private Client client;
  SetupGUI setupGUI;
  
  public MainMenu()
  {
	  
    frame  = new JFrame();
	
    panel = new JPanel(new BorderLayout(5,5));
    labels = new JPanel(new GridLayout(0,1,2,2));
    frame.setSize(800,800);
    frame.setTitle("BattleShip");
    frame.setVisible(true);
    toolkit = Toolkit.getDefaultToolkit();
	
    
  }

  public void createComponents()
  {
    // Creates a panel for the background picture
    JPanel backgroundPanel = new JPanel();
    //backgroundPanel.setLayout(new BorderLayout())
    backgroundPanel.setPreferredSize(new Dimension(800, 800));
   Image image = toolkit.getImage("Ocean.png");

    Image scaledImage = image.getScaledInstance(800, 800, Image.SCALE_DEFAULT);
    backgroundImage = new ImageIcon(scaledImage);
    JLabel backgroundLabel = new JLabel(backgroundImage);

    //Creates the panel for the buttons, it will be placed on top of the backgroundPanel
    JPanel buttonPanel = new JPanel();
    buttonPanel.setPreferredSize(new Dimension(100,100));
    connectButton = new JButton("Connect");
    exitButton = new JButton("Exit");
    exitButton.addActionListener(new Exit());
    connectButton.addActionListener(new ConnectButton());

    buttonPanel.add(connectButton);
    buttonPanel.add(exitButton);

    backgroundPanel.add(backgroundLabel);
    // backgroundPanel.add(connectButton);
    // backgroundPanel.add(exitButton);
    backgroundPanel.add(buttonPanel);
    frame.getContentPane().add(BorderLayout.NORTH, backgroundPanel);
    frame.getContentPane().add(BorderLayout.SOUTH, buttonPanel);
    //frame.getContentPane().add(BorderLayout.CENTER, backgroundPanel);
     LogIn(frame);
   }
  private void LogIn(JFrame frame)
  {


    labels.add(new JLabel("Enter IP", SwingConstants.RIGHT));
    labels.add(new JLabel("Enter Port", SwingConstants.RIGHT));
    panel.add(labels, BorderLayout.WEST);
    JPanel controls = new JPanel(new GridLayout(0,1,2,2));
     userIP = new JTextField();
     controls.add(userIP);
     userPort = new JTextField();
    userPort.addActionListener(new ConnectButton());
    controls.add(userPort);
    panel.add(controls, BorderLayout.CENTER);


  }
  public void checkLogin()
  {
	 if(userString.equals(dummyUser) && portString.equals(dummyPort))
		{
			int portNumber = Integer.parseInt(portString);
			
			//client = new Client(userString, portNumber);
			setupGUI =new SetupGUI();
			frame.setVisible(false);
		}
  }
  	
      private class Exit implements ActionListener
      {
        @Override
        public void actionPerformed(ActionEvent e) {

          System.exit(0);

      }

      }
      private class ConnectButton implements ActionListener
      {
          @Override
          public void actionPerformed(ActionEvent e) {

            connectPopUp = JOptionPane.showInputDialog(frame, panel,"Log in", JOptionPane.QUESTION_MESSAGE );
             userString = userIP.getText();
             portString = userPort.getText();
			checkLogin();
				

            System.out.println(connectPopUp);
          }

      }

 public static void main(String[] args)
  {
      MainMenu mainMenu = new MainMenu();
      mainMenu.createComponents();

  }

}
