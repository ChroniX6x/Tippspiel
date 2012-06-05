package de.hoffit.tipp.view.component;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDialog;
import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

public class SeasonEditDialog extends JDialog {
	private JComboBox comboBox;
	private JLabel lblDayChoice;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	private JComboBox comboBox_3;
	private JComboBox comboBox_4;
	private JComboBox comboBox_5;
	private JComboBox comboBox_6;
	private JComboBox comboBox_7;
	private JComboBox comboBox_8;
	private JComboBox comboBox_9;
	private JComboBox comboBox_10;
	private JComboBox comboBox_11;
	private JComboBox comboBox_12;
	private JComboBox comboBox_13;
	private JComboBox comboBox_14;
	private JComboBox comboBox_15;
	private JComboBox comboBox_16;
	private JComboBox comboBox_17;
	private JComboBox comboBox_18;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JLabel lblHomeTeam;
	private JLabel lblGuestTeam;
	private JLabel lblDate;
	private JLabel lblGame;
	private JPanel panel_1;
	private JList list;
	private JList list_1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

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
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		{
			this.tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			getContentPane().add(this.tabbedPane);
			{
				this.panel_1 = new JPanel();
				this.tabbedPane.addTab("Teams", null, this.panel_1, null);
				this.panel_1.setLayout(new MigLayout("", "[grow][][grow]", "[grow]"));
				{
					this.list = new JList();
					this.list.setBorder(new TitledBorder(null, "All Teams", TitledBorder.LEADING, TitledBorder.TOP, null, null));
					this.panel_1.add(this.list, "cell 0 0,grow");
				}
				{
					this.btnNewButton = new JButton("<<");
					this.panel_1.add(this.btnNewButton, "flowy,cell 1 0");
				}
				{
					this.list_1 = new JList();
					this.list_1.setBorder(new TitledBorder(null, "Season Teams", TitledBorder.LEADING, TitledBorder.TOP, null, null));
					this.panel_1.add(this.list_1, "cell 2 0,grow");
				}
				{
					this.btnNewButton_1 = new JButton(">>");
					this.panel_1.add(this.btnNewButton_1, "cell 1 0");
				}
			}
			{
				this.panel = new JPanel();
				this.tabbedPane.addTab("Games", null, this.panel, null);
				this.panel
						.setLayout(new MigLayout("", "[center][grow][grow][grow][grow][grow][grow][grow][grow][grow]", "[][bottom][grow][grow][grow]"));

				{
					this.lblDayChoice = new JLabel("Day Choice");
					this.panel.add(this.lblDayChoice,
							"flowx,cell 0 0 10 1,alignx center");
				}
				{
					this.comboBox = new JComboBox();
					this.panel.add(this.comboBox, "cell 0 0 10 1,alignx center");
				}
				{
					this.lblGame = new JLabel("Game 1");
					this.panel.add(this.lblGame, "cell 1 1,alignx center,aligny bottom");
				}
				{
					this.lblHomeTeam = new JLabel("Home Team");
					this.panel.add(this.lblHomeTeam, "cell 0 2,alignx center");
				}
				{
					this.comboBox_1 = new JComboBox();
					this.panel.add(this.comboBox_1, "cell 1 2,growx");
				}
				{
					this.comboBox_2 = new JComboBox();
					this.panel.add(this.comboBox_2, "cell 2 2,growx");
				}
				{
					this.comboBox_3 = new JComboBox();
					this.panel.add(this.comboBox_3, "cell 3 2,growx");
				}
				{
					this.comboBox_4 = new JComboBox();
					this.panel.add(this.comboBox_4, "cell 4 2,growx");
				}
				{
					this.comboBox_5 = new JComboBox();
					this.panel.add(this.comboBox_5, "cell 5 2,growx");
				}
				{
					this.comboBox_6 = new JComboBox();
					this.panel.add(this.comboBox_6, "cell 6 2,growx");
				}
				{
					this.comboBox_7 = new JComboBox();
					this.panel.add(this.comboBox_7, "cell 7 2,growx");
				}
				{
					this.comboBox_8 = new JComboBox();
					this.panel.add(this.comboBox_8, "cell 8 2,growx");
				}
				{
					this.comboBox_9 = new JComboBox();
					this.panel.add(this.comboBox_9, "cell 9 2,growx");
				}
				{
					this.lblGuestTeam = new JLabel("Guest Team");
					this.panel.add(this.lblGuestTeam, "cell 0 3,alignx center");
				}
				{
					this.comboBox_10 = new JComboBox();
					this.panel.add(this.comboBox_10, "cell 1 3,growx");
				}
				{
					this.comboBox_11 = new JComboBox();
					this.panel.add(this.comboBox_11, "cell 2 3,growx");
				}
				{
					this.comboBox_12 = new JComboBox();
					this.panel.add(this.comboBox_12, "cell 3 3,growx");
				}
				{
					this.comboBox_13 = new JComboBox();
					this.panel.add(this.comboBox_13, "cell 4 3,growx");
				}
				{
					this.comboBox_14 = new JComboBox();
					this.panel.add(this.comboBox_14, "cell 5 3,growx");
				}
				{
					this.comboBox_15 = new JComboBox();
					this.panel.add(this.comboBox_15, "cell 6 3,growx");
				}
				{
					this.comboBox_16 = new JComboBox();
					this.panel.add(this.comboBox_16, "cell 7 3,growx");
				}
				{
					this.comboBox_17 = new JComboBox();
					this.panel.add(this.comboBox_17, "cell 8 3,growx");
				}
				{
					this.comboBox_18 = new JComboBox();
					this.panel.add(this.comboBox_18, "cell 9 3,growx");
				}
				{
					this.lblDate = new JLabel("Date");
					this.panel.add(this.lblDate, "cell 0 4,alignx center");
				}
				{
					this.textField = new JTextField();
					this.panel.add(this.textField, "cell 1 4,growx");
					this.textField.setColumns(10);
				}
				{
					this.textField_1 = new JTextField();
					this.panel.add(this.textField_1, "cell 2 4,growx");
					this.textField_1.setColumns(10);
				}
				{
					this.textField_2 = new JTextField();
					this.panel.add(this.textField_2, "cell 3 4,growx");
					this.textField_2.setColumns(10);
				}
				{
					this.textField_3 = new JTextField();
					this.panel.add(this.textField_3, "cell 4 4,growx");
					this.textField_3.setColumns(10);
				}
				{
					this.textField_4 = new JTextField();
					this.panel.add(this.textField_4, "cell 5 4,growx");
					this.textField_4.setColumns(10);
				}
				{
					this.textField_5 = new JTextField();
					this.panel.add(this.textField_5, "cell 6 4,growx");
					this.textField_5.setColumns(10);
				}
				{
					this.textField_6 = new JTextField();
					this.panel.add(this.textField_6, "cell 7 4,growx");
					this.textField_6.setColumns(10);
				}
				{
					this.textField_7 = new JTextField();
					this.panel.add(this.textField_7, "cell 8 4,growx");
					this.textField_7.setColumns(10);
				}
				{
					this.textField_8 = new JTextField();
					this.panel.add(this.textField_8, "cell 9 4,growx");
					this.textField_8.setColumns(10);
				}
			}
		}

	}

}
