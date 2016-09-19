
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.event.WindowEvent;

import javax.sound.midi.VoiceStatus;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

public class PhotoBrowser extends JFrame{
	JMenuBar menuBar = new JMenuBar();  
    JMenu fileMenu = new JMenu("File");  
    JMenu viewMenu = new JMenu("View"); 
    JMenuItem importFile = new JMenuItem("Import");
    JMenuItem deleteFile = new JMenuItem("Delete");
    JMenuItem quitFile = new JMenuItem("Quit");
    
    JFileChooser fileChooser = new JFileChooser();
    JRadioButton photoView = new JRadioButton("Photo");
    JRadioButton browserView = new JRadioButton("Browser");
    JRadioButton splitModeView = new JRadioButton("Split mode");
    
    JPanel statusPanel = new JPanel();
    JLabel statusLabel = new JLabel("status");
    
    JToolBar toolBar = new JToolBar();
    JToggleButton familyJTB = new JToggleButton("Family");
    JToggleButton vacationJTB = new JToggleButton("Vaction");
    JToggleButton schoolJTB = new JToggleButton("School");    
    String message = new String("");
    
	
	public static void main(String argv[]){
		PhotoBrowser myBrowser = new PhotoBrowser();
		myBrowser.setSize(600,400);
		myBrowser.setVisible(true);
	}
	public PhotoBrowser(){
		super("Photo Browser");
//		getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT));
		getContentPane().setLayout(new BorderLayout());
		
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		// File Menu
		importFile.addActionListener(
				event -> importFileFunc()
				);
		fileMenu.add(importFile);
		deleteFile.addActionListener(			
				event -> deleteFileFunc()
				);
		fileMenu.add(deleteFile);
		
		quitFile.addActionListener(
				event ->this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING))
				);
		fileMenu.add(quitFile);
		
		// View Menu
		photoView.addActionListener(
				Event -> photoViewFunc()
				);
		viewMenu.add(photoView);
		browserView.addActionListener(
				event -> browserViewFunc()
				);
		viewMenu.add(browserView);
		splitModeView.addActionListener(
				Event -> splitModeViewFunc()
				);
		viewMenu.add(splitModeView);

	    menuBar.add(fileMenu);
	    menuBar.add(viewMenu);
	    setJMenuBar(menuBar);
	    

	    statusBar(message);
//	    add(statusLabel,java.awt.BorderLayout.SOUTH);
	    add(statusPanel,java.awt.BorderLayout.SOUTH);
	    
	    toolBar.add(familyJTB);
	    toolBar.add(vacationJTB);
	    toolBar.add(schoolJTB);
	    familyJTB.setBorderPainted(true);
	    

	    add(toolBar,java.awt.BorderLayout.NORTH);
	    
	    pack();
	}
	public void importFileFunc(){
		fileChooser.showOpenDialog(null);
	}
	
	public void deleteFileFunc(){
		message = "Delete File";
//		System.out.println(message);
	}
	
	public void photoViewFunc(){
		message = "Photo";
	}
	
	public void browserViewFunc(){
		message = "Browser";
	}
	public void splitModeViewFunc(){
		message = "Split Mode";
	}
	
	public void statusBar(String message){
		statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
		add(statusPanel,BorderLayout.SOUTH);
		statusPanel.setPreferredSize(new Dimension(this.getWidth(), 16));
		statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));
		statusPanel.setBackground(Color.LIGHT_GRAY);
		
	    statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
	    statusLabel.setPreferredSize(new Dimension(100,16));
	    statusLabel.setText("Status : " + message);
	    
	    statusPanel.add(statusLabel, BorderLayout.WEST);
	}

}

//statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
//add(statusPanel,BorderLayout.SOUTH);
//statusPanel.setPreferredSize(new Dimension(this.getWidth(), 16));
//statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));

//getContentPane().add(statusLabel, );
//statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
//statusLabel.setPreferredSize(new Dimension(100,16));
//statusLabel.setText("status");