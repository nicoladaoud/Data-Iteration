import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainIteration {
	
	private String firstName;
	private String email;

	private static final String DEVELOPERS = "Tyler Phippen, Nicola Daoud, Gyubeom Kim, and Jun Kim";
	private static final String EXTRA_INFO = "Application Location: C:\\Download \n"
			+ "For inquiries, contact 'junyeob@uw.edu'\r\n" + "Thank you for choosing our software.";
	private double myVersionNumb;
	private JFrame frmAppliance;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private DefaultMutableTreeNode root;
	private JFileChooser myChooser;
	private File mySettings;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainIteration window = new MainIteration();
					window.frmAppliance.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainIteration() {
		initialize();
		this.myVersionNumb = 0.0;
		this.setVersionNumb(1.0);
		this.myChooser = new JFileChooser(".");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAppliance = new JFrame();
		frmAppliance.setTitle("Data Iteration");
		frmAppliance.setBounds(100, 100, 759, 447);
		centerWindow(frmAppliance);
		frmAppliance.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAppliance.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 210, 425);
		frmAppliance.getContentPane().add(panel);

		root = new DefaultMutableTreeNode("Appliance");
		// ChildNode
		DefaultMutableTreeNode liv = new DefaultMutableTreeNode("Living Room");

		DefaultMutableTreeNode kit = new DefaultMutableTreeNode("Kitchen");
		DefaultMutableTreeNode bat = new DefaultMutableTreeNode("Bathroom");
		root.add(liv);
		root.add(kit);
		root.add(bat);

		DefaultMutableTreeNode item1 = new DefaultMutableTreeNode("TV");
		DefaultMutableTreeNode item2 = new DefaultMutableTreeNode("Digital Watch");
		DefaultMutableTreeNode item3 = new DefaultMutableTreeNode("Air Conditioner");

		liv.add(item1);
		liv.add(item2);
		liv.add(item3);

		panel.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));

		JTree jt = new JTree(root);
		panel.add(jt);

		JLabel lblSelect = new JLabel("Select an item to add to or remove");
		lblSelect.setBounds(250, 138, 224, 16);
		frmAppliance.getContentPane().add(lblSelect);

		textField = new JTextField();
		textField.setBounds(290, 166, 130, 26);
		frmAppliance.getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnAdd = new JButton("Add New Item");
		btnAdd.setBounds(432, 166, 117, 29);
		frmAppliance.getContentPane().add(btnAdd);

		JButton btnAbout = new JButton("About");
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, DEVELOPERS, "Developers", JOptionPane.PLAIN_MESSAGE);
			}
		});
		btnAbout.setBounds(290, 204, 117, 29);
		frmAppliance.getContentPane().add(btnAbout);

		JButton btnRemove = new JButton("Remove Seleted Item");

		btnRemove.setBounds(558, 166, 174, 29);
		frmAppliance.getContentPane().add(btnRemove);

		JLabel lblItem = new JLabel("Item:");
		lblItem.setBounds(248, 171, 61, 16);
		frmAppliance.getContentPane().add(lblItem);

		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(250, 18, 96, 16);
		frmAppliance.getContentPane().add(lblFirstName);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(250, 46, 96, 16);
		frmAppliance.getContentPane().add(lblEmail);

		textField_1 = new JTextField();
		textField_1.setBounds(391, 13, 158, 26);
		frmAppliance.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(391, 41, 158, 26);
		frmAppliance.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uFirstName = textField_1.getText();
				String uEmail = textField_2.getText();
				firstName = uFirstName;
				email = uEmail;
				File data = new File("userInfo.txt");
				FileWriter toFile = null;
				try {
					toFile = new FileWriter(data, true);
				} catch (IOException e2) {
					e2.printStackTrace();
				}
				if (!uEmail.contains("@")) {
					JOptionPane.showMessageDialog(frmAppliance, "Wrong Email Format! Please Try it again");
				} else {
					JOptionPane.showMessageDialog(frmAppliance, "Saved.");
					try {
						toFile.append("First Name: " + uFirstName + ", " + "Email: " + uEmail + "\n");
						toFile.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnSave.setBounds(391, 77, 117, 29);
		frmAppliance.getContentPane().add(btnSave);

		JButton ExtraBtn = new JButton("Extra");
		ExtraBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, EXTRA_INFO, "Extra Information", JOptionPane.PLAIN_MESSAGE);
			}
		});
		ExtraBtn.setBounds(420, 204, 117, 29);
		frmAppliance.getContentPane().add(ExtraBtn);

		JButton importButton = new JButton("Import Settings");
		importButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (openFile()) {
						FileInputStream fis = new FileInputStream(mySettings);
						ObjectInputStream ois = new ObjectInputStream(fis);
						try {
							ois.readObject();
						} catch (ClassNotFoundException e1) {
							e1.printStackTrace();
						}
						String userInfo = ois.toString();
						fis.close();
						ois.close();
						JOptionPane.showMessageDialog(frmAppliance, "Imported Settings: " + userInfo);
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		importButton.setBounds(515, 77, 130, 29);
		frmAppliance.getContentPane().add(importButton);
		
		JButton btnExport = new JButton("Export");
		btnExport.addActionListener(new ActionListener() { // exporting functionality by Nicola
			public void actionPerformed(ActionEvent e) {
				JFileChooser myFileChooser = new JFileChooser();
				
                final int result = myFileChooser.showSaveDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                   
                        String x = myFileChooser.getSelectedFile().getAbsolutePath();
                        //System.out.print(x);
                        File file = new File(x);
                        ObjectOutputStream oos = null;
    				    FileOutputStream fout = null;
    				    try{ 
    				    	FileWriter toFile = new FileWriter(file, true);
    				    	toFile.append("First Name: " + firstName + ", " + "Email: " + email + "\n");
    						toFile.close();
    				      fout = new FileOutputStream(x, true);
    				      oos = new ObjectOutputStream(fout);
    				     // oos.writeObject(this);
    				     } catch (Exception ex) {}
    				     finally {
    				       if(oos != null){
    				         try {oos.close();} catch (Exception ex) {}
    				       }
    				     }
                        
   
                }
				
			}

		});
		btnExport.setBounds(515, 108, 100, 29);
		frmAppliance.getContentPane().add(btnExport);
		
		

	}

	/**
	 * method to check if a file was opened.
	 * 
	 * @return success
	 * @throws IOException
	 */
	private boolean openFile() throws IOException {
		boolean success = false;
		final int result = myChooser.showOpenDialog(myChooser);
		if (result == JFileChooser.APPROVE_OPTION) {
			success = true;
			mySettings = myChooser.getSelectedFile();

		}
		return success;
	}

	public void setVersionNumb(final double theVersionNumb) {
		this.myVersionNumb = theVersionNumb;
	}

	private void centerWindow(final Window theFrame) {
		final Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		final int x = (int) ((dimension.getWidth() - theFrame.getWidth()) / 2);
		final int y = (int) ((dimension.getHeight() - theFrame.getHeight()) / 2);
		theFrame.setLocation(x, y);
	}
}
