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

	JPanel panel = new JPanel();
	JPanel statusPanel = new JPanel();
	JLabel statusLabel = new JLabel("status");

	JToolBar toolBar = new JToolBar();
	JToggleButton familyJTB = new JToggleButton("Family");
	JToggleButton vacationJTB = new JToggleButton("Vaction");
	JToggleButton schoolJTB = new JToggleButton("School");    
	String message = new String("");
	

	private void setFileMenu(){
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
	}
	private void setViewMenu(){
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

	}

	private void addMenu(){
		setFileMenu();
		setViewMenu();
		menuBar.add(fileMenu);
		menuBar.add(viewMenu);
		setJMenuBar(menuBar);
	}
	private void addToolBar(){
		toolBar.add(familyJTB);
		toolBar.add(vacationJTB);
		toolBar.add(schoolJTB);
		familyJTB.setBorderPainted(true);
		add(toolBar,java.awt.BorderLayout.NORTH);

	}

	private void addPanel(){
		panel.setBackground(Color.lightGray);
		add(panel,BorderLayout.CENTER);
	}
	private void addStatusBar(){
		statusBar();
		//	    add(statusLabel,java.awt.BorderLayout.SOUTH);
		add(statusPanel,java.awt.BorderLayout.SOUTH);
	}

	public PhotoBrowser(){
		super("Photo Browser");
		//		getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT));
		getContentPane().setLayout(new BorderLayout());
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);

		addMenu();
		addStatusBar();
		addToolBar();

		pack();
	}
	public void importFileFunc(){
		setStatusMes("Import File");
		fileChooser.showOpenDialog(null);
	}

	public void deleteFileFunc(){
		message = "Delete File";
		setStatusMes(message);
	}

	public void photoViewFunc(){
		message = "Photo";
		setStatusMes(message);
	}

	public void browserViewFunc(){
		message = "Browser";
		setStatusMes(message);
	}
	public void splitModeViewFunc(){
		message = "Split Mode";
		setStatusMes(message);
	}

	public void statusBar(){
		statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
		add(statusPanel,BorderLayout.SOUTH);
		statusPanel.setPreferredSize(new Dimension(this.getWidth(), 16));
		statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));
		statusPanel.setBackground(Color.LIGHT_GRAY);

		statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
		statusLabel.setPreferredSize(new Dimension(100,16));
		statusLabel.setText(" Status : ");

		statusPanel.add(statusLabel, BorderLayout.WEST);
	}
	
	private void setStatusMes(String message){
		statusLabel.setText(" Status : " + message);
	}
	

	public static void main(String[] args){
		PhotoBrowser myBrowser = new PhotoBrowser();
		myBrowser.setSize(600,400);
		myBrowser.setVisible(true);
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