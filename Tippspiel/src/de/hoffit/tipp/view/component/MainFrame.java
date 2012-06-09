package de.hoffit.tipp.view.component;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {

	public static final String SEASON_PLAYERS = "seasonPlayers";

	public static final String SEASON_PREFERENCES = "seasonPreferences";

	private static final long serialVersionUID = -1826574838238810551L;

	private JPanel contentPane;
	private JTabbedPane viewTabbedPane;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenuItem mntmNew;
	private JMenuItem mntmOpen;
	private JMenuItem mntmOpenRecent;
	private JMenuItem mntmSave;
	private JMenuItem mntmSaveAs;
	private JMenuItem mntmClose;
	private JMenu mnEdit;
	private JMenu mnSeason;
	private JMenuItem mntmPreferences;
	private JMenuItem mntmPlayer;

	// /**
	// * Launch the application.
	// */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// MainFrame frame = new MainFrame();
	// frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		initComponents();
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		this.menuBar = new JMenuBar();
		setJMenuBar(this.menuBar);

		this.mnFile = new JMenu("File\r\n");
		this.menuBar.add(this.mnFile);

		this.mntmNew = new JMenuItem("New");
		this.mnFile.add(this.mntmNew);

		this.mntmOpen = new JMenuItem("Open");
		this.mnFile.add(this.mntmOpen);

		this.mntmOpenRecent = new JMenuItem("Open recent");
		this.mnFile.add(this.mntmOpenRecent);

		this.mntmSave = new JMenuItem("Save");
		this.mnFile.add(this.mntmSave);

		this.mntmSaveAs = new JMenuItem("Save As");
		this.mnFile.add(this.mntmSaveAs);

		this.mntmClose = new JMenuItem("Close");
		this.mnFile.add(this.mntmClose);

		this.mnEdit = new JMenu("Edit");
		this.menuBar.add(this.mnEdit);
		{
			this.mnSeason = new JMenu("Season");
			this.menuBar.add(this.mnSeason);
			{
				this.mntmPlayer = new JMenuItem("Player");
				this.mnSeason.add(this.mntmPlayer);
			}
			{
				this.mntmPreferences = new JMenuItem("Preferences");
				this.mnSeason.add(this.mntmPreferences);
			}
		}

		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(new BorderLayout(0, 0));

		setContentPane(this.contentPane);

		this.viewTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		this.contentPane.add(this.viewTabbedPane);
	}

	public void addViewPanel(String title, JComponent panel) {
		JScrollPane scrollPane = new JScrollPane(panel);

		this.viewTabbedPane.add(title, scrollPane);
	}

	public void setActionListener(ActionListener a) {
		this.mntmPreferences.addActionListener(a);
		this.mntmPreferences.setActionCommand(SEASON_PREFERENCES);
		
		this.mntmPlayer.addActionListener(a);
		this.mntmPlayer.setActionCommand(SEASON_PLAYERS);
	}
}
