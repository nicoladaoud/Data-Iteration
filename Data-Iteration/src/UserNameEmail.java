import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class UserNameEmail {

	private JFrame frame;
	private JTextField username;
	private JTextField userEmail;
	private JLabel lblEmail;
	private JLabel lblFirstName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserNameEmail window = new UserNameEmail();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public UserNameEmail() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		username = new JTextField();
		username.setBounds(247, 102, 130, 26);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		userEmail = new JTextField();
		userEmail.setBounds(247, 140, 130, 26);
		frame.getContentPane().add(userEmail);
		userEmail.setColumns(10);
		
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String uFirstName = username.getText();
				String uEmail = userEmail.getText();
				File data = new File("userInfo.txt");
				FileWriter toFile = null;
				try {
					toFile = new FileWriter(data, true);
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				if(!uEmail.contains("@")) {
					JOptionPane.showMessageDialog(frame, "Wrong Email Format! Please Try it again");
				} else {
					JOptionPane.showMessageDialog(frame, "Saved.");
					try {
						toFile.append("First Name: " + uFirstName + ", " + "Email: " + uEmail + "\n");
						toFile.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		 
		btnSave.setBounds(154, 196, 117, 29);
		frame.getContentPane().add(btnSave);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setBounds(69, 145, 61, 16);
		frame.getContentPane().add(lblEmail);
		
		lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(69, 107, 97, 16);
		frame.getContentPane().add(lblFirstName);
	}
}
