package de.hoffit.tipp.view.component;

import java.awt.EventQueue;

import javax.swing.JDialog;
import net.miginfocom.swing.MigLayout;
import javax.swing.JList;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class TeamEditDialog extends JDialog {
	private JList list;
	private JTextField textField;
	private JLabel lblTeamName;
	private JButton btnAddTeam;
	private JButton btnRemoveTeam;
	private JButton btnEditTeam;
	private JButton btnRemoveAll;
	private JButton btnOk;
	private JButton btnCancel;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TeamEditDialog dialog = new TeamEditDialog();
//					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//					dialog.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the dialog.
	 */
	public TeamEditDialog() {

		initComponents();
	}
	private void initComponents() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new MigLayout("", "[grow][50px][grow]", "[grow][10px][grow][][][20px][]"));
		{
			this.list = new JList();
			this.list.setBorder(new TitledBorder(null, "Teams", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			getContentPane().add(this.list, "cell 0 0 1 3,grow");
		}
		{
			this.lblTeamName = new JLabel("Team Name");
			getContentPane().add(this.lblTeamName, "flowx,cell 2 0,aligny bottom");
		}
		{
			this.textField = new JTextField();
			this.lblTeamName.setLabelFor(this.textField);
			getContentPane().add(this.textField, "cell 2 0,growx,aligny bottom");
			this.textField.setColumns(10);
		}
		{
			this.btnAddTeam = new JButton("Add Team");
			getContentPane().add(this.btnAddTeam, "cell 2 2,growx,aligny top");
		}
		{
			this.btnRemoveTeam = new JButton("Remove Team");
			getContentPane().add(this.btnRemoveTeam, "cell 2 3,growx");
		}
		{
			this.btnRemoveAll = new JButton("Remove All");
			getContentPane().add(this.btnRemoveAll, "cell 0 4,growx");
		}
		{
			this.btnEditTeam = new JButton("Edit Team");
			getContentPane().add(this.btnEditTeam, "cell 2 4,growx");
		}
		{
			this.btnOk = new JButton("Ok");
			getContentPane().add(this.btnOk, "flowx,cell 0 6 3 1,alignx center");
		}
		{
			this.btnCancel = new JButton("Cancel");
			getContentPane().add(this.btnCancel, "cell 0 6 3 1,alignx center");
		}
	}

}
