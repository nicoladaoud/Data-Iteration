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
import java.io.FileWriter;
import java.io.IOException;
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
import javax.swing.SwingConstants;

public class AppGUI {

    private static final String DEVELOPERS =
                    "Tyler Phippen, Nicola Daoud, Gyubeom Kim, and Jun Kim";

    /**
     * This is frame.
     */
    private JFrame myFrame;

    /**
     * This is file chooser.
     */
    private JFileChooser myFileChooser;

    /**
     * ...
     */
    private double myVersionNumb;
    
    /**
     * 
     */
    private String userFirstName;
    
    /**
     * 
     */
    private String userEmail;
    
    /**
     * ...
     */
    public AppGUI() {
        this.myFrame = new JFrame("User Guide");
        this.myFileChooser = new JFileChooser(".");
        this.myVersionNumb = 1.0;
        this.userFirstName = "";
        this.userEmail = "";
        myFrame.setBounds(100, 100, 873, 798);
    }
    
    /**
     * ...
     */
    public void run() {
        createPanel();
        createMenu(this.myFrame);
        centerWindow(this.myFrame);
        myFrame.setVisible(true);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    /**
     * ...
     */
    private void createPanel() {
        myFrame.getContentPane().setLayout(new BorderLayout(0, 0));
        final JPanel mainPanel = new JPanel();
        final JPanel westSidePanel = new JPanel();
        final JPanel southSidePanel = new JPanel();
        final JPanel eastSidePanel = new JPanel();

        westSidePanel.setBounds(0, 0, 229, 717);
        southSidePanel.setBounds(0, 717, 873, 39);
        eastSidePanel.setBounds(623, 0, 250, 717);

        westSidePanel.setBackground(Color.WHITE);
        southSidePanel.setBackground(Color.GRAY);
        eastSidePanel.setBackground(Color.WHITE);

        mainPanel.setLayout(null);
        eastSidePanel.setLayout(null);
        
        mainPanel.add(westSidePanel);
        mainPanel.add(eastSidePanel);
        mainPanel.add(southSidePanel);

        westSidePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        southSidePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        createEastSideButtons(eastSidePanel);
        createSouthSideButtons(southSidePanel);

        this.myFrame.getContentPane().add(mainPanel);
    }

    private void westSideFunction(final JPanel theWestSidePanel) {

    }
    
    /**
     * ...
     * @param theFrame ...
     */
    private void createMenu(final JFrame theFrame) {
        JMenuBar menuBar = new JMenuBar();
        theFrame.setJMenuBar(menuBar);
        JMenu more = new JMenu("More");
        final JMenuItem userSetting = new JMenuItem("User Setting");
        final JMenuItem about = new JMenuItem("About");
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
     * ...
     * @return ...
     */
    private String aboutMessage() {
        return DEVELOPERS + "\n                                    Version: "
               + this.myVersionNumb;
    }

    /**
     * ...
     * 
     * @param theVersionNumb ...
     */
    public void setVersionNumb(final double theVersionNumb) {
        this.myVersionNumb = theVersionNumb;
    }

    /**
     * ...
     * 
     * @param theSouthSidePanel ...
     */
    private void createSouthSideButtons(final JPanel theSouthSidePanel) {
        final JButton importButton = new JButton("Import");
        final JButton exportButton = new JButton("Export");
        importButton.setBackground(Color.WHITE);
        exportButton.setBackground(Color.WHITE);
        theSouthSidePanel.add(importButton);
        theSouthSidePanel.add(exportButton);
    }
    
    /**
     * ...
     * @param theEasthSidePanel ...
     */
    private void createEastSideButtons(final JPanel theEasthSidePanel) {
        JButton addButton = new JButton("ADD");
        addButton.setBounds(16, 207, 117, 29);
        theEasthSidePanel.add(addButton);

        JButton removeButton = new JButton("REMOVE");
        removeButton.setBounds(127, 207, 117, 29);
        theEasthSidePanel.add(removeButton);

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
    /*public static void main(String[] args) {
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
    }*/
}
