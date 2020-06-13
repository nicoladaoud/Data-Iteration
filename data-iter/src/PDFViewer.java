import java.awt.Dimension;

import javax.swing.JPanel;

import org.icepdf.ri.common.ComponentKeyBinding;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;

public class PDFViewer {

	/**
	 * The controller for pdf
	 */
	public SwingController controller;
	/**
	 * The height
	 */
	public int dimensionHeight = 1000;
	/**
	 * The Width
	 */
	public int dimensionWidth = 1600;
	/**
	 * The panel to hold PDF file
	 */
	public JPanel viewerComponentPanel;
	
	public PDFViewer() {
		
	}
	 public void centerPdfView(JPanel theCentSidePanel) {
	    	
	        // build a controller
	        this.controller = new SwingController();

	        // Build a SwingViewFactory configured with the controller
	        SwingViewBuilder factory = new SwingViewBuilder(controller);
	        viewerComponentPanel = factory.buildViewerPanel();
	        
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

	      
	    }
}
