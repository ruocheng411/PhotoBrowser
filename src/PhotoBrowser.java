import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;

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
	ArrayList<JToggleButton> optionsListJTB = new ArrayList<JToggleButton>();
 
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
	
	private void addOptionsJTB(){
		JToggleButton familyJTB = new JToggleButton("Family");
		familyJTB.addActionListener(event->familyJTBfunc());
		JToggleButton vacationJTB = new JToggleButton("Vaction");
		vacationJTB.addActionListener(event->vacationJTBfunc());
		JToggleButton schoolJTB = new JToggleButton("School"); 
		schoolJTB.addActionListener(event->schoolJTBfunc());
		optionsListJTB.add(familyJTB);
		optionsListJTB.add(vacationJTB);
		optionsListJTB.add(schoolJTB);
	}
	private void setSizeOfOptionsList(){
		
		Dimension maximumSize = new Dimension(60, 20);
		Dimension minimumSize = new Dimension(60, 20);
		for(JToggleButton button : optionsListJTB){
			button.setMaximumSize(maximumSize);
			button.setMinimumSize(minimumSize);
		}
		
	}
	
	private void addToolBar(){
		addOptionsJTB();
		setSizeOfOptionsList();
		for(JToggleButton button : optionsListJTB){
			toolBar.add(button);
		}

		add(toolBar,java.awt.BorderLayout.NORTH);

	}
	private void familyJTBfunc(){
		setStatusMes("Famile");
	}

	private void vacationJTBfunc(){
		setStatusMes("Vacation");
	}
	
	private void schoolJTBfunc(){
		setStatusMes("School");
	}

	private void addPanel(){
		panel.setBackground(Color.white);
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
		addPanel();
		addStatusBar();
		addToolBar();

		pack();
	}
	public void importFileFunc(){
		setStatusMes("Import File");
		int returnVal = fileChooser.showOpenDialog(null);
	}

	public void deleteFileFunc(){
		setStatusMes("Delete File");
	}

	public void photoViewFunc(){
		setStatusMes("Photo");
	}

	public void browserViewFunc(){
		setStatusMes("Browser");
	}
	public void splitModeViewFunc(){
		setStatusMes("Split Mode");
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

