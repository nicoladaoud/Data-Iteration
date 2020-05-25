import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.EventQueue;

public class AboutBox {
	private static final String DEVELOPERS = "Tyler Phippen, Nicola Daoud, Gyubeom Kim, and Jun Kim";

	/**
	 * set up Frame.
	 */
	private final JFrame myMain;

	/**
	 * ...
	 */
	private double myVersionNumb;

	/**
	 * ...
	 */
	public AboutBox() {
		this.myMain = new JFrame("Iteration0-Demo");
		this.setVersionNumb(1.0);
	}

	/**
	 * ...
	 */
	public void start() {

		myMain.setSize(500, 500);
		myMain.setLayout(null);
		myMain.setVisible(true);
		centerWindow(myMain);
		//myMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// panel
		final JPanel panel = new JPanel();
		panel.setBounds(0, 0, 500, 500);
		panel.setLayout(null);
		myMain.add(panel);

		// label and Button 
		final JLabel label1 = new JLabel("Version: WildCats" + getVersionNumb());
		final JButton button1 = new JButton("About");
		label1.setBounds(180, 150, 95, 30);
		button1.setBounds(200, 200, 95, 30);
		label1.setSize(label1.getPreferredSize());
		panel.add(button1);
		panel.add(label1);
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theEvent) {
				JOptionPane.showMessageDialog(null, DEVELOPERS, "Developers", JOptionPane.PLAIN_MESSAGE);
			}
		});
	}

	/**
	 * ...
	 * 
	 * @return ...
	 */
	public double getVersionNumb() {
		return myVersionNumb;
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
	 * Main method.
	 * 
	 * @param theArgs arguments.
	 */
	
	
	 public static void main(final String[] theArgs) { 
		 EventQueue.invokeLater(new Runnable() {
			 @Override 
			 public void run() {
				 final AboutBox mainFrame = new AboutBox(); 
				 mainFrame.start(); 
		 	} 
		 }); 
	 }
		 

	/**
	 * .
	 * 
	 * @param theFrame ...
	 */
	private void centerWindow(final Window theFrame) {
		final Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		final int x = (int) ((dimension.getWidth() - theFrame.getWidth()) / 2);
		final int y = (int) ((dimension.getHeight() - theFrame.getHeight()) / 2);
		theFrame.setLocation(x, y);
	}

}
