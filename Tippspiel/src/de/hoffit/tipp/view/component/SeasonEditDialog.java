package de.hoffit.tipp.view.component;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;

@SuppressWarnings({"serial","rawtypes"})
public class SeasonEditDialog extends JDialog {

	// Game Adding
	
	private JComboBox comboBox;
	private JLabel lblDayChoice;

	private JComboBox[] homeTeams;

	private JComboBox[] guestTeams;

	private JTextField[] gameDates;

	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JLabel lblHomeTeam;
	private JLabel lblGuestTeam;
	private JLabel lblDate;

	private JLabel[] gameLabels;

	// Team Adding
	private JPanel panel_1;
	private JList list;
	private JTextField textField9;
	private JLabel lblTeamName;
	private JButton btnAddTeam;
	private JButton btnRemoveTeam;
	private JButton btnEditTeam;
	private JButton btnRemoveAll;
	private JButton btnOk;
	private JButton btnCancel;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// SeasonEditDialog dialog = new SeasonEditDialog();
	// dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	// dialog.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Create the dialog.
	 */
	public SeasonEditDialog() {

		initComponents();
	}

	private void initComponents() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());

		{
			this.tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			getContentPane().add(this.tabbedPane);
			{
				this.panel_1 = new JPanel();
				this.tabbedPane.addTab("Teams", null, this.panel_1, null);
				this.panel_1.setLayout(new MigLayout("", "[grow][50px][grow]",
						"[grow][10px][grow][][][20px][]"));
				{
					this.list = new JList();
					this.list
							.setBorder(new TitledBorder(null, "Teams",
									TitledBorder.LEADING, TitledBorder.TOP,
									null, null));
					this.panel_1.add(this.list, "cell 0 0 1 3,grow");
				}
				{
					this.lblTeamName = new JLabel("Team Name");
					this.panel_1.add(this.lblTeamName,
							"flowx,cell 2 0,aligny bottom");
				}
				{
					this.textField9 = new JTextField();
					this.lblTeamName.setLabelFor(this.textField9);
					this.panel_1.add(this.textField9,
							"cell 2 0,growx,aligny bottom");
					this.textField9.setColumns(10);
				}
				{
					this.btnAddTeam = new JButton("Add Team");
					this.panel_1.add(this.btnAddTeam,
							"cell 2 2,growx,aligny top");
				}
				{
					this.btnRemoveTeam = new JButton("Remove Team");
					this.panel_1.add(this.btnRemoveTeam, "cell 2 3,growx");
				}
				{
					this.btnRemoveAll = new JButton("Remove All");
					this.panel_1.add(this.btnRemoveAll, "cell 0 4,growx");
				}
				{
					this.btnEditTeam = new JButton("Edit Team");
					this.panel_1.add(this.btnEditTeam, "cell 2 4,growx");
				}
				{
					this.btnOk = new JButton("Ok");
					this.panel_1.add(this.btnOk,
							"flowx,cell 0 6 3 1,alignx center");
				}
				{
					this.btnCancel = new JButton("Cancel");
					this.panel_1.add(this.btnCancel,
							"cell 0 6 3 1,alignx center");
				}
			}
			{
				this.panel = new JPanel();
				this.tabbedPane.addTab("Games", null, this.panel, null);
				this.panel
						.setLayout(new MigLayout(
								"",
								"[center][grow][grow][grow][grow][grow][grow][grow][grow][grow]",
								"[][bottom][grow][grow][grow]"));

				{
					this.lblDayChoice = new JLabel("Day Choice");
					this.panel.add(this.lblDayChoice,
							"flowx,cell 0 0 10 1,alignx center");
				}
				{
					this.comboBox = new JComboBox();
					this.panel
							.add(this.comboBox, "cell 0 0 10 1,alignx center");
				}
				{
					this.gameLabels = new JLabel[9];
					for (int i = 0; i < this.gameLabels.length; i++) {
						JLabel label = new JLabel("Game" + (i + 1));
						this.gameLabels[i] = label;
						this.panel.add(label, "cell " + (i + 1)
								+ " 1,alignx center,aligny bottom");
					}
				}
				{
					this.lblHomeTeam = new JLabel("<html>Home<br> Team</html>");
					this.panel.add(this.lblHomeTeam, "cell 0 2,alignx center");
				}
				{
					this.homeTeams = new JComboBox[9];
					for (int i = 0; i < this.homeTeams.length; i++) {
						JComboBox comboBox = new JComboBox();
						this.homeTeams[i] = comboBox;
						this.panel
								.add(comboBox, "cell " + (i + 1) + " 2,growx");
					}
				}
				{
					this.lblGuestTeam = new JLabel(
							"<html>Guest<br> Team</html>");
					this.panel.add(this.lblGuestTeam, "cell 0 3,alignx center");
				}
				{
					this.guestTeams = new JComboBox[9];
					for (int i = 0; i < this.guestTeams.length; i++) {
						JComboBox comboBox = new JComboBox();
						this.guestTeams[i] = comboBox;
						this.panel
								.add(comboBox, "cell " + (i + 1) + " 3,growx");
					}
				}
				{
					this.lblDate = new JLabel("Date");
					this.panel.add(this.lblDate, "cell 0 4,alignx center");
				}
				{
					this.gameDates = new JTextField[9];
					for (int i = 0; i < this.gameDates.length; i++) {
						JTextField textField = new JTextField();
						this.gameDates[i] = textField;
						this.panel.add(textField, "cell " + (i + 1)
								+ " 4,growx");
					}
				}
			}
		}

	}

}
