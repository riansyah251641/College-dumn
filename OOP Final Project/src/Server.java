import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class Server extends JFrame implements ActionListener {
	/**
	 * Server class for client interlocutor
	 */
	static JPanel temp1;
	JTextField text;
	JButton button_Send;
	static JPanel place;
	static JFrame temp2 = new JFrame();
	static Box vertical = Box.createVerticalBox();
	static ServerSocket FGH;
	static Socket ASD;
	static DataInputStream input;
	static DataOutputStream output;
	Boolean typing;
	static ImageIcon serverIcon;
	static ImageIcon serverIMG;

	// get server image icon
	public ImageIcon getServerIcon() {
		return serverIcon;
	}

	// get server display picture
	public ImageIcon getServerDP() {
		return serverIMG;
	}

	// Constructor for server image
	public Server(String str) {
		Image img = new ImageIcon(this.getClass().getResource("./images/server_profil.png")).getImage()
				.getScaledInstance(250, 250,
						Image.SCALE_DEFAULT);
		serverIMG = new ImageIcon(img);
		img = new ImageIcon(this.getClass().getResource("./images/server_profil.png")).getImage().getScaledInstance(30,
				30,
				Image.SCALE_DEFAULT);
		serverIcon = new ImageIcon(img);
	}

	public Server() {
		// setDefaultCloseOperation() method is used to specify one of several options
		// for the close button_Send.
		// In this case, we use EXIT_ON_CLOSE -- � Exit the application
		temp2.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		temp1 = new JPanel(); // Top panel that wiil show the photo, name, videocall button_Send etc.
		temp1.setLayout(null);
		temp1.setBackground(new Color(255, 140, 0));
		temp1.setBounds(0, 0, 450, 70);
		temp2.add(temp1);

		// Take left arrow image
		Image img = new ImageIcon(this.getClass().getResource("./images/back_icon.png")).getImage().getScaledInstance(
				30, 30,
				Image.SCALE_DEFAULT);

		// Put in on label
		ImageIcon img1 = new ImageIcon(img);
		JLabel label = new JLabel(img1); // Image of the go back arrow
		label.setBounds(5, 17, 30, 30);
		temp1.add(label);

		// The Java MouseListener is notified whenever change the state of mouse
		// In this case, we need to exit when left arrow label is clicked
		label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent ae) {
				System.exit(0); // If the user clicks the arrow then the frame closes
			}
		});

		// Take profile picture image
		Image img2 = new ImageIcon(this.getClass().getResource("./images/server_profil.png")).getImage()
				.getScaledInstance(60, 60,
						Image.SCALE_DEFAULT);

		// Put in on label
		ImageIcon img3 = new ImageIcon(img2);
		JLabel label2 = new JLabel(img3); // Image of the user
		label2.setBounds(40, 5, 60, 60);
		temp1.add(label2);

		// server display picture
		// The Java MouseListener is notified whenever change the state of mouse
		// In this case, it show off the profile picture when we click the label
		Image sDP = new ImageIcon(this.getClass().getResource("./images/server_profil.png")).getImage()
				.getScaledInstance(250,
						250,
						Image.SCALE_DEFAULT);
		label2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent ae) {
				new DisplayPictureGUI(new ImageIcon(sDP), temp2.getLocation(), temp1.getBackground());
			}
		});

		// Take video image
		Image img4 = new ImageIcon(this.getClass().getResource("./images/video_icon.png")).getImage().getScaledInstance(
				30, 21,
				Image.SCALE_DEFAULT);

		// Put in on label
		ImageIcon img5 = new ImageIcon(img4);
		JLabel label5 = new JLabel(img5); // Image of the video
		label5.setBounds(290, 23, 30, 30);
		temp1.add(label5);

		// Take send image
		Image img10 = new ImageIcon(this.getClass().getResource("./images/send_icon.png")).getImage().getScaledInstance(
				35,
				35,
				Image.SCALE_DEFAULT);
		// Put in on label
		ImageIcon img16 = new ImageIcon(img10);
		// Take phone image
		Image img6 = new ImageIcon(this.getClass().getResource("./images/phone_icon.png")).getImage().getScaledInstance(
				30, 30,
				Image.SCALE_DEFAULT);

		// Put in on label
		ImageIcon img7 = new ImageIcon(img6);
		JLabel label6 = new JLabel(img7); // Image of the phone
		label6.setBounds(350, 23, 35, 30);
		temp1.add(label6);

		// Take menu image
		Image img8 = new ImageIcon(this.getClass().getResource("./images/3icon.png")).getImage().getScaledInstance(
				30, 30,
				Image.SCALE_DEFAULT);

		// Put it on label
		ImageIcon img9 = new ImageIcon(img8);
		JLabel label7 = new JLabel(img9); // Image of the 3 dots
		label7.setBounds(410, 23, 13, 25);
		temp1.add(label7);

		// label5, label6, label7 create ExceptionGUI object when it'ASD clicked cause
		// it'ASD still under development
		// action when video icon is clicked
		label5.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent ae) {
				new ExceptionGUI(temp2.getLocation());
			}
		});
		// action when phone icon is clicked
		label6.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent ae) {
				new ExceptionGUI(temp2.getLocation());
			}
		});
		// action when 3 dots icon is clicked
		label7.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent ae) {
				new ExceptionGUI(temp2.getLocation());
			}
		});

		// Create name label
		JLabel label3 = new JLabel("Wanda");
		label3.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
		label3.setForeground(Color.white); // Label for the name
		label3.setBounds(110, 17, 100, 20);
		temp1.add(label3);

		// Create typing status label
		JLabel label4 = new JLabel("Online");
		label4.setFont(new Font("SAN_SERIF", Font.PLAIN, 14));
		label4.setForeground(Color.GREEN); // Label to show if the user is Active
		label4.setBounds(110, 36, 100, 20);
		temp1.add(label4);

		// Create server label
		JLabel serverlabel = new JLabel("Server");
		serverlabel.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
		serverlabel.setForeground(Color.white); // Label to show that this is the server side
		serverlabel.setBounds(205, 25, 100, 20);
		temp1.add(serverlabel);

		// Set timer for typing status
		Timer t = new Timer(1, new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (!typing) {
					label4.setText("Online"); // If the user is not typing, then change the label to "Online"
				}
			}
		});

		t.setInitialDelay(2000); // 2 seconds delay so that "typing..." changes to "Online", after 2 seconds
									// of no typing

		// Main panel that shows the messages
		place = new JPanel();
		place.setBounds(5, 75, 440, 570);
		place.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));

		// Create a scroll pane
		JScrollPane pane = new JScrollPane(place);
		pane.setBounds(1, 70, 450, 360);
		pane.getVerticalScrollBar().setUnitIncrement(14);
		temp2.add(pane);

		// Text fields to write the messages
		text = new JTextField(); // Text fields to write the messages
		text.setBounds(1, 450, 350, 40);
		text.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
		temp2.add(text);

		text.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				// If the user presses a key while in the textField, change the label from
				// "Online" to typing
				label4.setText("Mengetik..");

				t.stop();

				typing = true;
			}

			public void keyReleased(KeyEvent ke) {
				// When a key is released from the user while they are in the textField, start
				// the timer
				typing = false;

				if (!t.isRunning()) {
					t.start();
				}
			}
		});

		// Button to send the message
		button_Send = new JButton(img16);
		button_Send.setBounds(360, 450, 80, 40);
		button_Send.setBackground(Color.green.darker());
		button_Send.setForeground(Color.white);
		button_Send.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
		button_Send.addActionListener(this);
		temp2.add(button_Send);

		temp2.getContentPane().setBackground(Color.black);
		temp2.setLayout(null);
		temp2.setSize(465, 540);
		temp2.setLocation(100, 50);
		temp2.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		try {
			String out = text.getText();
			// if the string on text label is not empty
			if (!out.isEmpty()) {
				// GUI for server chat box
				JPanel p2 = formatLabel(out);
				text.setText("");// Empty the text box

				place.setLayout(new BorderLayout());

				JPanel right = new JPanel(new BorderLayout());
				// so the messages appear at the right side of the screen
				right.add(p2, BorderLayout.LINE_END);
				vertical.add(right);
				// add a small space between the messages
				vertical.add(Box.createVerticalStrut(15));

				place.add(vertical, BorderLayout.PAGE_START);

				// refresh the GUI
				temp2.revalidate();

				// write the message at the dataOutputStream
				output.writeUTF(out);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// function to generate server format text
	public static JPanel formatLabel(String out) {
		// new panel for chat box
		JPanel p3 = new JPanel();

		// panel attribute displayed vertically
		p3.setLayout(new BoxLayout(p3, BoxLayout.Y_AXIS));

		// make the label in which the messages will appear
		JLabel l1 = new JLabel("<html><p style = \"width : 150px\">" + out + "</p></html>");
		l1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		l1.setBackground(new Color(37, 211, 102));
		l1.setOpaque(true);
		l1.setBorder(new EmptyBorder(15, 15, 15, 10));

		// add the time of when the message was send
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

		JLabel l2 = new JLabel();
		l2.setText(sdf.format(cal.getTime()));

		p3.add(l1);
		p3.add(l2);
		return p3;
	}

	// function to generate client format text
	public static JPanel clientFormatLabel(String out, ImageIcon icon, ImageIcon dp) {
		// make a new panel for the message
		JPanel p4 = formatLabel(out);
		JPanel p5 = new JPanel();

		// panel attribute displayed vertically
		p5.setLayout(new BoxLayout(p5, BoxLayout.Y_AXIS));

		// add image above the chat box
		JLabel labelClientImg = new JLabel(icon);

		// action when the image clicked
		labelClientImg.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent ae) {
				new DisplayPictureGUI(dp, temp2.getLocation(), temp1.getBackground());
			}
		});

		// add all panel to chat box panel
		p5.add(labelClientImg);
		p5.add(p4);

		return p5;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Server();
		// object for client image
		Client cImg = new Client("");

		String msgin = "";
		try {
			FGH = new ServerSocket(1000);// give the socket a random number between 0 and 65535

			while (true) {
				ASD = FGH.accept();// accept the connection with the client and make a new socket

				input = new DataInputStream(ASD.getInputStream());
				output = new DataOutputStream(ASD.getOutputStream());

				while (true) {
					place.setLayout(new BorderLayout());

					msgin = input.readUTF();// msgin => the Client message

					JPanel p2 = clientFormatLabel(msgin, cImg.getClientIcon(), cImg.getClientDP()); // Make a new panel
																									// for the message
					JPanel left = new JPanel(new BorderLayout());

					left.add(p2, BorderLayout.LINE_START); // so the messages appear at the left side of the screen

					vertical.add(left);
					vertical.add(Box.createVerticalStrut(15)); // add a small space between the messages
					place.add(vertical, BorderLayout.PAGE_START);

					try {
						Thread.sleep(1000);// sleep for 1000 milliseconds => 1 second
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					// after a second passes, then show the message to the Client
					temp2.validate();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}