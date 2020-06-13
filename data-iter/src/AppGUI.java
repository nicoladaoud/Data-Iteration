import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
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
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import org.icepdf.ri.common.ComponentKeyBinding;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;


public class AppGUI {
	
	/**
	 * String to show for extra button.
	 */
	private static final String EXTRA_INFO = "Application Location: C:\\Download \n"
			+ "For inquiries, contact 'junyeob@uw.edu'\r\n" + "Thank you for choosing our software.";
	
	/**
	 * String to store developers names.
	 */
    private static final String DEVELOPERS =
                    "Tyler Phippen, Nicola Daoud, Gyubeom Kim, and Jun Kim";
    
    public HashMap<String, String> getMap() {
		return map;
	}

	public void setMap(HashMap<String, String> map) {
		this.map = map;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public JFrame getMyFrame() {
		return myFrame;
	}

	public void setMyFrame(JFrame myFrame) {
		this.myFrame = myFrame;
	}

	public JFileChooser getMyChooser() {
		return myChooser;
	}

	public void setMyChooser(JFileChooser myChooser) {
		this.myChooser = myChooser;
	}

	public double getMyVersionNumb() {
		return myVersionNumb;
	}

	public void setMyVersionNumb(double myVersionNumb) {
		this.myVersionNumb = myVersionNumb;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminPass() {
		return adminPass;
	}

	public void setAdminPass(String adminPass) {
		this.adminPass = adminPass;
	}

	public File getMySettings() {
		return mySettings;
	}

	public void setMySettings(File mySettings) {
		this.mySettings = mySettings;
	}

	public TreePath getTreePath() {
		return treePath;
	}

	public void setTreePath(TreePath treePath) {
		this.treePath = treePath;
	}

	public JTree getJt() {
		return jt;
	}

	public void setJt(JTree jt) {
		this.jt = jt;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public SwingController getController() {
		return controller;
	}

	public void setController(SwingController controller) {
		this.controller = controller;
	}

	public DefaultMutableTreeNode getNode() {
		return node;
	}

	public void setNode(DefaultMutableTreeNode node) {
		this.node = node;
	}

	public int getDimensionWidth() {
		return dimensionWidth;
	}

	public void setDimensionWidth(int dimensionWidth) {
		this.dimensionWidth = dimensionWidth;
	}

	public int getDimensionHeight() {
		return dimensionHeight;
	}

	public void setDimensionHeight(int dimensionHeight) {
		this.dimensionHeight = dimensionHeight;
	}

	public static String getExtraInfo() {
		return EXTRA_INFO;
	}

	public static String getDevelopers() {
		return DEVELOPERS;
	}

	public void setAdminStatus(boolean adminStatus) {
		this.adminStatus = adminStatus;
	}

	private HashMap<String, String> map = new HashMap<String, String>();
    
    private String filePath;

    /**
     * This is the main frame.
     */
    private JFrame myFrame;

    /**
     * This is file chooser for import button.
     */
    private JFileChooser myChooser;

    /**
     * Current version number
     */
    private double myVersionNumb;
    
    /**
     * Stores user's first name.
     */
    private String userFirstName;
    
    /**
     * Stores the user's email.
     */
    private String userEmail;
    
    /**
     * Stores the admin's ID number.
     */
    private String adminId;
    
    /**
     * Stores the admin's password.
     */
    private String adminPass;
    
    /**
     * Stores admin status for accessibility.
     */
    private boolean adminStatus;
    
	/**
     * File for importing previous settings.
     */
    private File mySettings;
    
	/**
     * Path of the tree.
     */
    private TreePath treePath;
    
	/**
     * Tree.
     */
    private JTree jt;
    
	/**
     * Index.
     */
    private int index;
    
	/**
     * Controller of Swing.
     */
	private SwingController controller;
	
	/**
     * Mutable tree node.
     */
	private DefaultMutableTreeNode node;
	
	/**
     * Gets dimension of current screen for application.
     */
    private int dimensionWidth;
    
    /**
     * Gets dimension of current screen for application.
     */
    private int dimensionHeight;
    
	/**
     * Instantiates all of the fields and creates object.
     */
    public AppGUI() {
        this.myFrame = new JFrame("User Guide");
        this.myChooser = new JFileChooser(".");
        this.myVersionNumb = 1.0;
        this.userFirstName = "";
        this.userEmail = "";
        this.adminId = "";
        this.adminPass = "";
        this.adminStatus = false;
        this.mySettings = null;
        this.treePath = null;
        this.jt = null;
        this.filePath = null;
        this.controller = null;
        this.dimensionWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        this.dimensionHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        myFrame.setSize(this.dimensionWidth, this.dimensionHeight);
    }
    
    /**
     * Builds the application and runs it.
     */
    public void run() {
        createPanel();
        createMenu(this.myFrame);
        centerWindow(this.myFrame);
        myFrame.setVisible(true);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    /**
     * Builds the Panels for each section of the window.
     */
    private void createPanel() {
        myFrame.getContentPane().setLayout(new BorderLayout(0, 0));
        final JPanel mainPanel = new JPanel();
        final JPanel centPanel = new JPanel();
        final JPanel westSidePanel = new JPanel();
        final JPanel southSidePanel = new JPanel();
        final JPanel eastSidePanel = new JPanel();
        
        int southPanelSize = (int) (this.dimensionHeight * 0.84);
        int eastWidth = (int) (this.dimensionWidth * 0.18);
        int westWidth = (int) (this.dimensionWidth * 0.15);
        int centWidth = this.dimensionWidth - westWidth - eastWidth;
        int southHeight = (int) (this.dimensionHeight * 0.04);
        
        centPanel.setBounds(westWidth, 0, centWidth, southPanelSize);
        westSidePanel.setBounds(0, 0, westWidth, southPanelSize);
        southSidePanel.setBounds(0, southPanelSize, this.dimensionWidth, southHeight);
        eastSidePanel.setBounds(centWidth + westWidth, 0, eastWidth, southPanelSize);

        westSidePanel.setBackground(Color.WHITE);
        southSidePanel.setBackground(Color.GRAY);
        eastSidePanel.setBackground(Color.WHITE);

        mainPanel.setLayout(null);
        eastSidePanel.setLayout(null);
        
        mainPanel.add(centPanel);
        mainPanel.add(westSidePanel);
        mainPanel.add(eastSidePanel);
        mainPanel.add(southSidePanel);

        westSidePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        southSidePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        centerPdfView(centPanel);
        createEastSideButtons(eastSidePanel);
        createWestSideTree(westSidePanel);
        createSouthSideButtons(southSidePanel);

        this.myFrame.getContentPane().add(mainPanel);

    }
    
    /**
     * Builds West Side tree for file storing and branching.
     */
    private void createWestSideTree(final JPanel theWestSidePanel) {
		this.jt = new JTree(new TreeInit().getTree());
		theWestSidePanel.add(this.jt);
    }
    
    /**
     * 
     * Builds the PDF viewer and allows uploading of PDF's.
     * @param theCentSidePanel
     */
    private void centerPdfView(JPanel theCentSidePanel) {
    	
        // build a controller
        this.controller = new SwingController();

        // Build a SwingViewFactory configured with the controller
        SwingViewBuilder factory = new SwingViewBuilder(controller);
        JPanel viewerComponentPanel = factory.buildViewerPanel();
        
        int southPanelSize = (int) (this.dimensionHeight * 0.84);
        int eastWidth = (int) (this.dimensionWidth * 0.18);
        int westWidth = (int) (this.dimensionWidth * 0.15);
        int centWidth = this.dimensionWidth - westWidth - eastWidth;

        viewerComponentPanel.setPreferredSize(new Dimension(centWidth, southPanelSize));
        viewerComponentPanel.setMaximumSize(new Dimension(centWidth, southPanelSize));
        
        // add copy keyboard command
        ComponentKeyBinding.install(controller, viewerComponentPanel);

        // add interactive mouse link annotation support via callback
        controller.getDocumentViewController().setAnnotationCallback(
        new org.icepdf.ri.common.MyAnnotationCallback(
        controller.getDocumentViewController()));

        theCentSidePanel.add(viewerComponentPanel);
        System.getProperties().put("org.icepdf.core.scaleImages", "true"); 
         //Open a PDF document to view
    }
    
    /**
     * 
     * Creates the menu for the window.
     * @param theFrame the Frame.
     */
    private void createMenu(final JFrame theFrame) {
        JMenuBar menuBar = new JMenuBar();
        theFrame.setJMenuBar(menuBar);
        JMenu more = new JMenu("More");
        final JMenuItem userSetting = new JMenuItem("User Setting");
        final JMenuItem about = new JMenuItem("About");
        final JMenuItem admin = new JMenuItem("Administrator");
        more.add(admin);
        more.add(userSetting);
        more.add(about);

        userSetting.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                JPanel panel = new JPanel(new BorderLayout(5, 5));

                JPanel labels = new JPanel(new BorderLayout());
                labels.add(new JLabel("Name", SwingConstants.RIGHT),BorderLayout.NORTH);
                labels.add(new JLabel("Email:", SwingConstants.RIGHT), BorderLayout.SOUTH);
                panel.add(labels, BorderLayout.WEST);

                JPanel controls = new JPanel(new BorderLayout());
                JTextField name = new JTextField();
                controls.add(name, BorderLayout.NORTH);
                name.setPreferredSize(new Dimension(200, 20));
                JTextField email = new JTextField();
                email.setPreferredSize(new Dimension(200, 20));
                controls.add(email, BorderLayout.SOUTH);
                panel.add(controls, BorderLayout.CENTER);
                int save = JOptionPane.showConfirmDialog(null, panel, "User Setting", JOptionPane.OK_CANCEL_OPTION);
                if(save == 0) {
                    userFirstName = name.getText();
                    userEmail = email.getText();
                    FileWriter toFile = null;
                    try {
                        toFile = new FileWriter(new File("userInfo.txt"), true);
                        toFile.append("First Name: " + userFirstName + ", " + "Email: " + userEmail + "\n");
                        toFile.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        });
        
        admin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                JPanel panel = new JPanel(new BorderLayout(5, 5));

                JPanel labels = new JPanel(new BorderLayout());
                labels.add(new JLabel("ID", SwingConstants.RIGHT),BorderLayout.NORTH);
                labels.add(new JLabel("Password:", SwingConstants.RIGHT), BorderLayout.SOUTH);
                panel.add(labels, BorderLayout.WEST);

                JPanel controls = new JPanel(new BorderLayout());
                JTextField id = new JTextField();
                controls.add(id, BorderLayout.NORTH);
                id.setPreferredSize(new Dimension(200, 20));
                JTextField password = new JTextField();
                password.setPreferredSize(new Dimension(200, 20));
                controls.add(password, BorderLayout.SOUTH);
                panel.add(controls, BorderLayout.CENTER);
                int log = JOptionPane.showConfirmDialog(null, panel, "Admin. Log-in", JOptionPane.OK_CANCEL_OPTION);
                if(log == 0) {
                    adminId = id.getText();
                    adminPass = password.getText();
                    if(adminId.equals("admin") && adminPass.equals("1212")) {
                        adminStatus = true;
                        System.out.println(adminStatus);
                    }
                }
            }
        });
        
        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                JOptionPane.showMessageDialog(null, aboutMessage(), "Developers",
                                              JOptionPane.PLAIN_MESSAGE);
            }
        });
        menuBar.add(more);
    }
    
    /**
     * 
     * Generates the message with current information.
     * @return aboutMessage
     */
    private String aboutMessage() {
        return DEVELOPERS + "\n                                    Version: "
               + this.myVersionNumb;
    }

    /**
     * Sets the version number.
     * 
     * @param theVersionNumb
     */
    public void setVersionNumb(final double theVersionNumb) {
        this.myVersionNumb = theVersionNumb;
    }

    /**
     * Creates buttons for the south layout.
     * 
     * @param theSouthSidePanel 
     */
    private void createSouthSideButtons(final JPanel theSouthSidePanel) {
        final JButton importButton = new JButton("Import");
        final JButton exportButton = new JButton("Export");
        importButton.setBackground(Color.WHITE);
        exportButton.setBackground(Color.WHITE);
        
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
						JOptionPane.showMessageDialog(null, "Imported Settings: " + userInfo);
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
        
        exportButton.addActionListener(new ActionListener() { // exporting functionality by Nicola
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
    				    	toFile.append("First Name: " + userFirstName + ", " + "Email: " + userEmail + "\n");
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
		
        theSouthSidePanel.add(importButton);
        theSouthSidePanel.add(exportButton);
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
	 * Getter for admin status.
	 * 
	 * @return adminStatus
	 */
    private boolean getAdminStatus() {
        return this.adminStatus;
    }
    
    /**
     * Builds east side buttons.
     * 
     * @param theEasthSidePanel
     */
    private void createEastSideButtons(final JPanel theEasthSidePanel) {
        JButton addButton = new JButton("ADD");
        addButton.setBounds(16, 207, 117, 29);
        theEasthSidePanel.add(addButton);

        JButton removeButton = new JButton("REMOVE");
        removeButton.setBounds(127, 207, 117, 29);
        theEasthSidePanel.add(removeButton);
        
        JButton extraButton = new JButton("EXTRA");
        extraButton.setBounds(16, 260, 117, 29);
        theEasthSidePanel.add(extraButton);
        
        JLabel selectLabel = new JLabel("Select an item to add to or remove");
        selectLabel.setBounds(16, 99, 228, 16);
        theEasthSidePanel.add(selectLabel);

        JTextField input = new JTextField();
        input.setBounds(78, 139, 130, 26);
        theEasthSidePanel.add(input);
        input.setColumns(10);

        JLabel itemLabel = new JLabel("Item:");
        itemLabel.setBounds(31, 144, 61, 16);
        theEasthSidePanel.add(itemLabel);
        
        JButton uploadFile = new JButton("Upload PDF");
        uploadFile.setBounds(16, 290, 117, 29);
        theEasthSidePanel.add(uploadFile);
        
        JButton viewPdf = new JButton("View PDF");
        viewPdf.setBounds(16, 320, 117, 29);
        theEasthSidePanel.add(viewPdf);
        
        
        uploadFile.setBackground(Color.RED);
        
        
        viewPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    
				 DefaultTreeModel model = (DefaultTreeModel) jt.getModel();

	                TreePath[] paths = jt.getSelectionPaths();
	                if (paths != null) {
	                    for (TreePath path : paths) {
	                        DefaultMutableTreeNode node = (DefaultMutableTreeNode) 
	                            path.getLastPathComponent();
	                        if (node.getParent() != null) {
	                        	 String name = node.toString();
	                        	 String currentPath = map.getOrDefault(name, "NO");
	                        	 if (!currentPath.equals("NO")) {
	                        		 
	                        		 
	                        		 
	                        		 
	                        		 controller.openDocument(currentPath);
	                        		 
	                        		 
	                        		 
	                        		 
	                        		 
	                        	 }
	                        }
	                    }
	                }
	                
	                jt.updateUI();

			}
		});
        
        uploadFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser myFileChooser = new JFileChooser();
				
                final int result = myFileChooser.showSaveDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                   
                        String path = myFileChooser.getSelectedFile().getAbsolutePath();
                        filePath = path;
                        String fileName = myFileChooser.getSelectedFile().getName();
                        
                        map.put(fileName, path);
                        
                        DefaultMutableTreeNode SelectedNode;

    		            treePath = jt.getSelectionPath();
    		            SelectedNode = (DefaultMutableTreeNode) treePath
    		                    .getLastPathComponent();

    		            index = SelectedNode.getIndex(SelectedNode) + 1;

    		            String NodeStr = fileName;

    		            node = new DefaultMutableTreeNode(NodeStr);
    		            SelectedNode.insert(node, index);
    		            jt.updateUI();
    		            controller.openDocument(filePath);
                }
				
			}
		});
        
        
        addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
		            DefaultMutableTreeNode SelectedNode;

		            treePath = jt.getSelectionPath();
		            SelectedNode = (DefaultMutableTreeNode) treePath
		                    .getLastPathComponent();

		            index = SelectedNode.getIndex(SelectedNode) + 1;

		            String NodeStr = input.getText();

		            node = new DefaultMutableTreeNode(NodeStr);
		            SelectedNode.insert(node, index);
		            jt.updateUI();
			}
		});
        
        removeButton.addActionListener(new ActionListener() {
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

        extraButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, EXTRA_INFO, "Extra Information", JOptionPane.PLAIN_MESSAGE);
			}
		});
    }
    
    
    /**
     * It makes the frame to locate in center of window screen.
     * 
     * @param theFrame representing my frame
     */
    private void centerWindow(final Window theFrame) {
        final Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        final int x = (int) ((dimension.getWidth() - theFrame.getWidth()) / 2);
        final int y = (int) ((dimension.getHeight() - theFrame.getHeight()) / 2);
        theFrame.setLocation(x, y);
    }
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppGUI window = new AppGUI();
                    window.run();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
