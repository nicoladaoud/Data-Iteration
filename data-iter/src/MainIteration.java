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
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.awt.FlowLayout;

public class MainIteration {
	//main
		private String firstName;
		private String email;

		private static final String DEVELOPERS = "Tyler Phippen, Nicola Daoud, Gyubeom Kim, and Jun Kim";
		private static final String EXTRA_INFO = "Application Location: C:\\Download \n"
				+ "For inquiries, contact 'junyeob@uw.edu'\r\n" + "Thank you for choosing our software.";
		private double myVersionNumb;
		private JFrame frmAppliance;
		private JTextField textField;
		private JTextField typedUserFirst;
		private JTextField typedUserEmail;
		private DefaultMutableTreeNode root;
		private DefaultMutableTreeNode node;
		private TreePath treePath;
		int index;
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
		*@author Nicola Daoud, Gyubeom Kim, Jun Kim, Tyler Phippen
		*Nicola implemented exporting functioanlity
		*Gyubeom implemented the functionality of saving user information (email and name)
		*gyubeom and Jun Kim both pretty much rewrote all of the window and JFrame as well
		*Tyler: the open file method, and the import button
		* Jun: created the Add and Remove functionality. Also created the "extra" button.
		**/
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
			
			panel.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));

			JTree jt = new JTree(new TreeInit().getTree());
			panel.add(jt);

			JLabel lblSelect = new JLabel("Select an item to add to or remove");
			lblSelect.setBounds(250, 138, 224, 16);
			frmAppliance.getContentPane().add(lblSelect);

			textField = new JTextField();
			textField.setBounds(290, 166, 130, 26);
			frmAppliance.getContentPane().add(textField);
			textField.setColumns(10);

			JButton btnAdd = new JButton("Add New Item");
			
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					
			            DefaultMutableTreeNode SelectedNode;

			            treePath = jt.getSelectionPath();
			            SelectedNode = (DefaultMutableTreeNode) treePath
			                    .getLastPathComponent();

			            index = SelectedNode.getIndex(SelectedNode) + 1;

			            String NodeStr = textField.getText();

			            node = new DefaultMutableTreeNode(NodeStr);
			            SelectedNode.insert(node, index);
			            jt.updateUI();
				}
			});
			
			btnAdd.setBounds(432, 166, 117, 29);
			frmAppliance.getContentPane().add(btnAdd);

			JButton btnRemove = new JButton("Remove Seleted Item");
			
			btnRemove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				    
					 DefaultTreeModel model = (DefaultTreeModel) jt.getModel();

		                TreePath[] paths = jt.getSelectionPaths();
		                if (paths != null) {
		                    for (TreePath path : paths) {
		                        DefaultMutableTreeNode node = (DefaultMutableTreeNode) 
		                            path.getLastPathComponent();
		                        if (node.getParent() != null) {
		                            model.removeNodeFromParent(node);
		                        }
		                    }
		                }
		                
		                jt.updateUI();

				}
			});

			btnRemove.setBounds(558, 166, 174, 29);
			frmAppliance.getContentPane().add(btnRemove);
			
			//About
			JButton btnAbout = new JButton("About");
			about(btnAbout);
			
			//User First, Email - Save
			JLabel lblItem = new JLabel("Item:");
			lblItem.setBounds(248, 171, 61, 16);
			frmAppliance.getContentPane().add(lblItem);

			JLabel lblFirstName = new JLabel("First Name:");
			lblFirstName.setBounds(250, 18, 96, 16);
			frmAppliance.getContentPane().add(lblFirstName);

			JLabel lblEmail = new JLabel("Email:");
			lblEmail.setBounds(250, 46, 96, 16);
			frmAppliance.getContentPane().add(lblEmail);

			typedUserFirst = new JTextField();
			typedUserFirst.setBounds(391, 13, 158, 26);
			frmAppliance.getContentPane().add(typedUserFirst);
			typedUserFirst.setColumns(10);

			typedUserEmail = new JTextField();
			typedUserEmail.setBounds(391, 41, 158, 26);
			frmAppliance.getContentPane().add(typedUserEmail);
			typedUserEmail.setColumns(10);

			JButton btnSave = new JButton("Save");
			userNameEmail(btnSave);

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
		
		/**
		 * It shows the message containing developers' names and version.
		 * 
		 * @param theButton representing the About button
		 */
		private void about(JButton theButton) {
			theButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, DEVELOPERS, "Developers", JOptionPane.PLAIN_MESSAGE);
				}
			});
			theButton.setBounds(290, 204, 117, 29);
			frmAppliance.getContentPane().add(theButton);
		}
		
		/**
		 * It saves the information of user first name and email
		 * in the text file.
		 * 
		 * @param theSave representing the Save button
		 */
		public void userNameEmail(JButton theSave) {
			theSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String uFirstName = typedUserFirst.getText();
					String uEmail = typedUserEmail.getText();
					File data = new File("userInfo.txt");
					FileWriter toFile = null;
					try {
						toFile = new FileWriter(data, true);
					} catch (IOException e2) {
						e2.printStackTrace();
					}
					if(!uEmail.contains("@")) {
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
			theSave.setBounds(391, 77, 117, 29);
			frmAppliance.getContentPane().add(theSave);
		}
		
		/**
		 * It set the version number.
		 * 
		 * @param theVersionNumb representing the version number
		 */
		public void setVersionNumb(final double theVersionNumb) {
			this.myVersionNumb = theVersionNumb;
		}

	    /**
	     * It makes the frame to locate in center of window screen.
	     * 
	     * @param theFrame representing the frame
	     */
		private void centerWindow(final Window theFrame) {
			final Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
			final int x = (int) ((dimension.getWidth() - theFrame.getWidth()) / 2);
			final int y = (int) ((dimension.getHeight() - theFrame.getHeight()) / 2);
			theFrame.setLocation(x, y);
		}
}
